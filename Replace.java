package String;

public class Replace {
    public static void main(String[] args) {
        String str = "this is a string";
        String[] s = str.split(" ");
  
         for(int i =0;i<s.length;i++)
         {
            if(s[i].equalsIgnoreCase("string"))
            {
                s[i] = "java";
            }
         }

         String newstr= " ";

         for(int i=0;i<s.length;i++)
         {
            newstr = newstr+s[i]+ " ";
         }
         System.out.print(newstr);


    }
}
