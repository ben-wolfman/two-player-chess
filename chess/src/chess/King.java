package chess;

public class King extends Piece {
	
	public King(String n, Spot p, String c) {
		super(n, p, c);
	}
	
	public boolean canMove(Board board, Spot start, Spot end) {
		boolean dir;
		boolean captureDir = false;
		
		//Check validity of move direction
		if ((Math.abs(end.getY()-start.getY()) == 1 && Math.abs(end.getX()-start.getX()) == 1) || (Math.abs(end.getY()-start.getY()) == 1 && Math.abs(end.getX()-start.getX()) == 0) || (Math.abs(end.getY()-start.getY()) == 0 && Math.abs(end.getX()-start.getX()) == 1)) {
			dir = true;
		}
		else {
			dir = false;
		}
		
		//Check validity of capture direction
		if (end.getPiece() != null) {
			if ((start.getPiece().getColor() == "white") && end.getPiece().getColor() == "black" && dir == true) {
				captureDir = true;
			} else if ((start.getPiece().getColor() == "black") && end.getPiece().getColor() == "white" && dir == true) {
				captureDir = true;
			} else {
				captureDir = false;
			}
		}
		
		if ((end.getPiece() == null && dir == true) || captureDir == true) {
			return true;
		}
		else {
			return false;
		}
	}

}