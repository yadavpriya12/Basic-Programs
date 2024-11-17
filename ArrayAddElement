import java.util.Scanner;
public class arrAddElem {

    public static int[] addElemAt1st(int[] arr, int s, int k){
        int[] Arr = new int[s+1];
        for(int i = 0; i < Arr.length; i++){
            if(i==0){
                Arr[i]= k;
            }else{
                Arr[i]= arr[i-1];
            }
        }
            return Arr;
    }

    public static void main(String[] arg){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
    System.out.println("Enter the elements of the array:");
        for(int i = 0; i<size;i++){
            arr[i]= sc.nextInt();
        }
    System.out.print("Enter the element that you want to add: ");
            int k = sc.nextInt();

        arr = addElemAt1st(arr, arr.length, k);

    for(int i = 0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
    }
        sc.close();
    }
}
