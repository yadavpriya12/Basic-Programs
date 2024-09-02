class Person 
{
   int id;
   String name;
   
   Person(int  id, String name)
   {
    this.id = id;
    this.name = name;
   }
}

    class Emp extends Person{
        float salary;
  Emp(int id,String name, float salary)
 {
   super(id, name);
   this.salary=salary;
 }

 void display()
 {
    System.out.println(id+" "+name+" "+salary);
 }
}

class TestSuper7
{
    public static void main(String[] args) {
        Emp obj =new Emp(6, "priya", 78780f);
        obj.display();
    }
}