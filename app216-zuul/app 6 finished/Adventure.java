
public class Adventure {
	
	private Cave starting;
	
	public Cave beginAdventure() {
		
		Cave outside = new Cave();
		outside.setDesc("You are currently standing in a Forest.\n" + " There are tall and dense trees and you can hear sounds of wild animals\n");
		Cave c1 = new Cave();
	    c1.setDesc("There is a banyan tree to the east with a narrow passage(c1)\n And there is a huge mummy Idol\nThere is a flashlight you need it to see the surrounds");
	  
	
	    outside.direction(1,c1);				//Starting point of the game
	    c1.direction(0,outside);
	    starting=outside;
	    Cave c2 = new Cave();
	    c2.setDesc("Now you can see a gloomy oval shaped Cave with black hills.\n" + "There is a dim light to the west, and a narrow(c2)\n.");
	  
	
	   Cave c3 = new Cave();
	   c3.setDesc("There is a wide passage that quickly narrows\n" +"to the east and south, you also have the chance to grab the Hammer in the middle of the Cave (c3).");
	  
	

	  //done

	
	  Cave c4 = new Cave();
	  c4.setDesc("Now you are one step closer to the Gold. You can hear the roar of lions. (c4).");
	
	
	  Cave c5 = new Cave();
	  c5.setDesc("You are near to the Hammer,just grab it. (c5).");
	  
	
	  Cave c6 = new Cave();
	  c6.setDesc("The ceiling is full of bats.\n" + "You should put your titfer on your head (c6).\n There's a energy drink, you may drink it");
	  
	
	  Cave c7 = new Cave();
	  c7.setDesc("This seems that you are not in correct direction of the cave. Beware of snakes here. (c7).");


		c3.direction(1,c5);
		c5.direction(0,c3);
	  
	
	  Cave c8 = new Cave();
	  c8.setDesc("Go to West and use your Hammer. (c8).");
	  

	  Cave c9 = new Cave();
	  c9.setDesc("Cave c9.");
	  Gold theGold = new Gold();
	  theGold.setDesc("A bag filled with gold bars.");
	  c9.addItem(theGold);



		c1.direction(2,c2);
		c2.direction(3,c1);      //linking the caves
		c2.direction(2,c3);
		c3.direction(3,c2);
		c3.direction(2,c4);			//linking the caves
		c4.direction(3,c3);
		c4.direction(0,c8);
		c8.direction(1,c4);
		c5.direction(3,c6);
		c6.direction(2,c5);
		c4.direction(1,c7);
		c7.direction(0,c4);
	
	  Hammer theHammer = new Hammer();			//creating hammer object

	  theHammer.setDesc("A hammer");

	  c5.addItem(theHammer);

	  EnergyDrink theEnergyDrink = new EnergyDrink();			//creating energy drink object

	  theEnergyDrink.setDesc("A energy drink");

	  c6.addItem(theEnergyDrink);

	  Launch theHill = new Launch(c8,c9,theHammer);

	  c8.direction(3,theHill);

	  c9.direction(2,theHill);



		FlashLight theFlashLight = new FlashLight();			//creating flashlight object

		theFlashLight.setDesc("A flashlight");

		c1.addItem(theFlashLight);



	  
	
	  starting = outside;
	  //starting point of the game
	  return starting;	
	}
}