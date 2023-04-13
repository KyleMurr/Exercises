// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import Models.OBJ;
import Models.bomb;
import Models.numbers;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(Exercises.getTotal(2,4));
        System.out.println(Exercises.getTotal(nums));

        char[] chars = new char[]{'A','B','C','D','E'};

        char[][] board = new char[][]
                {
                 {'1','2','3','4','5','6'}
                ,{'1','2','3','4','5','6'}
                ,{'1','2','3','4','5','6'}
                ,{'1','2','3','4','5','6'}};
        char[] chars1 = new char[]{'A','B','C','D'};
        int i = 0;



        setBoard();
//        printBoard(board,chars1,i,nums);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is your selection: ");

        String Selection = myObj.nextLine();  // Read user input
        String[] SplitInput = Selection.split("");
        int row = 0;
        try{
            switch(SplitInput[0]) {
                case "A":
                    row = 1;
                    break;
                case "B":
                    row = 2;
                    break;
                case "C":
                    row = 3;
                    break;
                case "D":
                    row = 4;
                    break;
            }
            int chosenCo = board[row][Integer.parseInt(SplitInput[1])];
            System.out.println(chosenCo);
            board[row][Integer.parseInt(SplitInput[1])] = '?';
            printBoard(board,chars1,i,nums);
        }catch (Exception e){

        }


    }


    static void setBoard(){
        Random rand = new Random();
        int BombNum = rand.nextInt(5);
        OBJ board[][] = new OBJ[4][5];

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                System.out.println("s");

                int r = rand.nextInt(5);
                if(r == 4){
                    board[i][j] = new bomb();
                }else{
                    board[i][j] = new numbers();
                }
            }
        }
        for (var m: board) {
            for (var l: m) {
                System.out.print("|");
                OBJ ll = null;
                if (l instanceof bomb){
                    ll = (bomb)l;
                }else{
                    ll = (numbers)l;
                }
            }
        }

    }


   static void printBoard(char[][] board,char[] nums1,int i,int[] nums){
       System.out.print(" ");
       System.out.print(" ");
       for (var n:nums) {
           System.out.print(n);
           System.out.print(" ");
       }
       System.out.println("");
        for (var m:board) {
            System.out.print(nums1[i]);
            for (var l:m) {
                System.out.print("|");
                System.out.print(l);
            }
            System.out.print("|");
            System.out.println("");
            i++;
        }
    }
}