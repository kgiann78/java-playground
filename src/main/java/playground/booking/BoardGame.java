import java.util.*;

class BoardGame {

	static int [][] board;

	void createBoard() {
		for (int i=0; i < board.length; i++) {
			for (int j=0; j < board[i].length; j++) {
				board[i][j] = 0; 
			}
		}
	}

	void createMove(int x, int y, int colour) {
		if (getStatus(x, y) != 0) {
			System.out.println("Oups, wrong position. Next time be careful");
			return;
		}
		board[x][y] = colour;
	}

	int getStatus(int x, int y) {
		if (x >= board.length || x < 0) return 3;
		if (y >= board[x].length || y < 0) return 3;
		else return board[x][y];
	}

	boolean isCaptured(int x, int y, int px, int py) {
		int own = getStatus(x,y);
		if (own == 0) return false;

		boolean captured = true;

		for (int i=x-1; i <= x+1; i++) {
			for (int j=y-1; j <= y+1; j++) {

				if (((i == x-1) || ( i == x+1)) && j != y) continue;
				if (((j == y-1) || (j == y + 1)) && i != x) continue;
				if (i== x && j == y) continue;
 				
 				if (getStatus(i, j) == 0) return false;
 				else if (getStatus(i, j) == own) {
 					if (px != i || py != j) {
 						captured &= isCaptured(i, j, x, y);
 					}
 				}
			}
		}

		return captured;
	}
 
	public static void main(String[] args) {
	
		if (args.length != 2) {
			System.out.println("Proper use: BoardGame [size of table x y]\ni.e. BoardGame 5 5");
			return;
		}

		board = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		BoardGame boardGame = new BoardGame();
		boardGame.createBoard();
		Scanner in = new Scanner(System.in);
		int player = 2;

		while (true) {
			player = (player % 2) + 1;

			for (int i=0; i < board.length; i++) {
				for (int j=0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.print("\n");
			}

			System.out.print("Player " + player + " move: ");

			int x = in.nextInt();
			int y = in.nextInt();

			if (x == -1 && y == -1) return;

			boardGame.createMove(x, y, player);
			if (boardGame.isCaptured(x, y, -1, -1)) {
				System.out.println("No more movements for this pawn");
				return;
			}
		}
	}
}