package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _ExHandling {
    public static void main(String[] args)
     {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a first number ");
        
        int a= sc.nextInt();

        System.out.println("Enter a second number");
        int b = sc.nextInt();

        int c = a/b;
        System.out.println("result:"+c);
        }

        catch(ArithmeticException e)
        {
           System.out.println("denominator can't be zero");
        }

        catch(InputMismatchException e)
        {
            System.out.println("please enter only integer value");
        }
        
        System.out.println("end....");
        
    }
}
