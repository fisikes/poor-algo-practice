package fisikes.solutions.numbers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainsDigitTest {

  @Test
  void containsDigit() {

    assertTrue(ContainsDigit.containsDigit(1451111, 5));
    assertFalse(ContainsDigit.containsDigit(100, 5));
  }
}