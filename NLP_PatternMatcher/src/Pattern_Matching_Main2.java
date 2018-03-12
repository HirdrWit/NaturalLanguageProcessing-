import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pattern_Matching_Main2 {

	public static void main(String[] args) {
		boolean running = true;
		System.out.println("Eliza: Hello my name is Eliza! How can I help you today?" );
		while(running){
			System.out.print("You: ");
			Scanner scanner = new Scanner(System.in);	
			String IU = scanner.nextLine();
			IU = reformatUserInput(IU);
			System.out.println("Eliza: " + parseForMeaning(IU));
		}

	}

	private static String parseForMeaning(String UI) {
		ArrayList<String> rC = new ArrayList<String>();//responseContainer
		String [] tempSplit = UI.split(" ");
		ArrayList<String> uiArray = new ArrayList<String>();
		int random;
		for(int i = 0; i< tempSplit.length; i++)
			uiArray.add(tempSplit[i]);
		if(uiArray.size() > 1){
			String condition = uiArray.get(0) + " " + uiArray.get(1);
			String restOfString = getRestOfString(uiArray, 2);
			if(condition.equals("i feel")){
				rC.add("Why do you feel " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			
		}

		return "Tell me more.";
	}

	private static int getRandom(int i) {
		// TODO Auto-generated method stub
		Random rand = new Random();

		int  n = rand.nextInt(i);
		return n;

	}

	private static String getRestOfString(ArrayList<String> uiArray, int pos) {
		String returnString = "";

		for(int i = pos; i< uiArray.size(); i++){
			if(i == pos)
				returnString = returnString + uiArray.get(i);
			else
				returnString = returnString + " " + uiArray.get(i);
		}

		return returnString;
	}



	private static String reformatUserInput(String userInput) {
		userInput = userInput.toLowerCase();
		userInput = userInput.replaceAll("[^a-zA-Z0-9 ]", "");
		return userInput;
	}


}
