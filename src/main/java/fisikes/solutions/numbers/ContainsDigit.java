package fisikes.solutions.numbers;

public class ContainsDigit {


  public static boolean containsDigit(int number, int digit) {

    while (number != 0) {
      final int remainder = number % 10;
      if (remainder == digit) {
        return true;
      }
      number /= 10;
    }

    return false;
  }

}
