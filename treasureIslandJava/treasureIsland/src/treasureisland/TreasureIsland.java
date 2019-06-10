//Package name
package treasureisland;

//Import the Scanner package for reading user input
import java.util.Scanner;
//Main class
public class TreasureIsland {
    
//Global variables
    
    //Load Descriptions
    descriptions locDesc = new descriptions();
    //Create Scimitar object
    item scimitar = new item("Scimitar", "A surprisingly well maintained sword with jewels glittering in the hilt.", 1, 5);
    //Create Message in a Bottle object
    item bottle = new item("Message in a bottle", "A dirty glass bottle. It has a faded piece of paper stuck inside.", 5, 3);
    //Create Treasure Chest object
    item chest = new item("Treasure Chest", "It's a solid wooden chest, filled inside with jewels and gold.", 2, 4);   
    item carriedItem, locationItem;
    
    //Main to-do goes below
    public static void main(String[] args) {
        TreasureIsland TR = new TreasureIsland();
        TR.runProgram();
    }
    
    public void runProgram()
    {
        //Set user input
        Scanner input = new Scanner(System.in);
        String move = ""; 
        //Game starts below
        System.out.print("What is your name?: "); //Ask player their name
        
        //Create Player object; user input sets character name
        character player = new character(input.next(), 3, 3);    
        
        System.out.println("Hello " + player.name + " and welcome to Treasure Island!\n\nThe aim of the game is to find three items hidden around the map.\nYou must pick all three up and have dropped them to win the game.\nYou can leave at any time by typing Quit.\n");  //Welcomes player to game
        System.out.println("You're stood in a jungle, surrounded by trees and you can hear birds chirping, the heat making you sweat.\n"  //Starts game by describing initial position
                          + "You're at the centre of the island. {" + character.x + ", " + character.y +"}");                           //and prints coordinates {2,2}
        //Do-While loop for main gameplay asking for input to move around the map
        do
        {
            System.out.print("What do you do? Go North, East,\nSouth, West? Pick-up or Drop an item?: "); //Ask which direction the user would like to move to
            move = input.next(); //Input for movement
            if (move.equals("N") || move.equals("n") || move.equals("North") || move.equals("north")) //North inputs
            {
                if (character.y > 1) //Checks the characters Y coordinate is greater than 1
                {
                	character.y -=1; //Minus one from players y axis position
                        if(carriedItem != null)
                        {
                            carriedItem.setY(character.y);
                        }
                	System.out.println("You move North! {" + character.x + ", " + character.y + "}"); //Print saying which direction the user moved and their new position
                        areaDesc(); //Checks player coordinates for area description

                }
                else //If the users Y coordinate is 1
                {
                	System.out.println("You cannot move further North!"); //Print saying that the user cannot go any further North as it's the map boundary
                }
            }
            else if (move.equals("E") || move.equals("e") || move.equals("East") || move.equals("east")) //East inputs
            {
                if (character.x < 5) //Checks characters X coordinate is less than 5
                {
                	character.x +=1; //Increases characters X coordinate by 1
                        if(carriedItem != null)
                        {
                            carriedItem.setX(character.x);
                        }
                	System.out.println("You move East! {" + character.x + ", " + character.y + "}"); //Print updated coordinates 
                        areaDesc(); //Checks player coordinates for area description
                }
                else
                {
                	System.out.println("You cannot move further East!"); //If X coordinate is 5, do nothing as user is at east boundary
                }
            }
            else if (move.equals("S") || move.equals("s") || move.equals("South") || move.equals("south")) //South input
            {
                if (character.y < 5) //If users Y coordinate is less than 5
                {
                	character.y +=1; //Increment Y coordinate by 1
                        if(carriedItem != null)
                        {
                            carriedItem.setY(character.y);
                        }
                	System.out.println("You move South! {" + character.x + ", " + character.y + "}"); //Print users update coordinates
                        areaDesc(); //Checks player coordinates for area description
                }
                else
                {
                	System.out.println("You cannot move further South!"); //If Y coordinate is 5, do nothing as user it at south boundary
                }
            }
            else if (move.equals("W") || move.equals("w") || move.equals("West") || move.equals("west")) //West input
            {
                if (character.x > 1) //If character X coordinate is greater than one
                {
                	character.x -=1; //Decrement X coordinate by one
                        if(carriedItem != null)
                        {
                            carriedItem.setX(character.x);
                        }
                	System.out.println("You move West! {" + character.x + ", " + character.y + "}"); //Print updated coordinates
                        areaDesc(); //Checks player coordinates for area description
                }
                else 
                {
                	System.out.println("You cannot move further West!"); //If character X coordinate is 1, do nothing as character is at west boundary
                }
            }
            else if (move.equals("Quit") || move.equals("quit")) //If user input is Quit
            {
          	  System.out.println("GAME OVER!\nYou've left the island without finding all the treasure. Maybe one day you will return to try again..."); //Print Quit game message
          	  System.exit(0); //Ends the program
            }
            else if (move.equals("Pick up") || move.equals("pick up"))
            {
                if(locationItem != null)
                {
                    locationItem.isBeingCarried = true;
                    locationItem.hasBeenCarried = true;
                    carriedItem = locationItem;
                }
            }
            else //If input doesn't match input defined above
            	System.out.println("Invalid input."); //Print invalid input message
            
        }
        	while((!scimitar.hasBeenCarried || !chest.hasBeenCarried || !bottle.hasBeenCarried) || move != ("Quit") && move != ("quit")); //Movement do-while loop conditions
    }                                         //Ends when either all items have been carried OR user inputs "Quit"
        public void areaDesc()
    {
        //  Print area description for players current location.
        System.out.println(locDesc.getDescription(character.x, character.y));
        if(character.x == scimitar.getX() && character.y == scimitar.getY())
        {
            System.out.println("You have found a Scimitar! " + scimitar.getDesc());
            locationItem = scimitar;
        }
        else if(character.x == bottle.getX() && character.y == bottle.getY())
        {
            System.out.println("You have found a Message in a Bottle! " + bottle.getDesc());
            locationItem = bottle;
        }
        else if(character.x == chest.getX() && character.y == chest.getY())
        {
         System.out.println("You have found a Treasure Chest! " + chest.getDesc());
            locationItem = chest;
        }
        else
        {
            locationItem = null;
        }
    }
}