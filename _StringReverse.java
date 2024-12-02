package data2;

public class _StringReverse {
    
    public static void main(String[] args) {
        String s="Hello";
        int l= s.length();
        for(int i=l-1;i>=0;i--)
        {
            System.out.print(s.charAt(i));
        }
    }
}
