package chess;

public class Spot {
	
	private Piece piece;
	private int x;
	private int y;
	
	public Spot(int x, int y, Piece piece) {
		this.setX(x);
		this.setY(y);
		this.setPiece(piece);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Piece getPiece() {
		return piece;
	}
}