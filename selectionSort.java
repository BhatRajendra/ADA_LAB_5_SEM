import java.time.*;
import java.util.*;
public class selectionSort {
    Random rand=new Random();
    int[] arr=new int[1000];
    
    void sort(){
        int min,n=arr.length;
        for(int i=0;i<n;i++){
            arr[i]=rand.nextInt(100);
        }
        // //unsorted
        // System.out.println("Unsorted array");
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        System.out.println();
        //now sorting
        for(int i=0;i<n-2;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(i!=min){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp; 
            }          
        }

        // //sorted print
        // System.out.println("sorted array");
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
    }
    public static void main(String args[]){
        selectionSort obj = new selectionSort();

        long start1 = System.nanoTime();
        long start2 = System.currentTimeMillis();

        obj.sort();
        
        long end1 = System.nanoTime();  
        long end2 = System.currentTimeMillis(); 
        
        System.out.println("\nElapsed Time in nano seconds: "+ (end1-start1));      
        System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));
    }
}
