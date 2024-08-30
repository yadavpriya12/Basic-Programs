import java.util.Scanner;

class Employee  extends Person1{

    int empid;
    int empsalary;
    public void display1(){
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter Employee id:");
   int empid =sc.nextInt();
   System.out.println("Enter employee Salary:");
   int empsalary=sc.nextInt();

   System.out.println("Employee id is:"+empid);
   System.out.println("Employee salary is:"+empsalary);

    }
}

class Driver8{
public static void main(String[] args) {

     Employee e=new Employee();
     e.display1();
   e.displayinfo();
}
}
