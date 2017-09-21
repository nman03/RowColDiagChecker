import java.util.Scanner;

public class RowColDiagChecker {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		// Prompt
		System.out.print("\nEnter matrix size: ");
		int size = in.nextInt();
		System.out.println();
		
		int[][] matrix = makeArray(size, size);
		prtArray(matrix);
		checkRows(matrix);
		checkCols(matrix);
		checkMajorDiagonal(matrix);
		checkMinorDiagonal(matrix);	
	}
	
	public static int[][] makeArray(int x, int y) {
		int[][] array = new int[x][y];
		
		for (int row = 0 ; row < array.length ; row++) {
			for (int col = 0 ; col < array[row].length ; col++) {
				array[row][col] = 1 + (int)(Math.random() * 2);
			}
		}
		
		return array;
	}
	
	public static void prtArray(int[][] array) {
		for (int row = 0 ; row < array.length ; row++) {
			for (int col = 0 ; col < array[row].length ; col++) {
				if (array[row][col] == 1) {
					System.out.print("o ");
				}
				else {
					System.out.print("x ");
				}
			}
			System.out.println();
		}
	}
	
	public static void checkRows(int[][] array) {
		int initialNum = array[0][0];
		boolean same = false;
		
		for (int row = 0 ; row < array.length ; row++) {
			for (int col = 0 ; col < array[row].length ; col++) {
				initialNum = array[row][0];
				if (array[row][col] == initialNum) {
					same = true;
				}
				else {
					same = false;
					break;
				}
			}
			if (same) {
				if (initialNum == 1) {
					System.out.print("\nAll o's in row " + (row + 1) + ".");
				}
				else {
					System.out.print("\nAll x's in row " + (row + 1) + ".");
				}
			}
		}
	}
	
	public static void checkCols(int[][] array) {
		for (int col = 0 ; col < array[0].length ; col++){
			int initialNum = array[0][col];
			boolean same = false;
			for (int row = 0 ; row < array.length ; row++) {
				if (array[row][col] == initialNum) {
					same = true;
				}
				else {
					same = false;
					break;
				}
				
			}
			if (same) {
				if (initialNum == 1) {
					System.out.print("\nAll o's in column " + (col + 1) + ".");
				}
				else {
					System.out.print("\nAll x's in column " + (col + 1) + ".");
				}
			}
		}
	}
	
	public static void checkMajorDiagonal(int[][] array) {
		int initialNum = array[0][0];
		boolean same = false;
		
		for (int row = 0, col = 0 ; row < array.length && col < array[row].length  ; row++, col++) {
			if (array[row][col] == initialNum) {
				same = true;
			}
			else {
				same = false;
				break;
			}
		}
		
		if (same) {
				if (initialNum == 1) {
					System.out.print("\nAll o's in major diagonal.");
				}
				else {
					System.out.print("\nAll x's in major diagonal.");
				}
			}
	}
	
	public static void checkMinorDiagonal(int[][] array) {
		int initialNum = array[0][array[0].length - 1];
		boolean same = false;
		
		for (int row = 0, col = array[row].length - 1 ; row < array.length && col >= 0  ; row++, col--) {
			if (array[row][col] == initialNum) {
				same = true;
			}
			else {
				same = false;
				break;
			}
		}
		
		if (same) {
				if (initialNum == 1) {
					System.out.print("\nAll o's in minor diagonal.");
				}
				else {
					System.out.print("\nAll x's in minor diagonal.");
				}
			}
	}
}
