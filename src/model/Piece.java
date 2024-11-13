package model;

import java.util.List;

public abstract class Piece {
	protected Position position;
	protected boolean color;
	protected int moved;

	public abstract List<Position> getLegalMoves(ChessBoard board);

	public abstract boolean isMoveValid(Position newPosition, ChessBoard board);
}
