import java.util.Scanner;

 class _70Consecutive {

    public  static int consecutive(int a,int b,int c){

        if(b-a==1 && c-b==1){

            System.out.println("true");
        }
        else{ 
            System.out.println("false");
        }
        return 0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number a=");
        int a=sc.nextInt();
        System.out.println("Enter second number b=");
        int b=sc.nextInt();
        System.out.println("Enter a third number c=");
        int c=sc.nextInt();

        consecutive(a, b, c);
        sc.close(); 
    }
}
