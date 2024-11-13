package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class King extends Piece {
	
	public King(Position positon, boolean color, int moved) {
		super(positon, color, moved);
	}

	public List<Position> getLegalMoves(ChessBoard board) {
		List<Position> legalMoves = new ArrayList<>();
		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

		for (int i = 0; i < 8; i++) {
			int newX = this.getPosition().getX() + dx[i];
			int newY = this.getPosition().getY() + dy[i];

			// Kiểm tra nếu vị trí nằm trong bàn cờ
			if (isInBounds(newX, newY)) {
				Position newPos = new Position(newX, newY);
				if (isMoveValid(newPos, board)) 
					legalMoves.add(newPos);
				}
			}
		
		return legalMoves;
	}


	// Phương thức kiểm tra tính hợp lệ của một nước đi
	public boolean isMoveValid(Position newPosition, ChessBoard board) {
		// Kiểm tra nếu nước đi nằm trong bàn cờ và không ra ngoài
		if (!isInBounds(((Object) newPosition).getX(), ((Object) newPosition).getY())) {
			return false;
		}

		// Kiểm tra nếu ô mới có quân cờ cùng màu
		Piece targetPiece = board.getBoard()[newPosition.getX()][newPosition.getY()];
		if (targetPiece != null && targetPiece.getColor() == this.getColor()) {
			return false;
		}

		// Nếu không vi phạm các điều kiện trên, nước đi hợp lệ
		return true;
	}

	// Kiểm tra xem quân Vua có thể nhập thành không
	public boolean canCastle(ChessBoard board) {
		// Kiểm tra nếu quân Vua và Xe chưa di chuyển
		if (this.getMoved() > 0) {
			return false;
		}

		// Kiểm tra nếu có quân cờ nào nằm giữa Vua và Xe
		// Cần viết mã kiểm tra quân nằm giữa Vua và Xe (tùy thuộc vào cách cài đặt bảng
		// cờ).

		// Kiểm tra không có chiếu tướng và không đi qua ô bị chiếu
		// Cần phải kiểm tra không có tình huống chiếu tướng trong suốt quá trình nhập
		// thành.

		// Nếu tất cả các điều kiện đều đúng, Vua có thể nhập thành.
		return true;
	}

	// Thực hiện thao tác nhập thành (di chuyển Vua và Xe cùng lúc)
	public void castle() {
		// Thực hiện di chuyển quân Vua và Xe cùng lúc
		// Cần phải thực hiện điều kiện di chuyển Vua và Xe về đúng vị trí nhập thành
	}

	// Phương thức kiểm tra xem một vị trí có nằm trong phạm vi bàn cờ không
	private boolean isInBounds(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
	
	
}
