 public class _62DivisionByMethod {
    
    public static void divided(){

        System.out.println("=======dividible by 3======");
        for(int i=1;i<=100;i++){        
        if(i%3==0){
    System.out.print(" "+i);
}   
        }
        System.out.println(" ");

        System.out.println("========Division by 5=======");

        for(int i=1;i<=100;i++){
            if(i%5==0){
           System.out.print(" "+i);
            }
        }

        System.out.println(" ");

        System.out.println("========Division by 3 & 5 both========");
        for(int i=1;i<=100;i++){
            if(i%3==0 && i%5==0){
            System.out.print(" "+i);
            }
        }
    }
    public static void main(String[] args) {
        divided();
    }
}
