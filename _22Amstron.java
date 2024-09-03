import java.util.Scanner;

public class _22Amstron{
    public static void main(String[]args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter any digit");
       int num=sc.nextInt();

       int rem;
       int rev=0;
       while(num>0) 
       {
    
            rem=num%10;
           rev=rev+rem*rem*rem;
           num=num/10;     

       }
       System.out.println(rev);
    }
}