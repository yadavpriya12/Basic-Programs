

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

 class ReadWrite {
    public static void main(String[] args) {
        try{
            File f = new File("Example.txt");
            FileOutputStream fout = new FileOutputStream(f,true);
            String data = "java is a platform independent";
                      byte b[] = data.getBytes();
            fout.write(b);

            System.out.println(data);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    

try{
    File file = new File("Example.txt");
    FileInputStream fin = new FileInputStream(file);

     String data = " java is an object oriented programming language";
     byte b[] = data.getBytes();
     fin.read(b);
    System.out.println(data);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}
} 
