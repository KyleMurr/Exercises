// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import Models.OBJ;
import Models.bomb;
import Models.numbers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Exercises.getTotal(2,4));
        System.out.println(Exercises.getTotal(nums));

        char[] chars = new char[]{'A','B','C','D','E'};

        char[][] board4 = new char[][]
                {
                 {'1','2','3','4','5'}
                ,{'1','2','3','4','5'}
                ,{'1','2','3','4','5'}
                ,{'1','2','3','4','5'}};
        char[] chars1 = new char[]{'1','2','3','4','5','6','7','8','9'};
        int i = 0;

        var board = setDisplayBoard();


        var board1  = setBoard();
        printBoard(board,chars1,i,nums);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is your selection: ");

        String Selection = myObj.nextLine();  // Read user input
        String[] SplitInput = Selection.split("");
        int row = 0;
        var Continue = true;
        while(true) {
            try {
                switch (SplitInput[0]) {
                    case "A" -> row = 0;
                    case "B" -> row = 1;
                    case "C" -> row = 2;
                    case "D" -> row = 3;
                }
                if(OBJ.getTotalObs() == 0){
                    System.out.println("You Have won!!!!");
                }

                if(board1[row][Integer.parseInt(SplitInput[1]) ] instanceof bomb) {
                    System.out.println("Game Over");
                    break;
                }
                else{
                    board[row][Integer.parseInt(SplitInput[1]) -1] = '?';
                    printBoard(board, chars1, i, nums);
                    OBJ.removeOBJ();
                }

                System.out.println("Do you want to continue: ");
                Continue = Objects.equals(myObj.nextLine(), "y");
                if(!Continue)
                    break;
                printBoard(board, chars1, i, nums);
                System.out.println("What is your selection: ");
                Selection = myObj.nextLine();  // Read user input
                SplitInput = Selection.split("");


            } catch (Exception e) {

            }

        }
    }

    static char[][] setDisplayBoard(){
        char board[][] = new char[9][5];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], '?');
        }
        return board;
    }



    static OBJ[][] setBoard() {
        Random rand = new Random();
        int BombNum = rand.nextInt(2);
        OBJ board[][] = new OBJ[9][5];
        char[] chars1 = new char[]{'A', 'B', 'C', 'D'};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int r = rand.nextInt(10);
                if (r % 2 == 0) {

                    board[i][j] = new bomb();

                    r--;
                } else {
                    board[i][j] = new numbers();
                    OBJ.setTotalObs();
                }

            }

        }
        return board;
    }

   static void printBoard(char[][] board,char[] nums1,int i,int[] nums){
       System.out.print(" ");
       System.out.print(" ");
       for (var n:nums) {
           System.out.print(n);
           System.out.print(" ");
       }
       System.out.println("");
        for (var m: board) {
            System.out.print(nums1[i]);
            for (var l: m) {
                System.out.print("|");
                System.out.print(l);
            }
            System.out.print("|");
            System.out.println("");
            i++;
        }
    }
}