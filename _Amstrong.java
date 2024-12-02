package data2;

import java.util.Scanner;

public class _Amstrong {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter any digit");
       int num =sc.nextInt();
       int rem;
       int sum=0;
       int s=num;
       while(num!=0)
       {
        rem=num%10;
        sum= sum+(rem*rem*rem);
        num=num/10;
       }
       if(s==sum)
       {
        System.out.println("it is armstrong"+s);
       }
       else
       {
        System.out.println("it is not armstrong"+s);
       }
    }
}
