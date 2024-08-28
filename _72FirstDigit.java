import java.util.Scanner;

 class _72FirstDigit {
public static int firstnumber(int num,int rem){
   while(num!=0)
   {
  rem= num%10;
  num=num/10;
      
   }
   System.out.println(rem);
   return 0;
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a digit");
        int num=sc.nextInt();
        int rem=0;
        firstnumber(num,rem);
        sc.close();
    }
}
