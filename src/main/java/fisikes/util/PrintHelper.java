package fisikes.util;

public class PrintHelper {


  public static void print(Object object) {

    System.out.println(JacksonUtil.toJson(object));
  }
}
