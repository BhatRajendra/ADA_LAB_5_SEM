#include <stdio.h>
#include<sys/time.h>
#include<time.h>
#include<sys/resource.h>

int heapSort(int a[], int n);
int shiftDown(int a[], int root, int bottom);
void main()
{
    int a[100], n, i;
    struct timeval tv1,tv2;
    struct rusage r_usage;

    printf("Enter the number of elements \n");
    scanf("%d",&n);

    printf("Enter the elements \n");
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);

    gettimeofday(&tv1,NULL);
    heapSort(a,n);
    gettimeofday(&tv2,NULL);

    printf("Sorted elements are \n");
    for(i=0;i<n;i++)
        printf("%d ",a[i]);

    printf("Time taken by Heap sort=%f microseconds \n",(double)(tv2.tv_usec-tv1.tv_usec));

    getrusage(RUSAGE_SELF,&r_usage);
    printf("Memory usage:%ld kilobytes \n",r_usage.ru_maxrss);
}


int heapSort(int a[], int n)
{
  int i, temp;

  for (i = n-1; i >= 0; i--)
    shiftDown(a, i, n - 1);

  for (i=n-1;i>=1;i--)
  {
    temp = a[0];
    a[0] = a[i];
    a[i] = temp;
    shiftDown(a, 0, i-1);
  }
}


int shiftDown(int a[], int root, int bottom)
{
    int done, maxChild, temp;

    done = 0;
    while ((root*2 <= bottom) && (!done))
    {
        if (root*2 == bottom)
            maxChild = root * 2;
        else if (a[root * 2] > a[root * 2 + 1]) //left child greater than right child
            maxChild = root * 2;
        else
            maxChild = root * 2 + 1;

        if (a[root] < a[maxChild]){ //exchange root with maxchild 
            temp = a[root];
            a[root] = a[maxChild];
            a[maxChild] = temp;
            root = maxChild;
        }
        else
            done = 1;  
    }
 }
