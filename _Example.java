 class Animal89 {
    public void showdata6()
    {
System.out.println(" hello");
    }
}

class Dog55 extends Animal89{
 public void showdata6()
 {
System.out.println("hii");
    //showdata6();
    super.showdata6();
}
}

class Demo1000
{
    public static void main(String[] args) {
    Dog55 obj1 = new Dog55();
    obj1.showdata6();
    }
}

