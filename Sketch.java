import processing.core.PApplet;

public class Sketch extends PApplet {

  // global variables
  int intCellWidth = 20;
  int intCellHeight = 20;
  int intMargin = 5;
  int intRowCount = 10;
  int intColumnCount = 10;
  int intScreenWidth = intCellWidth * intColumnCount + (intMargin * (intColumnCount + 1));
  int intScreenHeight = intCellHeight * intRowCount + (intMargin * (intRowCount + 1));
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
        if (intGrid[row][column] == 1){
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
   * This section is responsible for determing what column and row the is clicked, then assigning those values to a 2D array used in the draw method
   */
  public void mousePressed() {
    System.out.println("click");
    System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + ")");
    for (int row = 0; row < intRowCount; row++) {
      for (int column = 0; column < intColumnCount; column++){
        if (mouseX > column * (intCellWidth + intMargin) + intMargin && mouseX < column * (intCellWidth + intMargin) + intMargin + intCellWidth && mouseY > row * (intCellHeight + intMargin) + intMargin && mouseY < row * (intCellWidth + intMargin) + intCellWidth + intMargin) {
          System.out.println("x: " + (column + 1) + ", y: " + (row + 1));
          // top left corner code
          if (row == 0 && column == 0) {
            // changes values for top left corner
            if (intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 right
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
          }
          // bottom right corner code
          else if (row == 9 && column == 9) {
            // changes values for bottom right corner
            if (intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
          // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
          // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
          }
          // bottom left corner code
          else if (row == 9 && column == 0){
            // changes values for bottom left corner
            if (intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
          }
          // top left corner code
          else if (row == 0 && column == 9) {
            // changes values for the top right 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
          }
          // left edge code
          else if (row > 0 && row < 9 && column == 0) {
            // changes values for the box clicked 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 right
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
          }
          // right edge code
          else if (row > 0 && row < 9 && column == 9){
            // changes values for the box clicked 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
          }
          // top edge code
          else if (row == 0 && column > 0 && column < 9) {
            // changes values for the box clicked 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 right
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
          }
          else if (row == 9 && column > 0 && column < 9) {
            // changes values for the box clicked 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 right
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row -1][column] = 0;
            }
          }
          else {
            // changes values for the box clicked 
            if (intGrid[row][column] == 0) {
              intGrid[row][column] = 1;
            }
            else if (intGrid[row][column] == 1) {
              intGrid[row][column] = 0;
            }
            // changes values for the box 1 down
            if (intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            else if (intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            // changes values for the box 1 up
            if (intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            else if (intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            // changes values for the box 1 right
            if (intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
            else if (intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            // changes values for the box 1 left
            if (intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            else if (intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
          }
        }
      }
    } 
  }
}
