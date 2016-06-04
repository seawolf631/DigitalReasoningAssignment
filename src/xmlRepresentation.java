import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class xmlRepresentation {
	String[] x;
	String[][] y;
	public xmlRepresentation(String[] x){
		this.x = x;
	}
	public xmlRepresentation(String[][] y){
		this.y = y;
	}
	public static void sentenceXML(String[] x){
		for(int i = 0; i < x.length; i++)
			System.out.println("<sentence>"+ x[i] + "</sentence>");
	}
	public static void wordXML(String[][] y){
		for(int i = 0; i < y.length; i++){
			System.out.println("<sentence>");
			for(int j = 0; j < y[i].length; j++)
				System.out.println("<word>" + y[i][j] + "</word>");
		System.out.println("</sentence>");
		}
	}
	public static void main(String[] args){
		String fileName = "NLP_test\\nlp_data.txt";
		String line = null;
		try{
			//Variable Declarations
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String paragraph = "";
			String[] sentences;
			String[][] words;
			
			//Reading file into String
			while((line = bufferedReader.readLine()) != null){
				paragraph += line;
			}
			sentences = paragraph.split("(?<=[.!?])\\s*");
			for(String s: sentences)
				System.out.println(s);
			bufferedReader.close();
			//Spliting Sentences by Word
			words = new String[sentences.length][];
			for(int i = 0; i<sentences.length;i++){
				String temp = sentences[i];
				temp = temp.replaceAll("[!?,]", "");
				words[i] = temp.split("\\s+");
			}
			//Making instance of XML representation and printing
			xmlRepresentation x = new xmlRepresentation(words);
			x.wordXML(words);
		} 
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex){
			System.out.println("Error reading file '" + fileName +"'");
		}
	}
}
