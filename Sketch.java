import processing.core.PApplet;

/**
 * Description: A program that uses a 2D array to create an interactive grid 
 * @author: L. Pei
 */

public class Sketch extends PApplet {

  // global variables
  int intCellWidth = 20;
  int intCellHeight = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intScreenWidth = intCellWidth * intColumnCount + (intMargin * (intColumnCount + 1));
  int intScreenHeight = intCellHeight * intRowCount + (intMargin * (intRowCount + 1));
  int intTotalGreen = 0;
  int intRowGreen = 0;
  int intColumnGreen = 0;
  int intConsecutive = 2;

  // create an empty 2D array 
  int intGrid [][] = new int[10][10];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(intScreenWidth, intScreenHeight);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++) {
        if (intGrid[row][column] == 1) {
          fill(0, 255, 0);
          rect(column * (intCellWidth + intMargin) + intMargin, row * (intCellHeight + intMargin) + intMargin, intCellWidth, intCellHeight);
        }
        else if (intGrid[row][column] == 0) {
          fill(255);
          rect(column * (intCellWidth + intMargin) + intMargin, row * (intCellHeight + intMargin) + intMargin, intCellWidth, intCellHeight);
        }
      }
    }
  }

  /**
   * This section changes the values of intGrid to ise in the draw program, and also outputs 
   */
  public void mousePressed() {
    System.out.println("Click");
    // changes the values of the the intGrid based on what cell the mouse is clicked on and its immediate surrounding cells
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++) {
        if (mouseX > column * (intCellWidth + intMargin) + intMargin && mouseX < column * (intCellWidth + intMargin) + intMargin + intCellWidth && mouseY > row * (intCellHeight + intMargin) + intMargin && mouseY < row * (intCellWidth + intMargin) + intCellHeight + intMargin) {
          System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + "); grid coordinates: (row: " + (row + 1) + ", column: " + (column + 1) + ")");
          // changes values for the cell that got clicked 
          if (intGrid[row][column] == 0) {
            intGrid[row][column] = 1;
          }
          else if (intGrid[row][column] == 1) {
            intGrid[row][column] = 0;
          }
          // top left corner code
          if (row == 0 && column == 0) {
            // changes values for the cell 1 right
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
          }
          // bottom right corner code
          else if (row == 9 && column == 9) {
          // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row - 1][column] = 0;
            }
          // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) {
              intGrid[row][column - 1] = 0;
            }
          }
          // bottom left corner code
          else if (row == 9 && column == 0) {
            // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row - 1][column] = 0;
            }
            // changes values for the cell 1 left
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
          }
          // top left corner code
          else if (row == 0 && column == 9) {
            // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) {
              intGrid[row][column - 1] = 0;
            }
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
          }
          // left edge code
          else if (row > 0 && row < 9 && column == 0) {
            // changes values for the cell 1 right
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
            // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row - 1][column] = 0;
            }
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
          }
          // right edge code
          else if (row > 0 && row < 9 && column == 9) {
            // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) {
              intGrid[row][column - 1] = 0;
            }
            // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row - 1][column] = 0;
            }
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
          }
          // top edge code
          else if (row == 0 && column > 0 && column < 9) {
            // changes values for the cell 1 right
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
            // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) {
              intGrid[row][column - 1] = 0;
            }
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
          }
          else if (row == 9 && column > 0 && column < 9) {
            // changes values for the cell 1 right
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
            // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) { 
              intGrid[row][column - 1] = 0;
            }
            // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row -1][column] = 0;
            }
          }
          else {
            // changes values for the cell 1 down
            if (intGrid[row + 1][column] == 0) {
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1) {
              intGrid[row + 1][column] = 0;
            }
            // changes values for the cell 1 up
            if (intGrid[row - 1][column] == 0) {
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1) {
              intGrid[row - 1][column] = 0;
            }
            // changes values for the cell 1 right
            if (intGrid[row][column + 1] == 0) {
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1) {
              intGrid[row][column + 1] = 0;
            }
            // changes values for the cell 1 left
            if (intGrid[row][column - 1] == 0) {
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1) {
              intGrid[row][column - 1] = 0;
            }
          }
        }
      }
    } 

    // counts total number of green cells 
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++) {
        if (intGrid[row][column] == 1) {
          intTotalGreen++;
        }
      }
    }
    // outputs number of green cells counted in the loop
    System.out.println("Total of " + intTotalGreen + " cells are selected.");
    intTotalGreen = 0; // resets variable

    // counts total number of green cells, and tracks if there are 2 or more consequetive green cells per row
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++) {
        if (intGrid[row][column] == 1) {
          intRowGreen++;
          // if there are 3 consecutive green cells in a row, add one for every extra cell in the row
          if (column >= 2 && intGrid[row][column - 1] == 1 && intGrid[row][column - 2] == 1) {
            intConsecutive++;
            // output the variable and move to next row if at column 10
            // if there are no more continuous green cells but still more squares in the row, go back up the loop and continue searching down the row 
            if (column == 9 || intGrid[row][column + 1] == 0) {
              System.out.println("There are " + intConsecutive + " continuous blocks selected on row " + row + ".");
              intConsecutive = 2; // resets variable
            }
          }
        }
      }
      // output the amount of green cells per row
      System.out.println("Row " + row + " has " + intRowGreen + " cells selected.");
      intRowGreen = 0; // resets variable
    }

    // counts the amount of green cells in each column
    for (int column = 0; column < intColumnCount; column++) {
      for (int row = 0; row < intRowCount; row++) {
        if (intGrid[row][column] == 1) {
          intColumnGreen++;
        }
      }
      // outputs the amount of green cells per column
      System.out.println("Column " + column  + " has " + intColumnGreen + " cells selected.");
      intColumnGreen = 0; // resets variable
    }

    // prints a line of space between output for readability 
    System.out.println(" ");
  }
}