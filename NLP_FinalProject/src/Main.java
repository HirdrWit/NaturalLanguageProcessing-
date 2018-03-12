import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static boolean running = true;
	static int mood = 0;
	public static void main(String args[]){
		HashSet<String> pos = new HashSet<String>();
		HashSet<String> neg = new HashSet<String>();
		pos = getPos();
		neg = getNeg();
		
		run(pos,neg);
	}

	private static void run(HashSet<String> pos, HashSet<String> neg) {
		System.out.println("Type 'exit' to terminate the program\n\n\nProgram: Hello, you may say what every you would like to me");
		
		while(running){
			System.out.print("User: ");
			String [] input = getUserInputer();
			int wordSentiment = 0; //pos = 1 **  neg = -1 ** neutral = 0
			int tempmood = 0;
			for(int i = 0; i < input.length ; i++){
				
				int computedValue;
				wordSentiment = compute(input[i],pos, neg);
				tempmood = tempmood + wordSentiment;
				mood = mood + wordSentiment;
				
			}
			System.out.println(tempmood);
			
			if(tempmood < 0){
				System.out.println("That wasn't very nice!");
			}
			else if(tempmood > 0){
				System.out.println("Oh that was nice!");
			}
			else
				System.out.println("That did not affect me");
			
		}
			
		
		
	}

	private static int compute(String input, HashSet<String> pos, HashSet<String> neg) {
		if(pos.contains(input))
			return 1;
		if(neg.contains(input))
			return -1;
		else
			return 0;
	}

	private static String[] getUserInputer() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] arry = input.split(" ");
		if(input.equals("exit")){
			running = false;
			System.out.println("Thank you for chatting with me");
			return arry;
		}
		for(int i = 0;i<arry.length;i++) {
			   String current = arry[i];
			   current = current.toLowerCase();
			   current = current.replaceAll("[^a-zA-Z0-9]", "");
			   arry[i] = current;
		   }
		return arry;
	}

	private static HashSet<String> getPos() {
		HashSet<String> pos = new HashSet<String>();
		try (Scanner fin = new Scanner(new File("positive"))) {
			   while (fin.hasNextLine()) {
				   String word = fin.next();
				   pos.add(word);
			   }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("This program will parse your positive and negative speech\nWhat you say will either positively or negatively impact the programs mood.\nType : 'How are you feeling' to find out its mood.");
		return pos;
		
	}
	private static HashSet<String> getNeg() {
		HashSet<String> neg = new HashSet<String>();
		try (Scanner fin = new Scanner(new File("negative"))) {
			   while (fin.hasNextLine()) {
				   String word = fin.next();
				   neg.add(word);
			   }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return neg;
	}


}
