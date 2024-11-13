package view;

import model.Piece;
import model.Position;

public class ChessBoardUI {
	private TileUI[][] tiles;

	public ChessBoardUI() {
		this.tiles = new TileUI[8][8]; // Bàn cờ có 8x8 ô
		initializeBoard();
	}

	// Khởi tạo bàn cờ với các ô trống
	private void initializeBoard() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				tiles[x][y] = new TileUI(new Position(x, y));
			}
		}
	}

	// Phương thức vẽ bàn cờ, có thể hiển thị các quân cờ
	public void drawBoard() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				TileUI tile = tiles[x][y];
				tile.clearHighlight(); // Xóa các hiệu ứng nổi bật cũ
				if (tile.getPiece() != null) {
					// Nếu có quân cờ, vẽ quân cờ
					//code
				} else {
					// Ô trống
				}
			}
			System.out.println(); // Xuống dòng sau mỗi hàng
		}
	}

	// Đặt quân cờ tại vị trí xác định trên bàn cờ
	public void placePiece(Piece piece, Position position) {
		TileUI tile = tiles[position.getX()][position.getY()];
		tile.setPiece(new ChessPieceUI(piece));
		//System.out.println("Placing " + piece.getType() + " at (" + position.getX() + ", " + position.getY() + ")");
	}

	// Xóa quân cờ tại vị trí xác định
	public void clearPiece(Position position) {
		TileUI tile = tiles[position.getX()][position.getY()];
		tile.removePiece();
		System.out.println("Clearing piece at (" + position.getX() + ", " + position.getY() + ")");
	}

	// Làm nổi bật ô tại vị trí xác định
	public void highlightTile(Position position) {
		TileUI tile = tiles[position.getX()][position.getY()];
		tile.highlight();
	}
}
