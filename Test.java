package string.printntimes;
import java.util.Scanner;
class Test{
  public static void main(String [] abc){
    Scanner s= new Scanner(System.in);
    String A= s.nextLine();
    new PrintNTimes().check(A);
  }
}