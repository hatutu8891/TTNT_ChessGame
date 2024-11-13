package model;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	@Override
	public List<Position> getLegalMoves(ChessBoard board) {
		List<Position> listLegalMove = new ArrayList<>();
		if (moved == 0) {
			listLegalMove.add(position.changePosition(0, 1));
			listLegalMove.add(position.changePosition(0, 2));
		}
		listLegalMove.add(position.changePosition(0, 1));
		return listLegalMove;
	}

	// Tham so board hoi du nhi
	@Override
	public boolean isMoveValid(Position newPosition, ChessBoard board) {
		for (Position pos : getLegalMoves(board)) {
			return newPosition.equals(pos);
		}
		return false;

	}

	private boolean canEnPassant() {
		return false;
	}

	private void enPassant() {

	}

	private Piece promote() {
		return null;
	}

}
