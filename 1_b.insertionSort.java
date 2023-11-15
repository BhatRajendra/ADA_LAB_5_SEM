import java.util.Arrays;
import java.util.Random;
public class insertionSort{
    Random rand = new Random();
    int arr[]=new int[200];

    void sort(){
        int min,n =200;
        for(int i=0;i<n;i++){
            arr[i]=rand.nextInt(100);
        }

        //unsorted array
        System.out.println("UNSORTED ARRAY:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");

    //apply insertion sort algorithm on the array
    for(int k=1; k<arr.length; k++){
        int temp = arr[k];
        int j= k-1;
        while(j>=0 && temp <= arr[j]){
            arr[j+1] = arr[j];
            j = j-1;
        }
        arr[j+1] = temp;
    }

    //print the sorted array
    System.out.println("SORTED ARRAY:");
    System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        insertionSort obj = new insertionSort();
        long start1 = System.nanoTime();
        long start2 = System.currentTimeMillis();

        obj.sort();

        long end1 = System.nanoTime();  
        long end2 = System.currentTimeMillis();      


        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));      
        System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
    }
}
