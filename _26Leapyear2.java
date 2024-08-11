

import java.util.Scanner;
public class _26Leapyear2 {
   
    public static void Leapyear(int y){

      if(y%4 ==0){
        System.out.println("It is a leap year");
       }
       else{
        System.out.println("it is not leap year");
 
       }
      }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a year: ");
       int y = sc.nextInt();
         Leapyear(y);  
         sc.close(); 
 
} 
}