import java.util.Scanner;

public class _18Pallindrome {
    
    public static void pallindrome(int num)
    {
       int rem;
       int rev =0;
       int p=num;

       while(num>0){
        rem=num%10;
       rev=rev*10+rem;
       num=num/10;
       }
       System.out.println(rev);
       
       if(p==rev){
        System.out.println("it is pallindrome:"+p);
       }
       else{
        System.out.println("it is not pallindrome:"+p);
       }
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any digit");
        int num = sc.nextInt();
        pallindrome(num);
}
}
