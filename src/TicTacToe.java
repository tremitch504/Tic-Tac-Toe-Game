import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    
    //create a main method for our class
    //static: means that the method is associated with the class
    //void means that the method has no return value
    public static void main(String[] args) {
        
        //Create the tic tac toe board. given 3 rows of 3 characters we can place in
        //variable. we need the data type or value type, then what we name it

        //Multidimensional Arrays: char[][]: are useful when you want to store data as a tabular form, like a table with rows and columns.
        Scanner scanner = new Scanner(System.in);
        //Making the board
        char[][] gameBoard = {{ ' ' , ' ', ' '}, 
                         {' ', ' ', ' ' }, 
                         {' ', ' ', ' '}}; 
        printGameBoard(gameBoard); //printing the blank board

        //We need to take in user input by using our Scanner buit in class
        //created a new Scanner
        //remember to import the scanner. 
       
       while(true){
           userPlay(gameBoard, scanner); //the player takes a turn 

           //We need to decide if the game is over. lets create a method that will do that for us.
           //and if the game is over break out of this loop. meaning if our function returns true end this while loop
          if(isGameOver(gameBoard)){
            break;
          }
            
           //print the board once again
           printGameBoard(gameBoard);
   
           // *******-----COMPUTER'S TURN----*********
          computersTurn(gameBoard);
          //So if the game is not over after the player has selected a spot
          //check if the game is over after the computer has selected a spot, if so break the loop. If not keep looping or run the game until we have a winner.
          if(isGameOver(gameBoard)){
            break;
          }
   
          printGameBoard(gameBoard);

       }

        //print the board again once the computer or user makes a play
        // printGameBoard(gameBoard);
        scanner.close();
    }
       
    //place the computer value on the board
    //So if spot equals to "3", then the position on the gameboard will have that given mark.

      private static void makeMove(char[][] gameBoard, String spot, char mark ) {

         //User is going to have a lot of options so we are going to use a Switch statement
        //switch case is assigning the input to the place of the board game.
        switch(spot) {
            case "1":
            gameBoard[0][0] = mark;
            break;
            case "2":
            gameBoard[0][1] = mark;
            break;
            case "3":
            gameBoard[0][2] = mark;
            break;

            case "4":
            gameBoard[1][0] = mark;
            break;

            case "5":
            gameBoard[1][1] = mark;
            break;

            case "6":
            gameBoard[1][2] = mark;
            break;

            case "7":
            gameBoard[2][0] = mark;
            break;

            case "8":
            gameBoard[2][1] = mark;
            break;

            case "9":
            gameBoard[2][2] = mark;
            break;

            default:
            System.out.println("Oh no! that makes me sad!");

            
        }
      }


    //We need to make a method that check if a certain spot that the user or computer wants to place input is invalid or already taken
    //so if the string doesn't have an empty space that means the spot is taken
    private static boolean isSpotValid(char[][] gameBoard, String position) {
        
        //User is going to have a lot of options so we are going to use a Switch statement
        //switch case is checking if the spot is taken or not
        switch(position) {
            case "1":
            if(gameBoard[0][0] == ' '){
                return true;
            } else {
                return false;
            }
        
            case "2":
            if(gameBoard[0][1] == ' '){
                return true;
            } else {
                return false;
            }
            case "3":
            if(gameBoard[0][2] == ' '){
                return true;
            } else {
                return false;
            }
            case "4":
            if(gameBoard[1][0] == ' '){
                return true;
            } else {
                return false;
            }

            case "5":
            if(gameBoard[1][1] == ' '){
                return true;
            } else {
                return false;
            }

            case "6":
            if(gameBoard[1][2] == ' '){
                return true;
            } else {
                return false;
            }

            case "7":
            if(gameBoard[2][0] == ' '){
                return true;
            } else {
                return false;
            }

            case "8":
            if(gameBoard[2][1] == ' '){
                return true;
            } else {
                return false;
            }

            case "9":
            if(gameBoard[2][2] == ' '){
                return true;
            } else {
                return false;
            }

            default:
            return false; 

            
        }
    }

    private static void userPlay(char[][] gameBoard, Scanner scanner) {
         //the type of input we get from user is a string
        //So, here. We are saying whatever is the input from the user, from the scanner. make it equal to this variable. 
        String userValue;

        while(true){
        // Scanner scanner = new Scanner(System.in);
        //lets prompt the user here
        System.out.println("Where would you want to start the play? You can chose numbers from 1 through 9: ");

        userValue = scanner.nextLine();

        if(isSpotValid(gameBoard, userValue)) {
            break;
        } else {
            System.out.println("Oops! This spot " + userValue + " is not valid!");
        }
    }
        //Make sure the spot is valid!


        //System.out.println(userValue);
    //calling this method for both player and computer to make a move
        makeMove(gameBoard, userValue, 'X');

        // scanner.close();
        //Ask the user where do they want to place the input value
        //System.out.println("Where do you want to place value? ");


        // return userValue;
    }

    private static  void computersTurn(char[][] gameBoard) {
        //We need a way for the computer to make a play as well and pick a spot for the game
        //We will need the computer to pick a random spot and check if its avaliable.
        //need to import the Random class
        Random randomSpot = new Random();
        
        int computerPick = 0;  //The computer can only pick a random number from 1 to 9
         
        //So if the spot is taking we need to loop iterate until the spot is not taking
        //So if our isSpotValid function returns true its avaliable. Keep running the function until the spot is valid
        while(true){
            computerPick = randomSpot.nextInt(9) + 1;
            if(isSpotValid(gameBoard, Integer.toString(computerPick))){
                break;
            }
        }
        System.out.println("The Computer has made a move and chose " + computerPick);
        makeMove(gameBoard, Integer.toString(computerPick), 'O'); 

       
    }

   //This method should return a boolean
    private static boolean isGameOver(char[][] gameBoard) {
        

        if( doWeHaveWinner(gameBoard, 'X')){
            printGameBoard(gameBoard);
            System.out.println("The Player WINS!!!!");
           return true;
        }

        if( doWeHaveWinner(gameBoard, 'O')){
            printGameBoard(gameBoard);
            System.out.println("The Computer and your Opponent WINS!!!!");
           return true;
        }
            

         
        //we need to iterate over the board object
        for(int i = 0; i < gameBoard.length; i++){

            //now iterate over the columns 
            for(int j = 0; j < gameBoard.length; j++){
                //check if any spot is empty
                if(gameBoard[i][j] == ' ') {
                    return false; 
                }
            }
        }

        return true;
    }

//this method should take in a character as well so that way if its either an X or O in the selected spots, at some point will have a winner.
    private static boolean doWeHaveWinner(char[][]gameBoard, char symbol) {

         //Condition for the first row, if the first row has all the same letters first. game over.
         if((gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) || 
         (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
         (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) || 
         
         //options ways a player can win
         (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) || 
         (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
         (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||
         
          //options ways a player can win
         (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) || 
         (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol)) {

             return true;
            }
            //if none of our conditions are true just return false so we can continue to run the game
            return false;
    }


    private static void printGameBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }
}
