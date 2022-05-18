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
        else{
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
        if (mouseX > column * (intCellWidth + intMargin) + intMargin && mouseX < column * (intCellWidth + intMargin) + intMargin + 20 && mouseY > row * (intCellHeight + intMargin) + intMargin && mouseY < row * (intCellWidth + intMargin) + intCellWidth + intMargin) {
          System.out.println("x: " + (column + 1) + ", y: " + (row + 1));
           
        }
      }
    } 
  }
}
