package data2;

public class _FabonaciSeries {
    public static void main(String[] args) {
        int a=-1;
        int b=1;
    for(int i=0;i<=10;i++)
    {
      int c=a+b;
         System.out.println(c);
         a=b;
         b=c;
    }
    }
}
