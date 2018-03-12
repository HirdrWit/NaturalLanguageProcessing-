import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieGuesser {
	static HashSet<String> Action = new HashSet<String>();
	static HashSet<String> Adventure = new HashSet<String>();
	static HashSet<String> Fantasy = new HashSet<String>();
	static HashSet<String> Science = new HashSet<String>();
	static HashSet<String> Crime = new HashSet<String>();
	static HashSet<String> Drama = new HashSet<String>();
	static HashSet<String> Thriller = new HashSet<String>();
	static HashSet<String> Animation = new HashSet<String>();
	static HashSet<String> Family = new HashSet<String>();
	static HashSet<String> Western = new HashSet<String>();
	static HashSet<String> Comedy = new HashSet<String>();
	static HashSet<String> Romance = new HashSet<String>();
	static HashSet<String> Horror = new HashSet<String>();
	static HashSet<String> Mystery = new HashSet<String>();
	static HashSet<String> History = new HashSet<String>();
	static HashSet<String> War = new HashSet<String>();
	static HashSet<String> Music = new HashSet<String>();
	static HashSet<String> Documentary = new HashSet<String>();
	static HashSet<String> Foreign = new HashSet<String>();
	static HashSet<String> TV = new HashSet<String>();
	public static void main(String args[]){
		boolean lastLineName = false;
		HashSet<String> genres = new HashSet<String>();
		HashMap<String, HashSet<String>> pair= new HashMap<String, HashSet<String>>();
		HashSet<String> words = new HashSet<String>();
		ArrayList<String> hold = new ArrayList<String>();
		ArrayList<String> stopWords = getStopWords();
		BufferedReader br = null;
		
	      try {
	         br = new BufferedReader(new FileReader(new File("movies")));
	         String available;
	         while((available = br.readLine()) != null) {
	        	 available = available.toLowerCase();
	        	 available = available.replaceAll("[^a-zA-Z0-9: ]", "");
	        	 String temp[] = available.split(" ");
	        	 if(lastLineName == true){
	        		 lastLineName = false;
	        		 HashSet<String> keyWords = setKeyWords(temp, stopWords);
	        		for(int i = 0; i<hold.size();i++){
	        			if(hold.get(i).toString().equals("action")){
	        				addToGenre(keyWords, Action);
	        				pair.put("Action", Action);
	        			}
	        			if(hold.get(i).toString().equals("adventure")){
	        				addToGenre(keyWords, Adventure);
	        				pair.put("Adventure", Adventure);
	        			}
	        			if(hold.get(i).toString().equals("fantasy")){
	        				addToGenre(keyWords, Fantasy);
	        				pair.put("Fantasy", Fantasy);
	        			}
	        			if(hold.get(i).toString().equals("science")){
	        				addToGenre(keyWords, Science);
	        				pair.put("Science", Science);
	        			}
	        			if(hold.get(i).toString().equals("crime")){
	        				addToGenre(keyWords, Crime);
	        				pair.put("Crime", Crime);
	        			}
	        			if(hold.get(i).toString().equals("drama")){
	        				addToGenre(keyWords, Drama);
	        				pair.put("Drama", Drama);
	        			}
	        			if(hold.get(i).toString().equals("thriller")){
	        				addToGenre(keyWords, Thriller);
	        				pair.put("Thriller", Thriller);
	        			}
	        			if(hold.get(i).toString().equals("animation")){
	        				addToGenre(keyWords, Animation);
	        				pair.put("Animation", Animation);
	        			}
	        			if(hold.get(i).toString().equals("family")){
	        				addToGenre(keyWords, Family);
	        				pair.put("Family", Family);
	        			}
	        			if(hold.get(i).toString().equals("western")){
	        				addToGenre(keyWords, Western);
	        				pair.put("Western", Western);
	        			}
	        			if(hold.get(i).toString().equals("comedy")){
	        				addToGenre(keyWords, Comedy);
	        				pair.put("Comedy", Comedy);
	        			}
	        			if(hold.get(i).toString().equals("romance")){
	        				addToGenre(keyWords, Romance);
	        				pair.put("Romance", Romance);
	        			}
	        			if(hold.get(i).toString().equals("horror")){
	        				addToGenre(keyWords, Horror);
	        				pair.put("Horror", Horror);
	        			}
	        			if(hold.get(i).toString().equals("mystery")){
	        				addToGenre(keyWords, Mystery);
	        				pair.put("Mystery", Mystery);
	        			}
	        			if(hold.get(i).toString().equals("history")){
	        				addToGenre(keyWords, History);
	        				pair.put("History", History);
	        			}
	        			if(hold.get(i).toString().equals("war")){
	        				addToGenre(keyWords, War);
	        				pair.put("War", War);
	        			}
	        			if(hold.get(i).toString().equals("music")){
	        				addToGenre(keyWords, Music);
	        				pair.put("Music", Music);
	        			}
	        			if(hold.get(i).toString().equals("documentary")){
	        				addToGenre(keyWords, Documentary);
	        				pair.put("Documentary", Documentary);
	        			}
	        			if(hold.get(i).toString().equals("foreign")){
	        				addToGenre(keyWords, Foreign);
	        				pair.put("Foreign", Foreign);
	        			}
	        			if(hold.get(i).toString().equals("tv")){
	        				addToGenre(keyWords, TV);
	        				pair.put("TV", TV);
	        			}
	        		}
	        		hold.clear();
	        	 }
	        	 for(int i=0;i<temp.length-1;i++){
	        		if(temp[i].equals("name:")){
	        			lastLineName = true;
	        			hold.add(temp[i+1].toString());
//	        			if(!temp[i+1].equals(" ") && !genres.contains(temp[i+1].toString())){
//	        				genres.add(temp[i+1].toString());
//	        				System.out.println("HashSet<String> "+ temp[i+1] + " = new HashSet<String>();");
//	        			}
	        		}
	        	 }
	        	 
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
	      getUserInput();
	}

	private static void getUserInput() {
		System.out.println("Paste Movie Description");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] arry = input.split(" ");
		HashMap<String, Integer> genreCount= new HashMap<String, Integer>();
		int action = 0, adventure = 0, fantasy = 0, science = 0, crime = 0, drama = 0, thriller = 0, animation = 0 ,family = 0, western = 0, comedy = 0, 
				romance = 0, horror = 0, mystery = 0, history = 0, war = 0, music = 0, documentary = 0, foreign = 0, tv = 0;
		genreCount.put("action", action);
		genreCount.put("adventure", adventure);
		genreCount.put("fantasy", fantasy);
		genreCount.put("science", science);
		genreCount.put("crime", crime);
		genreCount.put("drama", drama);
		genreCount.put("thriller", thriller);
		genreCount.put("animation", animation);
		genreCount.put("western", western);
		genreCount.put("comedy", comedy);
		genreCount.put("romance", romance);
		genreCount.put("horror", horror);
		genreCount.put("mystery", mystery);
		genreCount.put("history", history);
		genreCount.put("war", war);
		genreCount.put("music", music);
		genreCount.put("documentary", documentary);
		genreCount.put("foreign", foreign);
		genreCount.put("tv", tv);
		for(int i = 0;i<arry.length;i++) {
			   String current = arry[i];current = current.toLowerCase();current = current.replaceAll("[^a-zA-Z0-9]", "");
			   arry[i] = current;
			   if(Action.contains(arry[i].toString()))
				   action++; genreCount.put("action", action);
			   if(Adventure.contains(arry[i].toString()))
				   adventure++; genreCount.put("adventure", adventure);
			   if(Fantasy.contains(arry[i].toString()))
				   fantasy++; genreCount.put("fantasy", fantasy);
			   if(Science.contains(arry[i].toString()))
				   science++;genreCount.put("science", science);
			   if(Crime.contains(arry[i].toString()))
				   crime++;genreCount.put("crime", crime);
			   if(Drama.contains(arry[i].toString()))
				   drama++;genreCount.put("drama", drama);
			   if(Thriller.contains(arry[i].toString()))
				   thriller++;genreCount.put("thriller", thriller);
			   if(Animation.contains(arry[i].toString()))
				   animation++;genreCount.put("animation", animation);
			   if(Family.contains(arry[i].toString()))
				   family++;genreCount.put("family", family);
			   if(Western.contains(arry[i].toString()))
				   western++;genreCount.put("western", western);
			   if(Comedy.contains(arry[i].toString()))
				   comedy++;genreCount.put("comedy", comedy);
			   if(Romance.contains(arry[i].toString()))
				   romance++;genreCount.put("romance", romance);
			   if(Horror.contains(arry[i].toString()))
				   horror++;genreCount.put("horror", horror);
			   if(Mystery.contains(arry[i].toString()))
				   mystery++;genreCount.put("mystery", mystery);
			   if(History.contains(arry[i].toString()))
				   history++;genreCount.put("history", history);
			   if(War.contains(arry[i].toString()))
				   war++;genreCount.put("war", war);
			   if(Music.contains(arry[i].toString()))
				   music++;genreCount.put("music", music);
			   if(Documentary.contains(arry[i].toString()))
				   documentary++;genreCount.put("documentary", documentary);
			   if(Foreign.contains(arry[i].toString()))
				   foreign++;genreCount.put("foreign", foreign);
			   if(TV.contains(arry[i].toString()))
				   tv++;genreCount.put("tv", tv);
		   }
		
		ComputeScore(genreCount);
		
	}

	private static void ComputeScore(HashMap<String, Integer> genreCount) {
		ValueComparator bvc = new ValueComparator(genreCount);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(bvc);
		sortedMap.putAll(genreCount);
		Iterator<String> itr1 = sortedMap.keySet().iterator();
		System.out.println("Your Movie is most likely: " );
		for(int i = 0; i < 3 ;i ++){
			String currentWord = itr1.next();
			System.out.print(currentWord + " ");
		}
	}

	private static void addToGenre (HashSet<String> keyWords, HashSet<String> genre) {
		// TODO Auto-generated method stub
		Iterator<String> itr = keyWords.iterator();

		while(itr.hasNext()){
			
			genre.add(itr.next());
		}
		
	}

	private static ArrayList<String> getStopWords() {
		BufferedReader br = null;
		ArrayList<String> stopWords = new ArrayList<String>();
	      try {
	         br = new BufferedReader(new FileReader(new File("stopwords")));
	         String available;
	         while((available = br.readLine()) != null) {
	        	 available = available.toLowerCase();
	        	 available = available.replaceAll("[^a-zA-Z0-9: ]", "");
	        	 stopWords.add(available);
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
		return stopWords;
	}

	private static HashSet<String> setKeyWords(String[] temp, ArrayList<String> stopWords) {
		HashSet<String> hold = new HashSet<String>();
		
		
		for(int i = 0; i < temp.length; i++){
			if(!stopWords.contains(temp[i].toString())){
				hold.add(temp[i]);
				//System.out.println(temp[i]);
			}
		}
		return hold;
	}
}
class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
