
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

        public void showdata() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'showdata'");
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
    
          }
    } 

