package view;

import model.Position;

public class TileUI {
	private Position position; // Vị trí của ô trong bàn cờ
	private ChessPieceUI piece; // Quân cờ gắn liền với ô này

	public TileUI(Position position) {
		this.position = position;
		this.piece = null; // Ban đầu ô không có quân cờ
	}

	// Phương thức làm nổi bật ô
	public void highlight() {
		// Thực hiện một số hành động để làm nổi bật ô (ví dụ: thay đổi màu nền)
		// Giả sử sử dụng một số phương thức UI để thay đổi giao diện
		// ví dụ: đổi màu nền ô, thay đổi viền hoặc hiển thị một hiệu ứng đặc biệt
	}

	// Phương thức xóa hiệu ứng làm nổi bật
	public void clearHighlight() {
		// Thực hiện các hành động để xóa hiệu ứng nổi bật của ô
		// Giả sử lại khôi phục lại màu nền hoặc viền ban đầu của ô
	}

	// Phương thức gán quân cờ vào ô
	public void setPiece(ChessPieceUI piece) {
		this.piece = piece;
		// Cập nhật giao diện nếu cần (hiển thị quân cờ lên ô này)
	}

	// Phương thức loại bỏ quân cờ khỏi ô
	public void removePiece() {
		this.piece = null;
		// Cập nhật giao diện để loại bỏ quân cờ khỏi ô này
	}

	// Getter cho vị trí
	public Position getPosition() {
		return position;
	}

	// Getter cho quân cờ tại ô này
	public ChessPieceUI getPiece() {
		return piece;
	}
}
