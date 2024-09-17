package String;

public class RemoveSpace {
    public static void main(String[] args) {
        String str = "This is a string";
         String newstr = " ";

         for(int i=0;i<str.length();i++)
         {
            if(str.charAt(i)!=' ')
            {
                newstr = newstr + str.charAt(i);
            }
         }

         str = newstr;
         System.out.println(str);
    }
}
