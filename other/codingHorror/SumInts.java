import java.util.Scanner;
import java.io.File;

class SumInts {
  
  public static int sumIntsFile(String fileName) {
    int sum = 0;
    try {
      File file = new File(fileName);
      Scanner scan = new Scanner(file);
      while (scan.hasNextLine()) {
        sum += Integer.parseInt(scan.nextLine());
      }  
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(sumIntsFile("sumInts.txt"));
  }
}
