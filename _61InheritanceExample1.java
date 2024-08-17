public class _61InheritanceExample1

{
    public static void main(String[] args)
      {
        Square sq= new Square();
           sq.showdata();
           sq.shownewdata();
    }
}

       class Shapes {
      double side=10;
      
     public void showdata() {

    System.out.println("inside shapes");
  }
}

     class Square extends Shapes {
  
        public void shownewdata()

  {
         System.out.println("inside square");
  }

    }


