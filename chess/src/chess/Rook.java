package chess;

public class Rook extends Piece {

	public Rook(String n, Spot p, String c) {
		super(n, p, c);
	}

	public boolean canMove(Board board, Spot start, Spot end) {
		boolean dir;
		boolean path = true;
		boolean captureDir = false;
		
		//Check validity of capture direction
		if ((Math.abs(end.getY()-start.getY()) == 0 && Math.abs(end.getX()-start.getX()) != 0) || (Math.abs(end.getY()-start.getY()) != 0 && Math.abs(end.getX()-start.getX()) == 0)) {
			dir = true;
		}
		else {
			dir = false;
		}
		
		//Check if path is clear
		if (dir == true) {
			if (end.getX()-start.getX() > 0) {
				for (int i = start.getX() + 1; i < end.getX(); i++) {
					if (board.getSpot(i,start.getY()).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getX()-start.getX() < 0) {
				for (int i = start.getX() - 1; i > end.getX(); i--) {
					if (board.getSpot(i,start.getY()).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getY()-start.getY() > 0) {
				for (int i = start.getY() + 1; i < end.getY(); i++) {
					if (board.getSpot(start.getX(),i).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getY()-start.getY() < 0) {
				for (int i = start.getY() - 1; i > end.getY(); i--) {
					if (board.getSpot(start.getX(),i).getPiece() != null) {
						path = false;
					}
				}
			} else {
				path = true;
			}
		}
		
		//Check validity of capture direction
		if (end.getPiece() != null) {
			if ((start.getPiece().getColor() == "white") && end.getPiece().getColor() == "black" && dir == true && path == true) {
				captureDir = true;
			} else if ((start.getPiece().getColor() == "black") && end.getPiece().getColor() == "white" && dir == true && path == true) {
				captureDir = true;
			} else {
				captureDir = false;
			}
		}
		
		if ((end.getPiece() == null && dir == true && path == true) || captureDir == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
}