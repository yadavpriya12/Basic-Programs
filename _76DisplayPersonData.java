import java.util.Scanner;

class Person1{
String name;
int age;

public void displayinfo(){
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter your name:");
  String name=sc.nextLine();
  System.out.println("Enter your age:");
  int age=sc.nextInt();
    System.out.println("My name is"+ " "+name);
    System.out.println("My age is "+ " "+age);

}
}
class Driver8{
    public static void main(String[] args) {
     
      Person1 a=new Person1();
     a.displayinfo();
    }
}
