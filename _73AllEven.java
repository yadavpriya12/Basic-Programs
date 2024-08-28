import java.util.Scanner;

 class _73AllEven {
    

    public static int check(int num,int rem)
    {
    while(num>0)
    {
        rem=num%10;
        if(rem%2==1)
        {
            System.out.println("false");
            return 0;
        }
        num=num/10;

    }
      System.out.println("true");   
      return 0;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number ");
          int num=sc.nextInt();
         int rem=0;
          check(num,rem);
          sc.close();
    }
}
