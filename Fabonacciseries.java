package String;

import java.util.Scanner;

public class Fabonacciseries {
  public static boolean checkMember(int n){
        int num1 = 0;
        int num2 = 1;
        while(num1 <= n) {
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            if(num1 == n) {
                return true;
            }
        }
                return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number:");
        int n = sc.nextInt();
        boolean ans = checkMember(n);
        System.out.println(ans);
            sc.close();	
    }
}
