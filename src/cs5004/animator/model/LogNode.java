package cs5004.animator.model;

import java.util.Arrays;
import java.util.Objects;

public class LogNode implements Comparable<LogNode> {
  private final int frame1;
  private final int frame2;
  private String changeNotes;
  private PatternType type;
  private Integer[] startValues;
  private Integer[] endValues;

  public LogNode(PatternType type, Integer frame1, Integer frame2,
      Integer[] startValues, Integer[] endValues) {
    this.frame1 = frame1;
    this.frame2 = frame2;
    this.type = type;
    this.startValues = startValues;
    this.endValues = endValues;

    if (type == PatternType.SIZECHANGE) {
      this.changeNotes = "changes dimensions from width " + startValues[0] + " by height "
          + startValues[1] + " to width " + endValues[0] + " by height " + endValues[1]
          + ", from time t=" + frame1 + " to t=" + frame2;
    } else if (type == PatternType.MOVEMENT) {
      this.changeNotes = "moves position from (" + startValues[0] + ", " + startValues[1]
          + ") to (" + endValues[0] + ", " + endValues[1] + "), from time t=" + frame1 + " to t="
          + frame2;
    } else if (type == PatternType.COLOR) {
      this.changeNotes = "changes color from RGB" + Arrays.toString(startValues) + " to RGB"
          + Arrays.toString(endValues) + ", from time t=" + frame1 + " to t=" + frame2;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogNode logNode = (LogNode) o;
    return getFrame1() == logNode.getFrame1() && getFrame2() == logNode.getFrame2()
        && getChangeNotes().equals(logNode.getChangeNotes()) && getType() == logNode.getType()
        && Arrays.equals(getStartValues(), logNode.getStartValues()) && Arrays
        .equals(getEndValues(), logNode.getEndValues());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getFrame1(), getFrame2(), getChangeNotes(), getType());
    result = 31 * result + Arrays.hashCode(getStartValues());
    result = 31 * result + Arrays.hashCode(getEndValues());
    return result;
  }


  public int getFrame1() {
    return this.frame1;
  }

  public int getFrame2() {
    return this.frame2;
  }

  public String getChangeNotes() {
    return this.changeNotes;
  }

  public PatternType getType() {
    return this.type;
  }

  public int[] getStartValues() {
    int[] updatedFrame = new int[startValues.length];
        for (int i = 0; i < startValues.length; i++) {
          updatedFrame[i] = startValues[i];
        }
        return updatedFrame;
    }

  public int[] getEndValues() {
    int[] updatedFrame = new int[endValues.length];
    for (int i = 0; i < endValues.length; i++) {
      updatedFrame[i] = endValues[i];
    }
    return updatedFrame;
  }

  @Override
  public int compareTo(LogNode o) {
    return this.frame1 - o.getFrame1();
  }
}
