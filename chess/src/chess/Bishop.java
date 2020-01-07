package chess;

public class Bishop extends Piece {

	public Bishop(String n, Spot p, String c) {
		super(n, p, c);
	}

	public boolean canMove(Board board, Spot start, Spot end) {
		boolean dir;
		boolean path = true;
		boolean captureDir = false;
		
		//Check validity of move direction
		if (Math.abs(end.getY()-start.getY()) == Math.abs(end.getX()-start.getX())) {
			dir = true;
		}
		else {
			dir = false;
		}
		
		//Check if path is clear
		if (dir == true) {
			if (end.getX()-start.getX() > 0 && end.getY()-start.getY() > 0) {
				for (int i = 1; i < end.getX() - start.getX(); i++) {
					if (board.getSpot(start.getX() + i,start.getY() + i).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getX()-start.getX() > 0 && end.getY()-start.getY() < 0) {
				for (int i = 1; i < end.getX()-start.getX(); i++) {
					if (board.getSpot(start.getX() + i,start.getY() - i).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getX()-start.getX() < 0 && end.getY()-start.getY() > 0) {
				for (int i = 1; i < end.getY()-start.getY(); i++) {
					if (board.getSpot(start.getX() - i,start.getY() + i).getPiece() != null) {
						path = false;
					}
				}
			}
			else if (end.getX()-start.getX() < 0 && end.getY()-start.getY() < 0) {
				for (int i = 1; i < start.getX() - end.getX(); i++) {
					if (board.getSpot(start.getX() - i,start.getY() - i).getPiece() != null) {
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