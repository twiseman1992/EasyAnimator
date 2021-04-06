package cs5004.animator.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test class for the Shape objects. Currently testing Rectangles and Ovals.
 */
public class ShapeTest {
  Shape rec1;
  Shape rec2;
  Oval ov1;
  Shape ov2;

  ColorPattern c1 = new ColorPattern();
  MovementPattern m1 = new MovementPattern();
  SizeChangePattern s1 = new SizeChangePattern();
  VisibilityPattern v1 = new VisibilityPattern();

  ColorPattern c2 = new ColorPattern();
  MovementPattern m2 = new MovementPattern();
  SizeChangePattern s2 = new SizeChangePattern();
  VisibilityPattern v2 = new VisibilityPattern();

  @Before
  public void setUp() {
    rec1 = new Rectangle();
    rec2 = new Rectangle(c1, m1, s1, v1);
    ov1 = new Oval();
    ov2 = new Oval(c1, m1, s1, v1);
    c2.change(50, 75, 230, 230, 230);
    m2.change(50, 75, 50, 100);
    s2.change(50, 75, 30, 100);
    v2.change(50, true);
  }

  @Test
  public void testGetPositionRec() {
    try {
      assertTrue(Arrays.equals(m1.getPosition(-1), rec2.getPosition(-1)));
    } catch (IllegalArgumentException e) {
      //test passes because frame must be positive.
    }
    assertTrue(Arrays.equals(m1.getPosition(0), rec2.getPosition(0)));
    assertTrue(Arrays.equals(m1.getPosition(1), rec2.getPosition(1)));
    assertTrue(Arrays.equals(m1.getPosition(50), rec2.getPosition(50)));
    assertTrue(Arrays.equals(m1.getPosition(100), rec2.getPosition(100)));
  }

  @Test
  public void testGetPositionOv() {
    try {
      assertTrue(Arrays.equals(m1.getPosition(-1), ov2.getPosition(-1)));
    } catch (IllegalArgumentException e) {
      //test passes because frame must be positive.
    }
    assertTrue(Arrays.equals(m1.getPosition(0), ov2.getPosition(0)));
    assertTrue(Arrays.equals(m1.getPosition(1), ov2.getPosition(1)));
    assertTrue(Arrays.equals(m1.getPosition(50), ov2.getPosition(50)));
    assertTrue(Arrays.equals(m1.getPosition(100), ov2.getPosition(100)));
  }

  @Test
  public void getColor() {
    try {
      assertTrue(Arrays.equals(c1.getColor(-1), rec2.getColor(-1)));
    } catch (IllegalArgumentException e) {
      //test passes because frame must be positive.
    }
    assertTrue(Arrays.equals(c1.getColor(0), rec2.getColor(0)));
    assertTrue(Arrays.equals(c1.getColor(1), rec2.getColor(1)));
    assertTrue(Arrays.equals(c1.getColor(50), rec2.getColor(50)));
    assertTrue(Arrays.equals(c1.getColor(100), rec2.getColor(100)));
  }

  @Test
  public void getSize() {
    try {
      assertTrue(Arrays.equals(s1.getSize(-1), rec2.getSize(-1)));
    } catch (IllegalArgumentException e) {
      //test passes because frame must be positive.
    }
    assertTrue(Arrays.equals(s1.getSize(0), rec2.getSize(0)));
    assertTrue(Arrays.equals(s1.getSize(1), rec2.getSize(1)));
    assertTrue(Arrays.equals(s1.getSize(50), rec2.getSize(50)));
    assertTrue(Arrays.equals(s1.getSize(100), rec2.getSize(100)));
  }

  @Test
  public void getVisibility() {
    try {
      assertEquals(false, rec2.getVisibility(-1));
    } catch (IllegalArgumentException e) {
      //test passes because frame must be positive.
    }
    assertEquals(false, rec2.getVisibility(0));
    assertEquals(false, rec2.getVisibility(1));
    assertEquals(false, rec2.getVisibility(50));
    assertEquals(false, rec2.getVisibility(100));
  }

  @Test
  public void testSetGetColorPattern() {
    assertEquals(c1.toString(), rec2.getColorPattern().toString());
    assertNotEquals(c2.toString(), rec2.getColorPattern().toString());
    rec2.setColorPattern(c2);
    assertEquals(c2.toString(), rec2.getColorPattern().toString());
    assertNotEquals(c1.toString(), rec2.getColorPattern().toString());
  }

  @Test
  public void testSetGetMovementPattern() {
    assertEquals(m1.toString(), rec2.getMovementPattern().toString());
    assertNotEquals(m2.toString(), rec2.getMovementPattern().toString());
    rec2.setMovementPattern(m2);
    assertEquals(m2.toString(), rec2.getMovementPattern().toString());
    assertNotEquals(m1.toString(), rec2.getMovementPattern().toString());
  }

  @Test
  public void testSetGetSizePattern() {
    assertEquals(s1.toString(), rec2.getSizeChangePattern().toString());
    assertNotEquals(s2.toString(), rec2.getSizeChangePattern().toString());
    rec2.setSizeChangePattern(s2);
    assertEquals(s2.toString(), rec2.getSizeChangePattern().toString());
    assertNotEquals(s1.toString(), rec2.getSizeChangePattern().toString());
  }

  @Test
  public void testSetGetVisibilityPattern() {
    assertEquals(v1.toString(), rec2.getVisibilityPattern().toString());
    assertNotEquals(v2.toString(), rec2.getVisibilityPattern().toString());
    rec2.setVisibilityPattern(v2);
    assertEquals(v2.toString(), rec2.getVisibilityPattern().toString());
    assertNotEquals(v1.toString(), rec2.getVisibilityPattern().toString());
  }


  @Test
  public void testCopy() {
    Shape copyRec = rec2.copy();
    assertEquals(copyRec.getColorPattern(), rec2.getColorPattern());
    assertEquals(copyRec.getSizeChangePattern(), rec2.getSizeChangePattern());
    assertEquals(copyRec.getMovementPattern(), rec2.getMovementPattern());
    assertEquals(copyRec.getVisibilityPattern(), rec2.getVisibilityPattern());
  }
}