import java.util.TreeMap;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String args[]) {
		TreeMap<String, TreeMap<String, Integer>> mainMap = new TreeMap<String, TreeMap<String, Integer>>();
		
		ArrayList<String> al = new ArrayList<String>();
		
		al = getStringPairs();
		mainMap = getSubMap(al);

		//System.out.println(mainMap);
		run(al, mainMap);
	}

	private static void run(ArrayList<String> al, TreeMap<String, TreeMap<String, Integer>> mainMap) {
		String sentence;
		int sentenceLength = 400;

		int random;
		String pair = getRandomPair(al);
		sentence = pair;
		for(int i = 0; i < sentenceLength; i++){
		Iterator<String> itr1 = mainMap.get(pair).keySet().iterator();
		Iterator<Integer> itr2 = mainMap.get(pair).values().iterator();	
		ArrayList<Integer> countFreq = new ArrayList<Integer>();
		ArrayList<String> wordFreq = new ArrayList<String>();
		int totalCount = 0;
		while (itr2.hasNext()) {
			int value = itr2.next();
			countFreq.add(value);	
			totalCount = totalCount + value;
			
		}
		int count;
		int pos = 0;
		while (itr1.hasNext()) {
			String currentWord = itr1.next();
			count = countFreq.get(pos);
			pos++;
			while(count != 0){
				wordFreq.add(currentWord);
				//System.out.println(wordFreq);
				count--;
			}	
		}
		
		random = getRand(wordFreq.size());
		
		sentence = sentence + " " + wordFreq.get(random);
		String[] tempStringList = sentence.split(" ");
		pair = tempStringList[tempStringList.length-2] + " " + tempStringList[tempStringList.length-1];
		}
		System.out.println(sentence);
	}

	private static String getRandomPair(ArrayList<String> al) {
		int random = getRand(al.size());

		return al.get(random);
	}

	private static int getRand(int i) {
		Random rand = new Random();

		int  n = rand.nextInt(i);
		
		return n;
	}

	private static TreeMap<String, TreeMap<String, Integer>> getSubMap(ArrayList<String> al) {
		
		TreeMap<String, TreeMap<String, Integer>> mainMap = new TreeMap<String, TreeMap<String, Integer>>();

		String[] tempArr = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("Matt")));
			String ava;
			String str = "";
			//String test = "want to";
			String currentWord = "";
			while ((ava = br.readLine()) != null) {
				if(str.equals("")){
					str = ava;
				}
				else
					str = str + ava;
			}
			str = str.toLowerCase();
			str = str.replaceAll("[^a-zA-Z0-9 ]", "" );
			//System.out.println(str);
			tempArr = str.split(" ");
			for(int j = 0; j < al.size(); j++){
				TreeMap<String, Integer> subMap = new TreeMap<String, Integer>();
				currentWord = al.get(j);
				//System.out.println("CurrentWord: " + currentWord);
				for (int i = 0; i < tempArr.length-2; i++) {
					String tempStr = tempArr[i] +" " +  tempArr[i+1];
					if(currentWord.equals(tempStr)){
						//System.out.println("TempString: " + tempStr);
						//System.out.println("Next Word: " + tempArr[i+2]);
						if(subMap.containsKey(tempArr[i+2])){
							int temp = subMap.get(tempArr[i+2]).intValue();
							subMap.remove(tempArr[i+2]);
							subMap.put(tempArr[i+2], temp + 1);
						}
						else{
							subMap.put(tempArr[i+2], 1);
						}
						
					}
				}
				
				//System.out.println(currentWord +" " + subMap);
			
				mainMap.put(currentWord, subMap);

				
			
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
		
		return mainMap;
	}

	private static ArrayList<String> getStringPairs() {

		ArrayList<String> al = new ArrayList<String>();
		BufferedReader br = null;
		String ava = null;
		String str = "";
		try {
			br = new BufferedReader(new FileReader(new File("Matt")));
			
			while ((ava = br.readLine()) != null) {
				if(str.equals("")){
					str = ava;
				}
				else
					str = str + ava;
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
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z0-9 ]", "");
		String[] temp = str.split(" ");
		// System.out.println(temp.length);
		for (int i = 0; i < temp.length - 1; i++) {
			String word = temp[i] + " " + temp[i + 1];
			if (!al.contains(word)) {
				al.add(word);
			}
		}
		Collections.sort(al, String.CASE_INSENSITIVE_ORDER);
//		 for(int i = 0; i<al.size();i++){
//		 System.out.println(al.get(i));
//		 }
		return al;
	}
}