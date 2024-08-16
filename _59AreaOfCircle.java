import java.util.Scanner;

public class _59AreaOfCircle {


   public static void CalculateArea(float radius){
      
     float Area=  3.14f*radius*radius;
     float perimeter  =2f*3.14f*radius;

     System.out.println("Area of circle="+Area);
     System.out.println("Perimeter of Circle="+perimeter);
     }

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a radius:");
        float r=sc.nextFloat();
        CalculateArea(r);
            sc.close();
    }
}
