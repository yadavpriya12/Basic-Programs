 class Demo2{
    
    String name;
    int age;
    int emarks;

    public int data(int jmarks){
        int total = jmarks+emarks;
        return total;

    }
 }
class Driver3{

    public static void main(String[] args) {
        Demo2 sobj= new Demo2();
        sobj.name = "rahul";
        sobj.age=32;
        sobj.emarks=15;
        int result = sobj.data(16);
    
        System.out.println(sobj.name+"Scored"+result);    }
}
