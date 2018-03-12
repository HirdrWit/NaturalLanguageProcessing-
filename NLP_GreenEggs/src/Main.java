import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static void M1() {
		ArrayList<String> key = new ArrayList<String>();
		 key = CreateKey();
		 //int SentenceCount = SentCount()

		 for(int i = 0; i<key.size();i++){
			 String word = key.get(i);
			 System.out.println("Word Searching: " + word);
			 search(word);
		 }

	      
	}
	private static void search(String word) {
		BufferedReader br = null;
		try {
	         br = new BufferedReader(new FileReader(new File("GreenEggs.txt")));
	         int LineNumber = 0;
	         String printSentence;
	         String sentence;
	         while((sentence = br.readLine()) != null) {
	        	 LineNumber++;
	        	 printSentence = sentence;
	        	 sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "");
	        	 sentence = sentence.toLowerCase();
	        	 if(!sentence.isEmpty()){
	        		 String temp[] = sentence.split(" ");
		        	 for(int i = 0; i<temp.length;i++){
		        		if(word.equals(temp[i])){
		        			System.out.println("\t" +"(" + LineNumber + "): " +printSentence);
		        		}

		        	 }
	        	 
	        	 }
	         }
		}
		catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();
	      } finally {if (br != null) {try {br.close();} catch (IOException e) {e.printStackTrace();}}}
	}
	private static ArrayList<String> CreateKey() {
		BufferedReader br = null;
		 ArrayList<String> key = new ArrayList<String>();
		try {
	         br = new BufferedReader(new FileReader(new File("GreenEggs.txt")));
	         String sentence;
	         while((sentence = br.readLine()) != null) {
	        	 sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "");
	        	 sentence = sentence.toLowerCase();
	        	 if(!sentence.isEmpty()){
	        		 //System.out.println(sentence);
	        		 String temp[] = sentence.split(" ");
		        	 for(int i = 0; i<temp.length;i++){
		        		if(key.contains(temp[i])){
		        			
		        		}
		        		else{
		        			key.add(temp[i]);
		        		}
		        	 }
	        	 
	        	 }
	         }
	      } 
	      catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();
	      } finally {if (br != null) {try {br.close();} catch (IOException e) {e.printStackTrace();}}}
	      Collections.sort(key);
		return key;
	}

	public static void main(String args[]){
		System.out.println("Word Finder: ");
		boolean step1 = false;
		boolean step2 = false;
		String choice1 = "else";
		while(!step1){
			System.out.println("Show All Word : 1");
			System.out.println("Search Words : 2");
			System.out.println("Show All Possible Searchable Words : 3");
			Scanner scanner = new Scanner(System.in);
			String entry1 = scanner.nextLine();
			if(entry1.equals("1")){
				System.out.println("Statement 1");
				step1 = true;
			}
			else if(entry1.equals("2")){
				System.out.println("Statement 2");
				step1 = true;
			}
			else if(entry1.equals("3")){
				System.out.println("Statement 3");
				step1 = true;
			}
			else{
				System.out.println("Please type 1, 2 or 3");
			}
			choice1 = entry1;
		}
		while(!step2){
			if(choice1.equals("1")){
				M1();
				step2 = true;
				
			}
			else if(choice1.equals("2")){
				System.out.println("Type in the word/words you would like to search for (seperated by spaces)");
				Scanner scanner = new Scanner(System.in);
				String Sentence = scanner.nextLine();
				String[] words = Sentence.split(" ");
				int returns = 0;
				for(int i = 0 ; i < words.length; i++ ){
					System.out.println(words[i]);
					search(words[i]);
				}
				step2 = true;
			}
			else if(choice1.equals("3")){
				ArrayList<String> key = new ArrayList<String>();
				key = CreateKey();
				for(int i = 0; i<key.size();i++){
					 String word = key.get(i);
					 System.out.println(word);
					 step2 = true;
				 }
			}
		}


	}
}
