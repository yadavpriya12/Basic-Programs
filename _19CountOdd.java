import java.util.Scanner;

public class _19CountOdd {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any didgit:");
        int num=sc.nextInt();
        int count=0;

        while(num>0){

            int rev=num%10;
            if(num%2!=0){
                count++;
            }
            num=num/10;
        }
        System.out.println(count);

    }
}
