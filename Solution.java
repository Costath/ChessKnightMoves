package foo.bar;

import java.util.ArrayList;

public class Solution {
	static ArrayList<ArrayList<Square>> board = new ArrayList<>(8); // bidimensional ArrayList representing the chessboard
	
	public static int solution(int src, int dest) {
		populateBoard();
		
		if (src == dest) {
			return 0;
		}
		
		Square srcSquare = null;
		Square destSquare = null;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				Square square = board.get(y).get(x);
				if (square.Number == src) {
					srcSquare = square;
				}
				if (square.Number == dest) {
					destSquare = square;
				}
			}
		}
		int moves = countMoves(srcSquare, srcSquare, destSquare, 0);
		
//		printSquares(board.get(1).get(2));
		
		return moves;
	}

	private static void populateBoard() { // Populates the board with Square objects
		for (int i = 0; i < 8; i++) {
			board.add(new ArrayList<Square>(8));
		}
		
		int squareNumber = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board.get(i).add(new Square(squareNumber++));
			}
		}
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				Square square = board.get(y).get(x);
				square.position[0] = y;
				square.position[1] = x;
				
				try {
					square.knightNeighbors.add(board.get(y - 2).get(x - 1));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y - 2).get(x + 1));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y - 1).get(x - 2));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y - 1).get(x + 2));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y + 1).get(x - 2));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y + 1).get(x + 2));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y + 2).get(x - 1));
				} catch (IndexOutOfBoundsException e) {}
				try {
					square.knightNeighbors.add(board.get(y + 2).get(x + 1));
				} catch (IndexOutOfBoundsException e) {}
			}
		}
	}

	private static int countMoves(Square parent, Square src, Square dest, int moves) { // Recursive method to count how many moves from src to dest
		if (moves > 5){
			return -1;
		} else {
			ArrayList<Square> neighbors = src.knightNeighbors;
			
			for (Square neighbor : neighbors) {
				if (neighbor.Number == dest.Number) {
					return moves + 1;
				}
			}
			
			for (Square neighbor : neighbors) {
				
				if ((src.position[0] >= dest.position[0] && src.position[1] <= dest.position[1]) &&
					(src.position[0] >= neighbor.position[0] && src.position[1] <= neighbor.position[1]) ||
					(src.position[0] <= dest.position[0] && src.position[1] <= dest.position[1]) &&
					(src.position[0] <= neighbor.position[0] && src.position[1] <= neighbor.position[1]) ||
					(src.position[0] <= dest.position[0] && src.position[1] >= dest.position[1]) &&
					(src.position[0] <= neighbor.position[0] && src.position[1] >= neighbor.position[1]) ||
					(src.position[0] >= dest.position[0] && src.position[1] >= dest.position[1]) &&
					(src.position[0] >= neighbor.position[0] && src.position[1] >= neighbor.position[1]))
					{
					if (neighbor.Number != parent.Number) {
						int movesReturned;
						movesReturned = countMoves(src, neighbor, dest, moves + 1);
						if (movesReturned != -1) {
							return movesReturned;
						}
					} 
				}
			}
			
			return -1;
		}
	}

	private static void printSquares(Square square) {
		System.out.println("Number = " + square.Number);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Square s = board.get(i).get(j);
				System.out.print("|" + s.Number + "(" + s.position[0] + "," + s.position[1] + ")|");
			}
			System.out.println();
		}
	}
	
	static class Square{ // Abstraction for each Board Square
		int Number; // The number contained in this square
		ArrayList<Square> knightNeighbors = new ArrayList<>(8); // List of the squares to where the knight can move from this square
		int[] position = new int[2];
		
		public Square(int number) {
			Number = number;
		}
	}
}
