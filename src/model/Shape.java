package model;
/**
 *Shape is an object that can be displayed on a canvas.
 */
public interface Shape {
  //Rectangle Constructor: 
  //public Shape rectangle(int length, int width, int x, int y, int[3] color, boolean isVisible)

  /**
   * Returns the x and y coordinates of the shape at the specified time.
   * @param time Integer of the time you wish to know the position of the shape.
   * @return Int[2] x and y coordinates of the shape.
   */
  int[] getPosition(int time);

  /**
   * Returns the RGB value  of the shape at the specified time.
   * @param time Integer of the time you wish to know the color of the shape.
   * @return Int[3] RGB values  of the shape.
   */
  int[] getColor(int time);

  /**
   * Returns the length and with of the shape at the specified time.
   * @param time Integer of the time you wish to know the length and with of the shape.
   * @return Int[2] length and width values of the shape.
   */
  int[] getSize(int time);

  /**
   * Returns the visibility of the shape at the current time.
   * @param time Integer of the time you wish to know the visibility of the shape.
   * @return True if the shape is visible at the provided time, false otherwise.
   */
  boolean getVisibility(int time);

  /**
   * Mutates the shapes internal attributes to match the correct state given the provided time.
   * @param time Integer of the time you wish to change the state of the shape to.
   */
  void update(int time);

  /**
   * Returns the time that the shape will become visible.
   * @return Integer of the time the shape will become visible.
   */
  int getAppearTime();

  /**
   * Returns the time that the shape will become invisible.
   * @return Integer of the time the shape will become invisible.
   */
  int getDisappearTime();

  /**
   * Changes the default MasterPattern of the shape to the provided one.
   * @param master Pattern
   */
  void setMasterPattern(MasterPattern master);

  /**
   * Returns a copy of the MasterPattern that the shape is currently using.
   * @return MasterPattern object that is a copy of the one the shape is using.
   */
  MasterPattern getMasterPatternCopy();

  /**
   * Returns a copy of the current Shape object.
   * @return Shape that is a copy of the current shape object.
   */
  Shape copy();
}
  