 class Demo {

    String name;
    int age;

    public void showdata(){
        System.out.println("My name is="+name);
        System.out.println(" My Age is="+age);
        System.out.println(age+10);
    }
}

class Driver1 {
    public static void main(String[] args) {
     Demo obj = new Demo();
     obj.name="java";
     obj.age =23;
     obj.showdata();
        //  System.out.println((obj.name ="java"));
         
    }
}
