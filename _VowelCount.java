package data2;

public class _VowelCount {
    public static void main(String[] args) {
        String s="Mahima Deshmukh";
        int l=s.length();
        int count=0;
        for( int i=0;i<=l-1;i++)
        {
             char c= s.charAt(i);
             if(c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u')
             {
                count++;
             }
        }
        System.out.println(count);
    }
}
