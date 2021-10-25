package statisticker;

import java.util.Collections;
import java.util.List;

public class StatsChecker {

  float maxThreshold;
  IAlerter[] alerters;

  public StatsChecker(final float maxThreshold, final IAlerter[] alerters) {
    this.maxThreshold = maxThreshold;
    this.alerters = alerters;
  }

  public void checkAndAlert(final List<Float> numberList) {
    Float max = Collections.max(numberList);
    if (max > this.maxThreshold) {
      for (IAlerter alerter : this.alerters) {
        alerter.alert();
      }
    }
  }

}
