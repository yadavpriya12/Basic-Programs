import java.util.Scanner;

public class _65Decreasing_Increasing {
    
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number a=");
        a =sc.nextInt();
        System.out.println("Enter a number b=");
        b=sc.nextInt();
        System.out.println("Enter a number c=");
        c=sc.nextInt();

        if(a<b && b<c ){
        System.out.println("It is a increasing order");
          }

          else if (a>b && b>c ){
            
            System.out.println("It is a decreasing order");
          }
          else{
            System.out.println("Invalid case");
          }
          sc.close();
    }
   
}
