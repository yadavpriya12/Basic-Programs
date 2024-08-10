import java.util.Scanner;

public class _12EvenOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        System.out.println("Enter any number");
        int i = sc.nextInt();
        even(i);
        sc.close();

    }
    
    public static void even(int i)
    {
        if(i%2==0){
        System.out.println("It is a even number");
        }
        else{
            System.out.println("it is odd number");
        }
    }

}
