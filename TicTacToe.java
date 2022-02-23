//69358 Chong Kwong Wei

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class TicTacToe {

	static ArrayList<Integer> player1Position = new ArrayList<Integer>();
	static ArrayList<Integer> player2Position = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		char [][] gameBoard = {
				{' ', ' ', '0', ' ', ' ', ' ', '1', ' ', ' ', ' ', '2', ' '},
				{' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
				{'0', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' '},
				{' ', '_', '_', '_', '|', '_', '_', '_', '|', '_', '_', '_'},
				{' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}, 
				{'1', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' '},
				{' ', '_', '_', '_', '|', '_', '_', '_', '|', '_', '_', '_'},
				{' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
				{'2', ' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' '},
				{' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}};

		printGameBoard(gameBoard);
		
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			
			// player1
			System.out.println("P1:Enter your placement (1-9):");
			int player1Pos = scan.nextInt();
			while(player1Position.contains(player1Pos) || player2Position.contains(player1Pos)) {
				System.out.println("Position taken! Enter a correct Position");
				player1Pos = scan.nextInt();
			}
			
			// place and print result
			placePiece(gameBoard, player1Pos, "player1");
			printGameBoard(gameBoard);
			
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			// player2
			System.out.println("P2:Enter your placement (1-9):");
			int player2Pos = scan.nextInt();
			while(player1Position.contains(player2Pos) || player2Position.contains(player2Pos)) {
				System.out.println("Position taken! Enter a correct Position");
				player2Pos = scan.nextInt();
			}
			
			// place and print result
			placePiece(gameBoard, player2Pos, "player2");
			printGameBoard(gameBoard);
			
			result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
		}
	}

	// print game board
 	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

 	// place XO
 	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
 		char symbol = ' ';
 		
 		if(user.equals("player1")) {
 			symbol = 'X'; 
 			player1Position.add(pos);
 		}else if (user.equals("player2")) {
 			symbol = 'O';
 			player2Position.add(pos);
 		}
 		
 		switch(pos) {
			case 1:
				gameBoard[2][2] = symbol;
				break;
			case 2:
				gameBoard[2][6] = symbol;
				break;	
			case 3:
				gameBoard[2][10] = symbol;
				break;	
			case 4:
				gameBoard[5][2] = symbol;
				break;	
			case 5:
				gameBoard[5][6] = symbol;
				break;	
			case 6:
				gameBoard[5][10] = symbol;
				break;	
			case 7:
				gameBoard[8][2] = symbol;
				break;	
			case 8:
				gameBoard[8][6] = symbol;
				break;	
			case 9:
				gameBoard[8][10] = symbol;
				break;	
			default:
				break;
		}
 	}
 	
 	// check result
 	public static String checkWinner() {
 		
 		List<List<Integer>> wining = new ArrayList<List<Integer>>();
 		wining.add(Arrays.asList(1, 2, 3)); // first Row of the table
 		wining.add(Arrays.asList(4, 5, 6)); // Second Row of the table
 		wining.add(Arrays.asList(7, 8, 9)); // Third Row of the table
 		wining.add(Arrays.asList(1, 4, 7)); // First Column of the table
 		wining.add(Arrays.asList(2, 5, 8)); // Second Column of the table
 		wining.add(Arrays.asList(3, 6, 9)); // Third Column of the table
 		wining.add(Arrays.asList(1, 5, 9)); // first diagonal of the table
 		wining.add(Arrays.asList(3, 5, 7)); // Second diagonal of the table
 	
		for (List<Integer> l  : wining) {
 			if(player1Position.containsAll(l)) {
 				return "Congratulations P1 won!";
 			} else if (player2Position.containsAll(l)) {
 				return "Congratulations P2 won!";
 			} else if (player1Position.size() + player2Position.size() == 9) {
 				return "TIE!";
 			}
 		}
 		
 		
 		
 		return "";
 	}
 	
}