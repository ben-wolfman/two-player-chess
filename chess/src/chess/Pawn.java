package chess;

public class Pawn extends Piece {
	
	public Pawn(String n, Spot p, String c) {
		super(n, p, c);
	}
	
	public boolean canMove(Board board, Spot start, Spot end) {
		boolean dir;
		boolean captureDir = false;
		
		//Check validity of move direction
		if ((start.getPiece().getColor() == "white") && (end.getX()-start.getX()) == -1 && end.getY()-start.getY() == 0) {
			dir = true;
		} else if ((start.getPiece().getColor() == "black") && (end.getX()-start.getX()) == 1 && end.getY()-start.getY() == 0) {
			dir = true;
		}
		else if (start.getPiece().getColor() == "white" && start.getX() == 6 && board.getSpot(start.getX() - 1, start.getY()).getPiece() == null && end.getX()-start.getX() == -2 && end.getY()-start.getY() == 0) {
			dir = true;
		} else if (start.getPiece().getColor() == "black" && start.getX() == 1 && board.getSpot(start.getX() + 1, start.getY()).getPiece() == null && end.getX()-start.getX() == 2 && end.getY()-start.getY() == 0) {
			dir = true;
		}
		else {
			dir = false;
		}
		
		//Check validity of capture direction
		if (end.getPiece() != null) {
			if ((start.getPiece().getColor() == "white") && end.getPiece().getColor() == "black" && (end.getX()-start.getX()) == -1 && (Math.abs(end.getY()-start.getY()) == 1)) {
				captureDir = true;
			} else if ((start.getPiece().getColor() == "black") && end.getPiece().getColor() == "white" && (end.getX()-start.getX()) == 1 && (Math.abs(end.getY()-start.getY()) == 1)) {
				captureDir = true;
			} else {
				captureDir = false;
			}
		}
		
		if ((captureDir == true) || (end.getPiece() == null && dir == true)) {
			return true;
		}
		else {
			return false;
		}
	}
}