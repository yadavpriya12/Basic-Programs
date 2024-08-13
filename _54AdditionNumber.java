import java.util.Scanner;
public class _54AdditionNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number:");
        int a= sc.nextInt();
           int rem;
           int sum=0;
           while(a!=0){
            rem=a%10;
            sum=sum+rem;
            a=a/10;
           }
           System.out.println(sum);
            sc.close();

    }
}
