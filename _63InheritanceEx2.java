 class Animal {
    
    public void eat(){
        System.out.println("eat");
    }

     public void sleep(){
        System.out.println("sleep");
     }
}

class Cat extends Animal{

    public void meow(){
        System.out.println(" meow meow");
    }  
}

class Dog extends Animal{
    public void bark()
    {
System.out.println(" bark bark");
    }
}

class Kitten extends Cat{
    public void cry(){
        System.out.println("kitten is crying");
    }
}


class BabyDog extends Dog{
    public void weep(){
        System.out.println("Babydog is weeping");
    }
}
class Driver
{
public static void main(String[] args) {
    Cat c= new Cat();
    c.eat();
    c.sleep();
    c.meow();

    Dog d= new Dog();
     d.eat();
     d.sleep();  
     d.bark();

     Kitten k =new Kitten();
     k.eat();
     k.sleep();
     k.meow();
     k.cry();

     BabyDog b= new BabyDog();
     b.eat();
     b.sleep();
     b.bark();
     b.weep();
}
}