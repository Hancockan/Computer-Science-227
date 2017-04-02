package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.Cell;
import api.Flow;

/**
 * Utility class with methods for creating Flows from string descriptors and
 * reading string descriptors from a file. A string descriptor is an array of
 * strings, all with the same length, in which an alphabetic character at a
 * given row and column represents a cell at that row and column. The color of
 * the cell is determined from the character by the Cell constructor. A
 * descriptor is invalid if not all strings are the same length or if there is
 * an alphabetic character that does not appear exactly twice.
 * @author Andrew Hancock
 */
public class Util {
	/**
	 * Creates an array of Flow objects based on the string descriptor. If the
	 * descriptor is invalid, this method returns null.
	 * 
	 * @param descriptor
	 *            array of strings
	 * @return array of Flow objects determined by the descriptor
	 */
	public static Flow[] createFlowsFromStringArray(String[] descriptor) {
		// a cell arraylist for all endpoints
		ArrayList<Cell> endPts = new ArrayList<Cell>();

		// loop that will go through all string in the string array
		for (int i = 0; i < descriptor.length; i++) {

			String currentLine = descriptor[i];

			// now I need a for loop that will go through each character in the
			// line
			for (int b = 0; b < currentLine.length(); b++) {
				// a character that will let me indvidually look at each
				// character in the line
				char w = currentLine.charAt(b);
				char ref = '-';

				if (w != ref) {
					// if it isn't a - then I will create a new cell with the
					// correct color and add it to the cell list
					Cell endpt = new Cell(i, b, w);
					endPts.add(endpt);
				}

			}

		}

		// at this point I will have all endpoints in the arraylist endpts
		// I can assume that the amount of endpoints/2 will equal the amount of
		// flows
		int numOfFlows = endPts.size() / 2;
		// return null if there isn't an even number of endpoints. means invalid
		// descriptor.
		if ((numOfFlows * 2) != endPts.size()) {
			return null;
		}

		// the flow array that will be returned.
		Flow[] flows = new Flow[numOfFlows];

		/*
		 * In order to go through the list and generate a flow my idea is to
		 * grab the first endpoint that is in the list and then go through the
		 * rest of the list looking for the endpoint that has the same color.
		 * With those two endpoint I will generate a flow and add it to the list
		 */

		// this loop will go through the list once for each flow
		for (int w = 0; w < numOfFlows; w++) {
			// grab first endpoint
			Cell endpoint1 = endPts.get(0);
			// remove it from the list
			endPts.remove(0);

			// second endpoint
			Cell endpoint2;
			// flow that'll be added
			Flow newFlow;

			// loop to go through and look for the second endpoint with the same
			// color
			for (int l = 0; l < endPts.size(); l++) {
				if (endPts.get(l).getColor().equals(endpoint1.getColor())) {
					endpoint2 = endPts.get(l);
					endPts.remove(l);
					newFlow = new Flow(endpoint1, endpoint2);
					flows[w] = newFlow;
					break;
				}
				
			}

		}

		return flows;
	}

	/**
	 * Reads the given file and constructs a list of FlowGame objects, one for
	 * each descriptor in the file. Descriptors in the file are separated by
	 * some amount of whitespace, but the file need not end with whitespace and
	 * may have extra whitespace at the beginning. Invalid descriptors in the
	 * file are ignored, so the method may return an empty list.
	 * 
	 * @param filename
	 *            name of the file to read
	 * @return list of FlowGame objects created from the valid descriptors in
	 *         the file
	 * @throws FileNotFoundException
	 */
	public static ArrayList<FlowGame> readFile(String filename) throws FileNotFoundException {
		File file = new File(filename);

		// a scanner to read the file
		Scanner reader = new Scanner(file);

		// flowgame arraylist
		ArrayList<FlowGame> flowgames = new ArrayList<FlowGame>();

		// int to keep track of if the line is part of the last string array or
		// a new one
		int streak = 0;

		// an arraylist of all the descriptors
		ArrayList<String[]> descriptors = new ArrayList<String[]>();

		// arraylist of strings to eventually turn into an array and add to
		// descriptor arraylist
		ArrayList<String> lines = new ArrayList<String>();

		// a while loop to read the lines of the file
		while (reader.hasNextLine()) {
			String line = reader.nextLine();

			// get rid of whitespace so I can get actual length
			line.trim();

			if (line.isEmpty()) {

				// add a descriptor if there was one
				descriptors.add(lines.toArray(new String[streak]));

				lines.clear();
				streak = 0;
				continue;
			}

			// add the line to the arraylist of lines for this descriptor
			lines.add(line);

			streak++;

		}

		if (lines.size() > 0) {
			descriptors.add(lines.toArray(new String[streak]));
		}

		reader.close();

		// a for loop to go through all the descriptors and add them to an
		// arraylist of flowgames
		for (int i = 0; i < descriptors.size(); i++) {
			Flow[] flows = createFlowsFromStringArray(descriptors.get(i));
			// a new flowgame with the flows, width, and height
			FlowGame flowgame = new FlowGame(flows, descriptors.get(i)[0].length(), descriptors.get(i).length);
			// add the new flowgame to the arraylist of flowgames.
			flowgames.add(flowgame);
		}

		return flowgames;
	}

}
