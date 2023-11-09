import java.util.*;
public class mergeSort {
    

    void mergesort(int arr[],int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergesort(arr, left, mid);
            mergesort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }
        // Merge two sub arrays L and M into array

    void merge(int arr[],int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int b[]=new int[n1];
        int c[]=new int[n2];
    // fill the left and right array
        for(int i=0;i<n1;i++){
            b[i]=arr[left+i];
        }

        for(int i=0;i<n2;i++){
            c[i]=arr[mid+1+i];  
        }
    // Maintain current index of sub-arrays and main array
        int i,j,k;
        i=0;
        j=0;
        k=left;
    // Until we reach either end of either b or c, pick larger among
    // elements b and c and place them in the correct position at A[left..right]
    // for sorting in descending
    // use if(b[i] <= c[j])
        while(i<n1 && j<n2){
            if(b[i]<=c[j]){
                arr[k]=b[i];
                i++;
            }
            else{
                arr[k]=c[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=b[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=c[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){

      Random rand=new Random();
      int[] array =new int[1000];
      for(int i=0;i<array.length;i++){
        array[i]=rand.nextInt(1000);
      }
      mergeSort obj = new mergeSort();
      long start1 = System.nanoTime();
      long start2 = System.currentTimeMillis();

      

      obj.mergesort(array,0,array.length-1);

      long end1 = System.nanoTime();  
      long end2 = System.currentTimeMillis();      


      System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));      
      System.out.println("Elapsed Time in milli seconds: "+ (end2-start2));

      System.out.println("\n\nSorted Array:");
      for(int i=0;i<array.length;i++){
        System.out.print(array[i]+" ");
      }
    }
}
