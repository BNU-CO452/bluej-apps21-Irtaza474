
import java.io.*;

public class AdventureGame {			//require change
	private Adventure theCave;			//require change
	private Player thePlayer;			//require change
	
//converting str to direction
	
public int intDirection(String user_input) {
	
	char dir = user_input.charAt(0);
	int direction = -1;
	
	switch(dir) {
		case 'e':
		case 'E': direction = 2;break;
		
		case 'w':
		case 'W': direction = 3;break;
		
		case 'n':
		case 'N': direction = 0;break;
		
		case 's':
		case 'S': direction = 1;break;			//getting direction
		
		
	}
	
	return direction;
}	
 private Item pickingUpItem(Player player, BufferedReader readKey) throws IOException{
	 
	
	 Item[] contents = (player.getLoc()).getCaveContents();
	 //array for the contents
	 
	 String strTaken = "emptyStr";
	 int ch = -1;
	 do {
		 System.out.println("The Cave is having:");			//list of item in the Cave
		 for (int i=0; i <contents.length; i++)
		 System.out.println((i+1) + ": " + contents[i].getDesc());
		 System.out.print("Hi Player ! Please Enter the frequency of the item to take: ");
		 strTaken = readKey.readLine();
		 
		 
		 
		 System.out.println('\n');
		 
		 if (strTaken.equals(""))
			 strTaken = " ";
		 try {
			 ch = Integer.parseInt(strTaken);
		 } 
		 catch (Exception e) {
			 System.out.println("Not a valid input.\n please enter a valid input");
			 ch = -1;
		 }
		 if (ch > contents.length || ch < 0 )
			 System.out.print("We don't have that item in the Cave.");
	 } while (ch > contents.length || ch < 0);
	 
	 return contents[ch -1];
	 
 }
 
 
 private int dropingUpItem (Player player, BufferedReader readKey) throws IOException
 {
	 String strTaken = "emptyStr";
	 int ch = -1;
	 do
	 {
		 System.out.println("You are currently carrying: " + player.displayItems() + '\n');
		 System.out.print("Enter the number of the item(s) to drop: ");
		 strTaken = readKey.readLine();
		 try
		 {
			 ch = Integer.parseInt(strTaken);
		 }
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input.");
			ch = -1;
		}
		 if (ch < 0 || ch > player.numItemsCarried())
			 System.out.print("Invalid choice.");
	 } while (ch > player.numItemsCarried() || ch < 0);
	return ch;
 }
 
 public void beginQuest() throws IOException
 {
	 Player player = new Player();
	 Adventure theCave = new Adventure();
	 Cave startRm = theCave.beginAdventure();
	 player.setCave(startRm);
	 int direction = -1;
	
	 BufferedReader keyboard = new BufferedReader(new InputStreamReader (System.in));
	 String strTaken = "emptyStr";
	 
	
	 while (strTaken.charAt(0)!='q') {
		 System.out.println(player.look());
		 System.out.println("You are having: " + player.displayItems() + '\n');
		 

	
	System.out.println("In which direction you want to go (n,s,e,w)," + " or grab(g) an item," + " or quit(q)?" + '\n');
	strTaken = keyboard.readLine();
	System.out.println();
	System.out.println();

	if(strTaken.equals(""))
		strTaken = " ";
	char inputDirTaken = strTaken.charAt(0);
	switch(inputDirTaken) {
		//for direciton
		case 'n':
		case 'N':

		case 's':
		case 'S':

		case 'e':
		case 'E':

		case 'w':
		case 'W':

			direction = intDirection(strTaken);
		 	player.go(direction);
		 	break;
		 //to grab the item
		case 'g':
		case 'G':
		  if (player.handsFull())
		System.out.println("Both the hands are full.");
		  else if ((player.getLoc()).caveEmpty())
			  System.out.println("The Cave has no item");
		  else {
			  Item itemToGrab = 
			  pickingUpItem(player,keyboard);
			  player.pickUp(itemToGrab);
			  (player.getLoc()).removeItem(itemToGrab);
		  }
		break;
		

		}
	 }
 }
 
public static void main(String args[]) throws IOException{
	System.out.println("Welcome to the My Cave Adventure Game");
	AdventureGame theGame = new AdventureGame();
	theGame.beginQuest();
}
}