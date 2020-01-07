package chess;

public abstract class Piece {

	private String name;
	private String color;
	private Spot position;

	public Piece(String n, Spot p, String c) {
		this.name = n;
		this.position = p;
		this.color = c;
	}
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public Spot getSpot() {
		return position;
	}
	public void setSpot(Spot p) {
		this.position = p;
	}
	
	public abstract boolean canMove(Board board, Spot start, Spot end);
}