 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


class Serialization1 {
  public static void main(String[] args) {

    try{
    File file = new File("Employee.txt");
    FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            Employee c = new Employee(100,"Abc","8823456893",18);
               oos.writeObject(c);
               System.out.println(" code successfull run... ");

    }
    catch(Exception e){
            e.printStackTrace();
    }


    try{
      File file=new File("Employee.txt");
      FileInputStream fin = new FileInputStream(file);
      ObjectInputStream oos1 = new ObjectInputStream(fin);
      Employee c = new Employee(100,"priya","8823456893",18);
      oos1.readObject();
      System.out.println("desirealization done");
    }
    catch(Exception e)
    {
          e.printStackTrace();
    }
    

    

      
    }

    
}
