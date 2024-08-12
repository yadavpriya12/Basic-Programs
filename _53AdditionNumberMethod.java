import java.util.Scanner;
public class _53AdditionNumberMethod {
    
    public static void addition(int num){
      int r;
      int sum=0;  
      while(num!=0){
          r= num%10;
           sum=sum+ r;
          num=num/10;

      }
      System.out.println(sum);
 
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a=sc.nextInt();
       addition(a);
       sc.close();
         }
}
