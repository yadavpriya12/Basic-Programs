import java.util.Scanner;

class Person {
    
    String name;
    int age;

 public void set(String n,int a){
        name=n;
         age=a;
    
System.out.println("My name is"+" "+name);
System.out.println("My age is"+" "+age);
    }
}

class Driver5
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=sc.nextLine();     
        System.out.println("Enter your age:");
        int a=sc.nextInt();
        Person p=new Person();
        p.set(name, a);
    sc.close();

    }

}