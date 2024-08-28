import java.util.Scanner;

public class _74FactorialNumber {
    
    public static void main(String[] args) {
Scanner sc =new Scanner(System.in);
System.out.println("enter any digit");
int num=sc.nextInt();

      while(num%3==0)
       {
  System.out.print("3*");
    num=num/3;
      }
      
      System.out.println(num);
    } 
}
    