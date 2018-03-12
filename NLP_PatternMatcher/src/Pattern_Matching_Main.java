import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pattern_Matching_Main {

	public static void main(String[] args) {
		boolean running = true;
		System.out.println("Eliza: Hello my name is Eliza and I am your online therapist! How are you today?" );
		while(running){
			System.out.print("You: ");
			String userInput = getUserInput();
			userInput = reformatUserInput(userInput);
			System.out.println("Eliza: " + parseForMeaning(userInput));
		}

	}

	private static String parseForMeaning(String userInput) {
		ArrayList<String> rC = new ArrayList<String>();//responseContainer
		String [] tempSplit = userInput.split(" ");
		ArrayList<String> uiArray = new ArrayList<String>();
		int random;
		for(int i = 0; i< tempSplit.length; i++)
			uiArray.add(tempSplit[i]);
		if(uiArray.size() > 1){
			String condit = uiArray.get(0) + " " + uiArray.get(1);
			String restOfString = getRestOfString(uiArray, 2);
			if(condit.equals("i need")){
				
				rC.add("Why do you need " + restOfString);
				rC.add("Would it really help you to get " + restOfString);
				rC.add("Are you sure you need " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i cant")){
				
				rC.add("How do you know you can't " + restOfString);
				rC.add("Perhaps you could " + restOfString + " if you tried");
				rC.add("What would it take for you to " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i am")){
				
				rC.add("Did you come to me because you are " + restOfString);
				rC.add("How long have you been " + restOfString);
				rC.add("How do you feel about being " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("are you")){
				
				rC.add("Why does it matter whether I am " + restOfString);
				rC.add("Would you prefer it if I were not " + restOfString);
				rC.add("I may be " + restOfString + ". What do you think?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i think")){
				
				rC.add("Do you doubt " + restOfString);
				rC.add("Do you really think so?");
				rC.add("But you're not so sure " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("is it")){
				
				rC.add("Do you think it is " + restOfString);
				rC.add("Perhaps it's " + restOfString + ". What do you think?");
				rC.add("It could well be that " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("it is")){
				
				rC.add("You seem certain");
				rC.add("If I told you that it probably isn't " + restOfString + ", what would you feel");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("can you")){
				
				rC.add("What makes you think I can't " + restOfString);
				rC.add("If i could " + restOfString + ", then what?");
				rC.add("Why do you ask if I can " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("can i")){
				
				rC.add("Perhaps you don't want to " + restOfString);
				rC.add("Do you want to be able to " + restOfString);
				rC.add("If you could " + restOfString + ", would you?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("you are")){
				
				rC.add("Why do you think I am " + restOfString);
				rC.add("Does it please you to think I am " + restOfString);
				rC.add("Perhaps you would like me to be " + restOfString);
				rC.add("Perhaps you're really talking about yourself?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i dont")){
				
				rC.add("Do you really " + restOfString);
				rC.add("Why don't you " + restOfString);
				rC.add("Do you want to " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i feel")){
				
				rC.add("Good, tell me more about these feelings ");
				rC.add("Do you often feel " + restOfString);
				rC.add("When do you usually feel " + restOfString);
				rC.add("When you feel " + restOfString + " what do you do?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i have")){
				
				rC.add("Why do you tell me that you've " + restOfString);
				rC.add("Have you really " + restOfString);
				rC.add("Now that you have " + restOfString + ", what will you do next?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i would")){
				
				rC.add("Can you explain why you would " + restOfString);
				rC.add("Why would you " + restOfString);
				rC.add("Who else knows that you would " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("is there")){
				
				rC.add("Do you think there is " + restOfString);
				rC.add("It's likely that is is " + restOfString);
				rC.add("Would you like there to be " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("i want")){
				
				rC.add("What would it mean to you if you got " + restOfString);
				rC.add("Why do you want " + restOfString);
				rC.add("What would you do if you got " + restOfString);
				rC.add("If you got " + restOfString + ", then what would you do?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
		}
		if(uiArray.size() > 2){
		
		
			String condit = uiArray.get(0) + " " + uiArray.get(1) + " " + uiArray.get(2);
			String restOfString = getRestOfString(uiArray, 3);
			
			if(condit.equals("why dont you")){
				
				rC.add("Do you really that I don't " + restOfString);
				rC.add("Perhas eventually I will " + restOfString);
				rC.add("Do you really want me to " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("why cant i")){
				
				rC.add("Do you think that you should be able to" + restOfString);
				rC.add("If you could " + restOfString + ", what would you do?");
				rC.add("I dont know, why can't you " + restOfString);
				rC.add("Have you really tried?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("why dont you")){
				
				rC.add("Do you really that I don't " + restOfString);
				rC.add("Perhas eventually I will " + restOfString);
				rC.add("Do you really want me to " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}
		}
		if(uiArray.size() > 0){
			String condit = uiArray.get(0);
			String restOfString = getRestOfString(uiArray, 1);
			
			if(condit.equals("im")){
				
				rC.add("How does being " + restOfString + " make you feel" ) ;
				rC.add("Do you enjoy being " + restOfString);
				rC.add("Why do you tell me you're " + restOfString);
				rC.add("Why do you think you're " + restOfString);
				random = getRandom(rC.size());
				return rC.get(random);
			}			
			if(condit.equals("what")){
				
				rC.add("Why do you ask?");
				rC.add("How would an answer to that help you?");
				rC.add("What do you think?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("how")){
				
				rC.add("How do you suppose?");
				rC.add("Perhaps you can answer your own question.");
				rC.add("What is it you're really asking?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("because")){
				
				rC.add("Is that the real reason?");
				rC.add("What other reasons come to mind?");
				rC.add("Does that reason apply to anything else?");
				rC.add("If " + restOfString + ", what else must be true?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(condit.equals("yes")){
				
				rC.add("You seem quite sure.");
				rC.add("OK, but can you elaborate a bit?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(uiArray.contains("sorry")){
				rC.add("There are many times when no apology is needed.");
			    rC.add("What feelings do you have when you apologize?");

				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(uiArray.contains("friend")){
				
				rC.add("Tell me more about your friends.");
				rC.add("When you think of a friend, what comes to mind?");
				rC.add("Why don't you tel me about a childhood friend?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(uiArray.contains("computer")){
				
				rC.add("Are you really talking about me?");
				rC.add("Does it seem strange to talk to a computer?");
				rC.add("How do computers make you feel?");
				rC.add("Do you feel threatened by computers?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			if(uiArray.contains("computer")){
				
				rC.add("Tell me more about your friends.");
				rC.add("When you think of a friend, what comes to mind?");
				rC.add("Why don't you tel me about a childhood friend?");
				random = getRandom(rC.size());
				return rC.get(random);
			}
			
		}
			
		
		return "Please go on.";
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
			uiArray.set(i, checkForReflection(uiArray.get(i))) ;
			if(i == pos)
				returnString = returnString + uiArray.get(i);
			else
				returnString = returnString + " " + uiArray.get(i);
		}

		return returnString;
	}

	private static String checkForReflection(String string) {
		String returnValue = string;
		switch(string){
		case "am":
			returnValue = "are";
			break;
		case "was":
			returnValue = "were";
			break;
		case "i":
			returnValue = "you";
			break;
		case "id":
			returnValue = "you would";
			break;
		case "ive":
			returnValue = "you have";
			break;
		case "ill":
			returnValue = "you will";
			break;
		case "my":
			returnValue = "your";
			break;
		case "are":
			returnValue = "am";
			break;
		case "youve":
			returnValue = "I have";
			break;
		case "youll":
			returnValue = "I will";
			break;
		case "your":
			returnValue = "my";
			break;
		case "yours":
			returnValue = "mine";
			break;
		case "you":
			returnValue = "me";
			break;
		case "me":
			returnValue = "you";
			break;
		}
		return returnValue;
	}

	private static String reformatUserInput(String userInput) {
		userInput = userInput.toLowerCase();
		userInput = userInput.replaceAll("[^a-zA-Z0-9 ]", "");
		return userInput;
	}

	private static String getUserInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);	
		return scanner.nextLine();
	}

}
