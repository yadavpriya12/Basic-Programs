import java.util.Scanner;

public class _56Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter a number:");   
          int num=sc.nextInt();
          int rem;
          int  sum=0;
          int s=num;
          while(num!=0){

            rem=num%10;
            sum=sum*10+rem;
            num=num/10;
          }
          System.out.println(sum);
if(s==sum){
    System.out.println("it is palindrome=" + "  " +s);

}
else{
    System.out.println("it is not pallindrome="+ " "+s);
    sc.close();

}
}
}
