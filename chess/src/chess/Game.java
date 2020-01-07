package chess;

import java.util.Scanner;

public class Game {

	
	public static void main(String[] args) {

		Board board = new Board();
		Piece activePiece;
		Spot startSpot, endSpot;
		int startX, startY, endX, endY;
		int moveCounter = 1;
		String moveColor;
		Piece testPiece;
		Piece endPiece;
		boolean whiteCheck = false;
		boolean blackCheck = false;
		boolean checkMate = false;
		int checkmateCounter = 0;
		Scanner inputScanner = new Scanner(System.in);
		
		//Initialize white pawns
		Pawn wp1 = new Pawn("wp", board.getSpot(6,0), "white");
		board.getSpot(6,0).setPiece(wp1);
		Pawn wp2 = new Pawn("wp", board.getSpot(6,1), "white");
		board.getSpot(6,1).setPiece(wp2);
		Pawn wp3 = new Pawn("wp", board.getSpot(6,2), "white");
		board.getSpot(6,2).setPiece(wp3);
		Pawn wp4 = new Pawn("wp", board.getSpot(6,3), "white");
		board.getSpot(6,3).setPiece(wp4);
		Pawn wp5 = new Pawn("wp", board.getSpot(6,4), "white");
		board.getSpot(6,4).setPiece(wp5);
		Pawn wp6 = new Pawn("wp", board.getSpot(6,5), "white");
		board.getSpot(6,5).setPiece(wp6);
		Pawn wp7 = new Pawn("wp", board.getSpot(6,6), "white");
		board.getSpot(6,6).setPiece(wp7);
		Pawn wp8 = new Pawn("wp", board.getSpot(6,7), "white");
		board.getSpot(6,7).setPiece(wp8);
		
		//Initialize white pieces
		King wk = new King("wk", board.getSpot(7,4), "white");
		board.getSpot(7,4).setPiece(wk);
		Queen wq = new Queen("wq", board.getSpot(7,3), "white");
		board.getSpot(7,3).setPiece(wq);
		Rook wr1 = new Rook("wr", board.getSpot(7,7), "white");
		board.getSpot(7,7).setPiece(wr1);
		Rook wr2 = new Rook("wr", board.getSpot(7,0), "white");
		board.getSpot(7,0).setPiece(wr2);
		Knight wn1 = new Knight("wn", board.getSpot(7,6), "white");
		board.getSpot(7,6).setPiece(wn1);
		Knight wn2 = new Knight("wn", board.getSpot(7,1), "white");
		board.getSpot(7,1).setPiece(wn2);
		Bishop wb1 = new Bishop("wb", board.getSpot(7,5), "white");
		board.getSpot(7,5).setPiece(wb1);
		Bishop wb2 = new Bishop("wb", board.getSpot(7,2), "white");
		board.getSpot(7,2).setPiece(wb2);
		
		//Initialize black pawns
		Pawn bp1 = new Pawn("bp", board.getSpot(1,0), "black");
		board.getSpot(1,0).setPiece(bp1);
		Pawn bp2 = new Pawn("bp", board.getSpot(1,1), "black");
		board.getSpot(1,1).setPiece(bp2);
		Pawn bp3 = new Pawn("bp", board.getSpot(1,2), "black");
		board.getSpot(1,2).setPiece(bp3);
		Pawn bp4 = new Pawn("bp", board.getSpot(1,3), "black");
		board.getSpot(1,3).setPiece(bp4);
		Pawn bp5 = new Pawn("bp", board.getSpot(1,4), "black");
		board.getSpot(1,4).setPiece(bp5);
		Pawn bp6 = new Pawn("bp", board.getSpot(1,5), "black");
		board.getSpot(1,5).setPiece(bp6);
		Pawn bp7 = new Pawn("bp", board.getSpot(1,6), "black");
		board.getSpot(1,6).setPiece(bp7);
		Pawn bp8 = new Pawn("bp", board.getSpot(1,7), "black");
		board.getSpot(1,7).setPiece(bp8);
		
		//Initialize black pieces
		King bk = new King("bk", board.getSpot(0,4), "black");
		board.getSpot(0,4).setPiece(bk);
		Queen bq = new Queen("bq", board.getSpot(0,3), "black");
		board.getSpot(0,3).setPiece(bq);
		Rook br1 = new Rook("br", board.getSpot(0,7), "black");
		board.getSpot(0,7).setPiece(br1);
		Rook br2 = new Rook("br", board.getSpot(0,0), "black");
		board.getSpot(0,0).setPiece(br2);
		Knight bn1 = new Knight("bn", board.getSpot(0,6), "black");
		board.getSpot(0,6).setPiece(bn1);
		Knight bn2 = new Knight("bn", board.getSpot(0,1), "black");
		board.getSpot(0,1).setPiece(bn2);
		Bishop bb1 = new Bishop("bb", board.getSpot(0,5), "black");
		board.getSpot(0,5).setPiece(bb1);
		Bishop bb2 = new Bishop("bb", board.getSpot(0,2), "black");
		board.getSpot(0,2).setPiece(bb2);
		
		//Display start board
		board.displayBoard();
		
		//Loops while there is no checkmate
		while (checkMate == false) {
			//Test if either of the kings is in check
			int outerCheckCounter = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					testPiece = board.getSpot(i,j).getPiece();
					if (testPiece != null) {
						if (testPiece.getColor() == "black" && testPiece.canMove(board, testPiece.getSpot(), wk.getSpot()) == true) {
							whiteCheck = true;
							outerCheckCounter++;
							System.out.println("The white king is in check!");
						} else if (testPiece.getColor() == "white" && testPiece.canMove(board, testPiece.getSpot(), bk.getSpot()) == true) {
							blackCheck = true;
							System.out.println("The black king is in check!");
							outerCheckCounter++;
						}
					}
				}
			}
			if (outerCheckCounter == 0) {
				whiteCheck = false;
				blackCheck = false;
			}
			
			//If the move number is odd, it is white's turn. Otherwise it is black's turn
			System.out.println("Move: " + moveCounter);
			if (moveCounter % 2 != 0) {
				System.out.println("WHITE: ");
				moveColor = "white";
			} else {
				System.out.println("BLACK: ");
				moveColor = "black";
			}
			System.out.println("Enter a start x: ");
			startX = inputScanner.nextInt();
			System.out.println("Enter a start y: ");
			startY = inputScanner.nextInt();
		
			//Checks to make sure startX and startY are correct
			if (board.getSpot(startX,startY).getPiece() == null) {
				System.out.println("No piece here!");
				continue;
			} else if (board.getSpot(startX,startY).getPiece().getColor() == "white" && moveCounter % 2 == 0) {
				System.out.println("It's black's move!");
				continue;
			} else if (board.getSpot(startX,startY).getPiece().getColor() == "black" && moveCounter % 2 != 0) {
				System.out.println("It's white's move!");
				continue;
			}
			startSpot = board.getSpot(startX,startY);
			
			System.out.println("Enter an end x: ");
			endX = inputScanner.nextInt();
			System.out.println("Enter an end y");
			endY = inputScanner.nextInt();
			
			endSpot = board.getSpot(endX,endY);
			activePiece = board.getSpot(startX,startY).getPiece();
			
			if (activePiece.canMove(board, startSpot, endSpot) == true) {
				
				//Update the board
				endPiece = endSpot.getPiece();
				if (endPiece != null) {
					endPiece.setSpot(null);
				}
				startSpot.setPiece(null);
				endSpot.setPiece(activePiece);
				activePiece.setSpot(endSpot);
				
				//Test if previous move caused a check
				int innerCheckCounter = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						testPiece = board.getSpot(i,j).getPiece();
						if (testPiece != null) {
							if (testPiece.getSpot() != null) {
								if (testPiece.getColor() == "black" && testPiece.canMove(board, testPiece.getSpot(), wk.getSpot()) == true) {
									whiteCheck = true;
									innerCheckCounter++;
								} else if (testPiece.getColor() == "white" && testPiece.canMove(board, testPiece.getSpot(), bk.getSpot()) == true) {
									blackCheck = true;
									innerCheckCounter++;
								}
							}
						}
					}
				}
				if (innerCheckCounter == 0) {
					whiteCheck = false;
					blackCheck = false;
				}
				
				//If there was an existing check and there is still a check after the previous move
				if (outerCheckCounter > 0 && (whiteCheck == true || blackCheck == true)) {
					System.out.println("There is still a check!");
					startSpot.setPiece(activePiece);
					activePiece.setSpot(startSpot);
					endSpot.setPiece(endPiece);
					board.displayBoard();
					continue;
				} 
				//If there was no existing check, but the player put themselves in check
				else if (outerCheckCounter == 0 && innerCheckCounter > 0 && ((moveColor == "white" && whiteCheck == true) || (moveColor == "black" && blackCheck == true))) {
					System.out.println("You put yourself in check!");
					startSpot.setPiece(activePiece);
					activePiece.setSpot(startSpot);
					endSpot.setPiece(endPiece);
					board.displayBoard();
					continue;
				}
				//If the previous move put the opposite player in check, test for a checkmate
				else if (innerCheckCounter > 0 && ((moveColor == "black" && whiteCheck == true) || (moveColor == "white" && blackCheck == true))) {
					int validMoves = 0;
					
					//External loop to loop through every spot on the board
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							Piece trialPiece;
							trialPiece = board.getSpot(i,j).getPiece();
							if (trialPiece != null && whiteCheck == true && trialPiece.getColor() == "white") {
								
								//Loop to go through every possible move of piece
								for (int k = 0; k < 8; k++) {
									for (int l = 0; l < 8; l++) {
										
										if (trialPiece.canMove(board, trialPiece.getSpot(), board.getSpot(k,l)) == true) {
											
											//Set test position
											startSpot = trialPiece.getSpot();
											endSpot = board.getSpot(k,l);
											endPiece = board.getSpot(k,l).getPiece();
											if (endPiece != null) {
												endPiece.setSpot(null);
											}
											startSpot.setPiece(null);
											endSpot.setPiece(trialPiece);
											trialPiece.setSpot(board.getSpot(k,l));
											
											//Reset the check counter
											checkmateCounter = 0;
											
											//Test if the white king is in check
											for (int m = 0; m < 8; m++) {
												for (int n = 0; n < 8; n++) {
													Piece tempPiece;
													tempPiece = board.getSpot(m,n).getPiece();
													if (tempPiece != null) {
														if (tempPiece.getSpot() != null) {
															if (tempPiece.getColor() == "black" && tempPiece.canMove(board, tempPiece.getSpot(), wk.getSpot()) == true) {
																checkmateCounter++;
															}
														}
													}
												}
											}
											if (checkmateCounter == 0) {
												validMoves++;
											}
											
											//Reset position
											if (endPiece != null) {
												endPiece.setSpot(board.getSpot(k,l));
											}
											startSpot.setPiece(trialPiece);
											trialPiece.setSpot(startSpot);
											endSpot.setPiece(endPiece);
										}
										
									}
								}
							} else if (trialPiece != null && blackCheck == true && trialPiece.getColor() == "black") {
								
								//Loop to go through every possible move of piece
								for (int k = 0; k < 8; k++) {
									for (int l = 0; l < 8; l++) {
										
										if (trialPiece.canMove(board, trialPiece.getSpot(), board.getSpot(k,l)) == true) {
											
											//Set test position
											startSpot = trialPiece.getSpot();
											endSpot = board.getSpot(k,l);
											endPiece = board.getSpot(k,l).getPiece();
											if (endPiece != null) {
												endPiece.setSpot(null);
											}
											startSpot.setPiece(null);
											endSpot.setPiece(trialPiece);
											trialPiece.setSpot(board.getSpot(k,l));
											
											//Reset the check counter
											checkmateCounter = 0;
											
											//Test if the black king is in check
											for (int m = 0; m < 8; m++) {
												for (int n = 0; n < 8; n++) {
													Piece tempPiece;
													tempPiece = board.getSpot(m,n).getPiece();
													if (tempPiece != null) {
														if (tempPiece.getSpot() != null) {
															if (tempPiece.getColor() == "white" && tempPiece.canMove(board, tempPiece.getSpot(), bk.getSpot()) == true) {
																checkmateCounter++;
															}
														}
													}
												}
											}
											if (checkmateCounter == 0) {
												validMoves++;
											}
											
											//Reset position
											if (endPiece != null) {
												endPiece.setSpot(board.getSpot(k,l));
											}
											startSpot.setPiece(trialPiece);
											trialPiece.setSpot(startSpot);
											endSpot.setPiece(endPiece);

										}
										
									}
								}
							}
						}
					}
					//If the validMoves counter was activated, there is no checkmate
					if (validMoves > 0) {
						checkMate = false;
					} else if (validMoves == 0) {
						checkMate = true;
						board.displayBoard();
						System.out.println("Checkmate!");
					}
				}
				
				moveCounter++;
				
			} else {
				System.out.println("Invalid move!");
			}
			
			//Only display the board at the end of the move if it is not checkmate
			if (checkMate == false) {
				board.displayBoard();
			}
		}
		
		inputScanner.close();
		
	}
}


