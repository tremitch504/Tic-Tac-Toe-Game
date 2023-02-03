public class TicTacToe {
    
    //create a main method for our class
    //static: means that the method is associated with the class
    //void means that the method has no return value
    public static void main(String[] args) {
        
        //Create the tic tac toe board. given 3 rows of 3 characters we can place in
        //variable. we need the data type or value type, then what we name it

        //Multidimensional Arrays: char[][]: are useful when you want to store data as a tabular form, like a table with rows and columns.


        char[][] gameBoard = {{'1', '7', '8'}, 
                         {'6', '3', '2' }, 
                         {'9', '4', '5'}};
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println("----***---");
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }
}
