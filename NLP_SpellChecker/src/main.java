import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class main {
	private static HashSet<String> hashDict() {
		HashSet<String> hs = new HashSet<String>();
		try (Scanner fin = new Scanner(new File("dict"))) {
			   while (fin.hasNextLine()) {
				   String word = fin.next();
				   hs.add(word);
			   }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//	      Iterator itr = hsDict.iterator();
//
//	      while(itr.hasNext())
//	         System.out.println(itr.next()+" ");
//	      System.out.println();

		return hs;
	}

	private static ArrayList<String> addGutenAL() {
		int i = 0;
		ArrayList<String> alGuten = new ArrayList<String>();
//		try (Scanner fin = new Scanner(new File("gutenberg"))) {
//			   while (fin.hasNextLine()) {
//				   String word = fin.next();
//				   i++;
//				   if(i>1440)
//					   System.out.println(word);
//				   word = word.replaceAll("[^a-zA-Z0-9]", "");
//				   word = word.toLowerCase();
//				   alGuten.add(word);
//			   }
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println(i);
		BufferedReader br = null;
		
	      try {
	         br = new BufferedReader(new FileReader(new File("gutenberg")));
	         String availalbe;
	         while((availalbe = br.readLine()) != null) {
	             i++;
	        	 alGuten.add(availalbe);            
	         }
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         if (br != null) {
	            try {
	               br.close();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	      System.out.println(alGuten.size());
		return alGuten;
		
	}

	private static Map<String, Integer> hashCountGuten(ArrayList<String> alGuten) {
		Map<String, Integer> hsCountGuten = new HashMap<String, Integer>();
		for(int i = 0; i<alGuten.size();i++){
			String curr = alGuten.get(i);
			System.out.println("curr "+curr);
	        Integer count = hsCountGuten.get(curr);
	        //System.out.println(curr + ": "+ count);
	        if (count != null) {
	        	hsCountGuten.put(curr, count + 1);
	        } else {
	        	hsCountGuten.put(curr, 1);
	        }
	    }
		return hsCountGuten;
	}

	private static ArrayList<String> permutation(String word) {
		ArrayList<String> permutations = new ArrayList<String>();
		int l = word.length();
		char[] alp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String newS;
		/////////////////////////////Delete
		for(int i=0; i<l; i++){ 
			char[] w2c ;
			w2c = word.toCharArray();
			w2c[i]=' ';
			newS = new String(w2c);
			newS = newS.replaceAll(" ","");
			//System.out.println(newS);
			permutations.add(newS);
		}
		/////////////////////////////Swap
		for(int i=0; i<l-1; i++){ //Swap Characters
			char[] w2c = word.toCharArray();
			char temp = w2c[i];
			w2c[i] = w2c[i+1];
			w2c[i+1] = temp;
			newS = new String(w2c);
			//System.out.println(newS);
			permutations.add(newS);
		}
		/////////////////////////////Change Letter
		for(int i=0; i<l; i++){ 
			for(int j=0; j<alp.length;j++){
				char[] w2c ;
				w2c = word.toCharArray();
				w2c[i]=alp[j];
				newS = new String(w2c);
				newS = newS.replaceAll(" ","");
				//System.out.println(newS);
				permutations.add(newS);
			}
		}
		//////////////////////////////Add
		
		String newWord = "_"+word;
		char[] w2c = newWord.toCharArray();
		for(int i=0; i<alp.length; i++){ //Add Characters in front
			w2c[0] = alp[i];
			newS = new String(w2c);
			//System.out.println(newS);
			permutations.add(newS);
		}
		for(int i=0; i<l; i++){ //Add Characters in between and end
			char temp = w2c[i];
			w2c[i] = w2c[i+1];
			w2c[i+1] = temp;
			for(int j=0; j<alp.length; j++){ 
				w2c[i+1] = alp[j];
				newS = new String(w2c);
				//System.out.println(newS);
				permutations.add(newS);
			}
		}

		
		return permutations;
	}
	private static String[] getUserInput() {
		System.out.println("Spell Checker: ");
		System.out.println("Enter your sentence: ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		String[] Sentence = word.split(" ");
		for(int i = 0;i<Sentence.length;i++) {
			   String current = Sentence[i];
			   current = current.toLowerCase();
			   current = current.replaceAll("[^a-zA-Z0-9]", "");
			   Sentence[i] = current;
		   }
		return Sentence;
	}
	public static void main(String[] args) {

		String[] Sentence = getUserInput();
		
		HashSet<String> hsDict = new HashSet<String>();
		hsDict = hashDict();
		
	    ArrayList<String> alGuten = new ArrayList<String>();
	    alGuten = addGutenAL();
	    
	    Map<String, Integer> hsCountGuten = new HashMap<String, Integer>();
	    hsCountGuten = hashCountGuten(alGuten);
	    

		String[] test = Sentence;
		String bestWord = "No Suggestions...";
		
		for(String currentWord:test){
			ArrayList<String> permutations = new ArrayList<String>();
			if(!hsDict.contains(currentWord)){
				System.out.println("Did not find: " + currentWord);
				permutations = permutation(currentWord);
				ArrayList<String> possible = new ArrayList<String>();
				System.out.println("Possible:");
				System.out.print("\t");
				for(int i =0; i<permutations.size();i++){
					if(hsDict.contains(permutations.get(i))){
						System.out.print(permutations.get(i)+ ", ");
						possible.add(permutations.get(i));
					}
				}
				System.out.println("\nSuggested:");

				int greatestSize=0;
				for(int i =0; i<possible.size();i++){
					if(hsCountGuten.get(possible.get(i))==null ||hsCountGuten.get(possible.get(i)).equals("") ||hsCountGuten.get(possible.get(i)).equals("null")){
						
					}
					else{
						int x = hsCountGuten.get(possible.get(i)).intValue();
						System.out.println(possible.get(i)+x);
						if(x>greatestSize){
							bestWord = possible.get(i);
						}
					}
				}
				if(bestWord.equals("No Suggestions...") && possible.size()>0){
					System.out.println("\t" + possible.get(0));
				}
				else{
				System.out.println("\t" + bestWord);
				}
				bestWord = "No Suggestions...";
				System.out.println();
			}
			
			
		}

	}



	}

