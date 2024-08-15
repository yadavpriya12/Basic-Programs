import java.util.Scanner;

public class _58OddMid {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("ENter a number:");
       int num=sc.nextInt();
        int count=0;

       while (num>0) {
      int rev=num%10;
        
        if(num%2!=0){
           count++;
       }
       num =num/10;
      
    }
   
    System.out.println("Count odd number: "+count);
  sc.close();
    }
}
