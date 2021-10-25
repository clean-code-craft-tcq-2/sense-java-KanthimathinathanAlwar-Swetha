package statisticker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class StatisticsTest 
{
   
  @Test
  public void reportsAverageMinMaxx() {
    Float[] numbers = { 1.5f, 8.9f, 3.2f, 4.5f };
    List<Float> numberList = Arrays.asList(numbers);

    Statistics.Stats s = Statistics.getStatistics(numberList);

    float epsilon = 0.001f;
    assertEquals(s.average, 4.525f, epsilon);
    assertEquals(s.min, 1.5f, epsilon);
    assertEquals(s.max, 8.9f, epsilon);
  }

  @Test
  public void reportsAverageMinMaxxForNaNValues() {
    Float[] numbers = { Float.NaN, 1.5f, 3.2f, Float.NaN };
    List<Float> numberList = Arrays.asList(numbers);

    Statistics.Stats s = Statistics.getStatistics(numberList);

    float epsilon = 0.001f;
    assertEquals(s.average, Float.NaN, epsilon);
    assertEquals(s.min, 1.5f, epsilon);
    assertEquals(s.max, Float.NaN, epsilon);
  }

  @Test
  public void reportsNaNForEmptyInput() {
    List<Float> emptyList = new ArrayList<Float>();

    Statistics.Stats s = Statistics.getStatistics(emptyList);

    assertTrue(s.min.isNaN());
    assertTrue(s.max.isNaN());
    assertTrue(s.average.isNaN());
    assertEquals(s.min, Float.NaN, 0.0);
    assertEquals(s.max, Float.NaN, 0.0);
    assertEquals(s.average, Float.NaN, 0.0);
  }

}
