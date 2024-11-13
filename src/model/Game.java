package model;

public class Game {

	private ChessBoard board;
	private Player whitePlayer;
	private Player blackPlayer;
	private Player currentPlayer;
	private boolean isGameOver;

	public Game() {
		this.board = new ChessBoard();
		this.whitePlayer = new Player();
		this.blackPlayer = new Player();
		this.currentPlayer = whitePlayer; // Trắng đi trước
		this.isGameOver = false;
	}

	// Phương thức bắt đầu trò chơi
	public void startGame() {
		// Thiết lập bàn cờ và các đối tượng người chơi
		this.board = new ChessBoard();
		this.whitePlayer = new Player();
		this.blackPlayer = new Player();
		this.currentPlayer = whitePlayer;
		this.isGameOver = false;
	}

	// Phương thức kết thúc trò chơi
	public void endGame(String result) {
		// Kết thúc trò chơi, in ra kết quả
		this.isGameOver = true;
		System.out.println("Game Over: " + result);
	}

	// Phương thức chuyển lượt giữa các người chơi
	public void nextTurn() {
		if (isGameOver) {
			System.out.println("Game over. No more turns.");
			return;
		}

		// Chuyển lượt giữa 2 người chơi
		if (currentPlayer == whitePlayer) {
			currentPlayer = blackPlayer;
		} else {
			currentPlayer = whitePlayer;
		}
	}

	// Phương thức để người chơi bỏ cuộc
	public void forfeitGame() {
		if (currentPlayer == whitePlayer) {
			endGame("wins by forfeit.");
		} else {
			endGame("wins by forfeit.");
		}
	}

	// Getter và Setter cho các trường
	public ChessBoard getBoard() {
		return board;
	}

	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isGameOver() {
		return isGameOver;
	}
}
