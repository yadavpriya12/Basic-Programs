import java.util.Scanner;

public class _8Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number a=");
        int a= sc.nextInt();

        System.out.println("Enter a number b=");
        int b= sc.nextInt();

        System.out.println("******select a any operator*****");
        System.out.println("1 == +");
        System.out.println("2 == -");
        System.out.println("3 == *");
        System.out.println("4 == %");
        System.out.println("5 == /");

        int select= sc.nextInt();
         if(select==1){
            System.out.println("Addition=" +(a+b));
         }

         else if(select==2){
            System.out.println("Substraction="+(a-b));
         }

         else if(select==3){
            System.out.println("Multiplication="+(a*b));
         }

         else if(select==4){
            System.out.println("Modulus="+(a%b));
         }
         else if(select==5){
            System.out.println("division="+(a/b));
         }
         else {
            System.out.println("invalid choice");
         }
         sc.close();
    }
    
}
