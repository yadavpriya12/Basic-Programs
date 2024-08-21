class Dog2  {
    String breed;
    
 Dog2(String br){
    breed = br;
 }
 
 void display()
 {
System.out.println("This dog is="+breed);
 }
 }

 class Driver4{
    public static void main(String[] args) {
        Dog2 s= new Dog2("Labrador");
       s.display();
    

    }
 }

