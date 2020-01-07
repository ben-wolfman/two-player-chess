package chess;

public class Board {
	
	private Spot[][] spots = new Spot[8][8];
	
	public Piece pieceAt(Spot p) {
		return p.getPiece();
	}
	
	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				spots[i][j] = new Spot(i, j, null);
			}
		}
	}
	
	public void displayBoard() {
		System.out.print("   ");
		for (int k = 0; k < 8; k++) {
			System.out.print(k + "  ");
		}
		System.out.println();
		System.out.print("   ");
		for (int k = 0; k < 8; k++) {
			System.out.print("-  ");
		}
		System.out.println();
		for (int i = 0; i < 8; i++) {
			System.out.print(i + "| ");
			for (int j = 0; j < 8; j++) {
				if (spots[i][j].getPiece() == null) {
					System.out.print(0 + "  ");
				} else {
					System.out.print(spots[i][j].getPiece().getName() + " ");
				}
			}
			System.out.println();
		}
	}
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
	
}