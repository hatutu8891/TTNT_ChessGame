package model;

public class Position {
	private int row;
	private int column;
	
	
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	//numCellMoveRow: So o di theo hang ngang
	//numCellMoveCol: So o di theo hang doc
	public Position changePosition(int numCellMoveRow , int numCellMoveCol) {
		return new Position(row+numCellMoveRow, column+numCellMoveCol);
	}
	
	

}
