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


        char[][] gameBoard = {{ ' ' , ' ', ' '}, 
                         {' ', ' ', ' ' }, 
                         {' ', ' ', ' '}};
        printGameBoard(gameBoard);

        //We need to take in user input by using our Scanner buit in class
        //created a new Scanner
        //remember to import the scanner. 
        Scanner scanner = new Scanner(System.in);

        userPlay(gameBoard, scanner);

        //We need a way for the computer to make a play as well and pick a spot for the game
        //We will need the computer to pick a random spot and check if its avaliable.
        //need to import the Random class
        Random randomSpot = new Random();
        
        int computerTurn = randomSpot.nextInt(9) + 1;
        printGameBoard(gameBoard);

    }

    //We need to make a method that check if a certain spot that the user or computer wants to place input is invalid or already taken
    private static boolean isSpotValid(char[][] gameBoard, int position) {

        switch(position) {
            case 1:
            if(gameBoard[0][0] == ' '){
                return true;
            } else {
                return false;
            }
        
            case 2:
            if(gameBoard[0][1] == ' '){
                return true;
            } else {
                return false;
            }
            case 3:
            if(gameBoard[0][2] == ' '){
                return true;
            } else {
                return false;
            }
            case 4:
            if(gameBoard[1][0] == ' '){
                return true;
            } else {
                return false;
            }

            case 5:
            if(gameBoard[1][1] == ' '){
                return true;
            } else {
                return false;
            }

            case 6:
            if(gameBoard[1][2] == ' '){
                return true;
            } else {
                return false;
            }

            case 7:
            if(gameBoard[2][0] == ' '){
                return true;
            } else {
                return false;
            }

            case 8:
            if(gameBoard[2][1] == ' '){
                return true;
            } else {
                return false;
            }

            case 9:
            if(gameBoard[2][2] == ' '){
                return true;
            } else {
                return false;
            }

            default:
            return true;

            
        }
    }

    private static void userPlay(char[][] gameBoard, Scanner scanner) {
        //lets prompt the user here
        System.out.println("Where would you want to start the play? You can chose numbers from 1 through 9: ");
        //the type of input we get from user is a string
        //So, here. We are saying whatever is the input from the user, from the scanner. make it equal to this variable. 
        String userValue = scanner.nextLine();
         

        //System.out.println(userValue);
        

        //Ask the user where do they want to place the input value
        //System.out.println("Where do you want to place value? ");

        //User is going to have a lot of options so we are going to use a Switch statement
        //switch case is assigning the input to the place of the board game.
        switch(userValue) {
            case "1":
            gameBoard[0][0] = 'X';
            break;
            case "2":
            gameBoard[0][1] = 'X';
            break;
            case "3":
            gameBoard[0][2] = 'x';
            break;

            case "4":
            gameBoard[1][0] = 'x';
            break;

            case "5":
            gameBoard[1][1] = 'x';
            break;

            case "6":
            gameBoard[1][2] = 'x';
            break;

            case "7":
            gameBoard[2][0] = 'x';
            break;

            case "8":
            gameBoard[2][1] = 'x';
            break;

            case "9":
            gameBoard[2][2] = 'x';
            break;

            default:
            System.out.println("Oh no! that makes me sad!");

            
        }

        // return userValue;
    }

    private static void printGameBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }
}
