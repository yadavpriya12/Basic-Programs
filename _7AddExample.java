import java.util.Scanner;

public class _7AddExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();

        int sum=0;
        int rem=0;
        while(num!=0){

            rem=num%10;
           sum=sum+rem;
           num=num/10;

        }
        System.out.println(sum);
        sc.close();
    }
}
