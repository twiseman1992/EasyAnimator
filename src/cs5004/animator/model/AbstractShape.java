package cs5004.animator.model;

/**
 * All shapes extend Abstract shape. By default, all shapes will simply query their patterns for
 * information about their position/size/color/visibility/timing, so those methods are implemented
 * here.
 */
public abstract class AbstractShape implements Shape {

  ColorPattern color; //decided to store all shape attributes inside of a different class to have
  //both flexibility in how they are calculated and stored, and portability between shapes.
  MovementPattern move;
  SizeChangePattern size;
  VisibilityPattern visibility;

  @Override
  public int[] getPosition(int time) {
    return move.getPosition(time);
  }

  @Override
  public int[] getColor(int time) {
    return color.getColor(time);
  }

  @Override
  public int[] getSize(int time) {
    return size.getSize(time);
  }

  @Override
  public boolean getVisibility(int time) {
    return visibility.getVisibility(time);
  }

  @Override
  public abstract Shape copy();

  //need to implement
  @Override
  public int getAppearTime() {
    return 0;
  }

  @Override
  public int getDisappearTime() {return 0;}

  @Override
  public void setColorPattern(ColorPattern color) {
    if (color == null) {
      throw new IllegalArgumentException("Pattern cannot be null.");
    }
    this.color = color;
  }

  @Override
  public ColorPattern getColorPattern() {
    return this.color;
  }

  @Override
  public void setVisibilityPattern(VisibilityPattern visibility) {
    if (visibility == null) {
      throw new IllegalArgumentException("Pattern cannot be null.");
    }
    this.visibility = visibility;
  }

  @Override
  public VisibilityPattern getVisibilityPattern() {
    return this.visibility;
  }

  @Override
  public void setSizeChangePattern(SizeChangePattern size) {
    if (size == null) {
      throw new IllegalArgumentException("Pattern cannot be null.");
    }
    this.size = size;
  }

  @Override
  public SizeChangePattern getSizeChangePattern() {
    return this.size;
  }

  @Override
  public void setMovementPattern(MovementPattern move) {
    if (move == null) {
      throw new IllegalArgumentException("Pattern cannot be null.");
    }
    this.move = move;
  }

  @Override
  public MovementPattern getMovementPattern() {
    return this.move;
  }


}