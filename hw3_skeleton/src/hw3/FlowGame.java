package hw3;

import api.Cell;
import api.Flow;

/**
 * Game state for a Flow Free game.
 * @author Andrew Hancock
 */
public class FlowGame {

	/**
	 * width of flow game
	 */
	private int width;

	/**
	 * height of flow game
	 */
	private int height;

	/**
	 * flows for flow game
	 */
	private Flow[] flows;

	/**
	 * current cell
	 */
	private Cell currentCell;

	/**
	 * Constructs a FlowGame to use the given array of Flows and the given width
	 * and height. Client is responsible for ensuring that all cells in the
	 * given flows have row and column values within the given width and height.
	 * 
	 * @param givenFlows
	 *            an array of Flow objects
	 * @param givenWidth
	 *            width to use for the game
	 * @param givenHeight
	 *            height to use for the game
	 */
	public FlowGame(Flow[] givenFlows, int givenWidth, int givenHeight) {
		width = givenWidth;
		height = givenHeight;
		flows = givenFlows;
		currentCell = null;
	}

	/**
	 * Constructs a FlowGame from the given descriptor.
	 * 
	 * @param descriptor
	 *            array of strings representing initial endpoint positions
	 */
	public FlowGame(String[] descriptor) {
		flows = Util.createFlowsFromStringArray(descriptor);
		width = descriptor[0].length();
		height = descriptor.length;
		currentCell = null;
	}

	/**
	 * Returns the width for this game.
	 * 
	 * @return width for this game
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height for this game.
	 * 
	 * @return height for this game
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the current cell for this game, possible null.
	 * 
	 * @return current cell for this game
	 */
	public Cell getCurrent() {
		return currentCell;
	}

	/**
	 * Returns all flows for this game. Client should not modify the returned
	 * array or lists.
	 * 
	 * @return array of flows for this game
	 */
	public Flow[] getAllFlows() {
		return flows;
	}

	/**
	 * Returns the number of occupied cells in all flows (including endpoints).
	 * 
	 * @return occupied cells in this game
	 */
	public int getCount() {
		int count = 0;

		// for this method I will iterate through all coords and see if they are
		// occupied.
		for (int b = 0; b < height; b++) {
			for (int y = 0; y < width; y++) {
				if (isOccupied(b, y) == true) {
					count++;
				}
			}
		}

		return count;
	}

	/**
	 * Returns true if all flows are complete and all cells are occupied.
	 * 
	 * @return true if all flows are complete and all cells are occupied
	 */
	public boolean isComplete() {
		// a variable that will be changed to false only if something isnt
		// complete and then this will be returned
		boolean isComplete = true;
		// iterate through all flows seeing if their cell arraylists contain
		// both endpoints
		for (int i = 0; i < flows.length; i++) {
			Cell endpoint1 = flows[i].getEndpoint(0);
			Cell endpoint2 = flows[i].getEndpoint(1);

			if ((flows[i].getCells().contains(endpoint1)) && (flows[i].getCells().contains(endpoint2))) {

			} else {
				isComplete = false;
			}
		}

		/*
		 * in order to check all spots for a cell I will iterate through the
		 * rows and in each row through the cells using the isOccupied method.
		 */
		for (int b = 0; b < height; b++) {
			for (int y = 0; y < width; y++) {
				if (isOccupied(b, y) != true) {
					isComplete = false;
				}
			}
		}

		return isComplete;
	}

	/**
	 * Attempts to set the "current" cell to be an existing cell at the given
	 * row and column. When using a GUI, this method is typically invoked when
	 * the mouse is pressed.
	 * <ul>
	 * <li>Any endpoint can be selected as the current cell. Selecting an
	 * endpoint clears the flow associated with that endpoint.
	 * <li>A non-endpoint cell can be selected as the current cell only if it is
	 * the last cell in a flow.
	 * </ul>
	 * If neither of the above conditions is met, this method does nothing.
	 * 
	 * @param row
	 *            given row
	 * @param col
	 *            given column
	 */
	public void startFlow(int row, int col) {

		// loop through all flows and check if coords are endpoints
		for (int i = 0; i < flows.length; i++) {
			// retrieve the endpoints firstly
			Cell endpoint1 = flows[i].getEndpoint(0);
			Cell endpoint2 = flows[i].getEndpoint(1);

			/*
			 * check to see if the coords passed in match either endpoints if
			 * they do set them to the current cell and add the cell to the flow
			 * and exit the method.
			 */
			if (endpoint1.getCol() == col && endpoint1.getRow() == row) {
				currentCell = flows[i].getEndpoint(0);
				flows[i].add(flows[i].getEndpoint(0));
				return;
			}
			if (endpoint2.getCol() == col && endpoint2.getRow() == row) {
				currentCell = flows[i].getEndpoint(1);
				flows[i].add(flows[i].getEndpoint(1));
				return;
			}

		}

		// loop through all flows and see if coords are flow endpoints and not
		// normal endpoints
		for (int w = 0; w < flows.length; w++) {
			if (flows[w].getCells().size() > 0) {
				Cell testCell = flows[w].getCells().get(flows[w].getCells().size() - 1);
				if (testCell.getCol() == col && testCell.getRow() == row) {
					flows[w].add(testCell);
					currentCell = testCell;
				}
			} else {
				continue;
			}
		}

	}

	/**
	 * Clears the "current" cell. That is, directly after invoking this method,
	 * <code>getCurrent</code> returns null. When using a GUI, this method is
	 * typically invoked when the mouse is released.
	 */
	public void endFlow() {
		currentCell = null;
	}

	/**
	 * Attempts to add a new cell to the flow containing the current cell. When
	 * using a GUI, this method is typically invoked when the mouse is dragged.
	 * In order to add a cell, the following conditions must be satisfied:
	 * <ol>
	 * <li>The current cell is non-null
	 * <li>The given position is horizontally or vertically adjacent to the
	 * current cell
	 * <li>The given position either is not occupied OR it is occupied by an
	 * endpoint for the flow that is not already in the flow
	 * </ul>
	 * If the three conditions are met, a new cell with the given row/column and
	 * correct color is added to the current flow, and the current cell is
	 * updated to be the new cell.
	 * 
	 * @param row
	 *            given row for the new cell
	 * @param col
	 *            given column for the new cell
	 */
	public void addCell(int row, int col) {

		// check to make sure the cell isn't null
		if (currentCell == null) {
			return;
		}

		// to keep track of which flow the cell will be added to
		int currentFlow = 0;

		// find out which flow the current cell is in
		for (int i = 0; i < flows.length; i++) {
			// iterate over the flow and check to see if the current cell is in
			// it
			if (flows[i].getCells().contains(currentCell)) {
				currentFlow = i;
				break;
			}
		}

		// declare a new cell to be added to the flow
		Cell newCell = new Cell(row, col, flows[currentFlow].getColor());

		/*
		 * check to see if its in an ok position first it check if the col is
		 * off by 1 and the row is the same then it checks if the row is off by
		 * 1 and then col is the same if so it continues and if not it breaks
		 * and doesn't ever add the cell
		 */
		if ((((currentCell.getCol() == (col - 1)) || (currentCell.getCol() == (col + 1)))
				&& (currentCell.getRow() == row))
				|| (((currentCell.getRow() == (row - 1)) || (currentCell.getRow() == (row + 1)))
						&& (currentCell.getCol() == col))) {

		} else {
			return;
		}

		/*
		 * see if the space is occupied. If it is check to see if it's an
		 * endpoint. if not move on
		 */
		if (isOccupied(row, col) == true) {
			// check to see if its the first endpoint. if so check to see if its
			// part of the flow already if it is return
			if (flows[currentFlow].getEndpoint(0).getCol() == col
					&& flows[currentFlow].getEndpoint(0).getRow() == row) {
				if (flows[currentFlow].getCells().contains(flows[currentFlow].getEndpoint(0))) {
					// exit and do nothing
					return;
				} else {
					// if the endpoint isn't in the flow add it then return
					flows[currentFlow].add(newCell);
					currentCell = newCell;
					return;
				}
			}
			// checks to see if its occupied by the second endpoint. if that
			// endpoint is already in the flow then return and dont do anything.
			if (flows[currentFlow].getEndpoint(1).getCol() == col
					&& flows[currentFlow].getEndpoint(1).getRow() == row) {
				if (flows[currentFlow].getCells().contains(flows[currentFlow].getEndpoint(1))) {
					return;
				} else {
					// if the endpoint isnt in the flow add it and then return
					flows[currentFlow].add(newCell);
					currentCell = newCell;
					return;
				}
			}
		} else {
			// if it isn't occupied then add it
			flows[currentFlow].add(newCell);
			currentCell = newCell;
		}

	}

	/**
	 * Returns true if the given position is occupied by a cell in a flow in
	 * this game (possibly an endpoint).
	 * 
	 * @param row
	 *            given row
	 * @param col
	 *            given column
	 * @return true if any cell in this game has the given row and column, false
	 *         otherwise
	 */
	public boolean isOccupied(int row, int col) {
		// iterate over the flows to see if they contain the space sent to this
		// method
		for (int i = 0; i < flows.length; i++) {
			// iterate over the cells in the flow
			for (int t = 0; t < flows[i].getCells().size(); t++) {
				// get the individual cell of the flow
				Cell cellToCompare = flows[i].getCells().get(t);

				// check x and y coords of the cell
				if (cellToCompare.getRow() == row && cellToCompare.getCol() == col) {
					return true;
				}

			}

			// here I need to say a cell is occupied if there is an endpoint
			// there
			Cell endpoint1 = flows[i].getEndpoint(0);
			Cell endpoint2 = flows[i].getEndpoint(1);

			if (endpoint1.getRow() == row && endpoint1.getCol() == col) {
				return true;
			}
			if (endpoint2.getRow() == row && endpoint2.getCol() == col) {
				return true;
			}

		}
		return false;
	}

}
