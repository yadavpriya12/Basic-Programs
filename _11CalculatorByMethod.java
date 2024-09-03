import java.util.Scanner;

public class _11CalculatorByMethod {
    
 public static  void addition(int a,int b)
 {
 System.out.println("Addition="+(a+b));
}

public static void substraction(int a,int b){
System.out.println("Substraction="+(a-b));
}

public static void multiplication(int a,int b){
System.out.println("Multiplication="+(a*b));
}

public static void modulus(int a,int b){
 System.out.println("Modulus="+(a%b));
}

public static void division(int a,int b){
System.out.println("Division="+(a/b));

}
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a  first number a=");
        int a= sc.nextInt();
        System.out.println("Enter a  second number b=");
        int  b= sc.nextInt();

        addition(a,b);
        substraction(a,b);
        multiplication(a,b);
        modulus(a,b);
        division(a,b);

        sc.close();

    }
    
}