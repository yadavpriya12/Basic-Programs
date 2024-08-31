class _Dog 
{
    String color = "white";

    
}


 class Puppy extends _Dog
  {
    String color = " black";  

    public void showdata()
{
    System.out.println(color);
    System.out.println(super.color);
}
}



  
 class Driver12
{
    public static void main(String[] args) {
       Puppy p = new Puppy();
         p.showdata();

        

    }
    
}
