import java.util.Scanner;
public class _52ReverseNumberMethod {
    public static void reverse(int n){
         int b;
         int rev=0;
while(n!=0){
    b=n%10;
    rev=rev*10+b;
    n=n/10;
    
}
System.out.println(rev);

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a any value:");
        int a = sc.nextInt();
        reverse(a);
        sc.close();
    }
    
}
