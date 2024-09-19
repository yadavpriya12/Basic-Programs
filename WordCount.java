
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class WordCount {
    

    public static void main(String[] args) {
        int count =0;
        String data =" ";
        try{
            
            File f1 = new File("File.txt");
              FileInputStream fin = new FileInputStream(f1);
             System.out.println("size="+" " + f1.length()/5 );

        while(true)
        {
     int x= fin.read();
     if((char)x==' ')
     {
        count++;
     }

     else if(x==-1)
     {
        break;
     }

     data = data + (char)x;
        }

        System.out.println(data);
        System.out.println(count);
        System.out.println();
    }
     catch (Exception e) {
          e.printStackTrace();
        }
    }
}

