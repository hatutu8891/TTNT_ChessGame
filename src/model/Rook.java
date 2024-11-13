package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class Rook extends Piece {

	public Rook(Position position, boolean color, int moved) {
		super(position, color, moved);
	}

	// Phương thức để lấy các nước đi hợp lệ của quân Xe
	public List<Position> getLegalMoves(ChessBoard board) {
		List<Position> legalMoves = new ArrayList<>();
		int x = this.getPosition().getX(); // Lấy tọa độ X của Xe
		int y = this.getPosition().getY(); // Lấy tọa độ Y của Xe

		// Di chuyển theo chiều dọc (hàng)
		for (int i = 0; i < 8; i++) {
			if (i != x) { // Tránh di chuyển đến chính ô mình đang đứng
				Position newPos = new Position(i, y);
				if (isMoveValid(newPos, board)) {
					legalMoves.add(newPos);
				}
			}
		}

		// Di chuyển theo chiều ngang (cột)
		for (int j = 0; j < 8; j++) {
			if (j != y) { // Tránh di chuyển đến chính ô mình đang đứng
				Position newPos = new Position(x, j);
				if (isMoveValid(newPos, board)) {
					legalMoves.add(newPos);
				}
			}
		}

		return legalMoves;
	}

	// Phương thức kiểm tra tính hợp lệ của một nước đi
	public boolean isMoveValid(Position newPosition, ChessBoard board) {
		// Kiểm tra nếu nước đi nằm trong bàn cờ
		if (!isInBounds(newPosition.getX(), newPosition.getY())) {
			return false;
		}

		// Kiểm tra nếu ô mới có quân cờ cùng màu
		Piece targetPiece = board.getBoard()[newPosition.getX()][newPosition.getY()];
		if (targetPiece != null && targetPiece.getColor() == this.getColor()) {
			return false;
		}

		// Kiểm tra không có quân cờ nào chắn đường đi của Xe
		if (!isPathClear(newPosition, board)) {
			return false;
		}

		return true;
	}

	// Phương thức kiểm tra nếu đường đi của Xe không bị chắn
	private boolean isPathClear(Position newPosition, ChessBoard board) {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();

		// Nếu di chuyển theo chiều dọc
		if (x == newPosition.getX()) {
			int minY = Math.min(y, newPosition.getY());
			int maxY = Math.max(y, newPosition.getY());
			for (int i = minY + 1; i < maxY; i++) {
				if (board.getBoard()[x][i] != null) {
					return false; // Có quân chắn đường
				}
			}
		}

		// Nếu di chuyển theo chiều ngang
		if (y == newPosition.getY()) {
			int minX = Math.min(x, newPosition.getX());
			int maxX = Math.max(x, newPosition.getX());
			for (int i = minX + 1; i < maxX; i++) {
				if (board.getBoard()[i][y] != null) {
					return false; // Có quân chắn đường
				}
			}
		}

		return true;
	}

	// Phương thức kiểm tra xem một vị trí có nằm trong phạm vi bàn cờ không
	private boolean isInBounds(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
}
