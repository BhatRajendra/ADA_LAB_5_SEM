#include <string.h>
#include <stdio.h>
#include<sys/time.h>
#include<time.h>
#include<sys/resource.h>
int gets();
char str[100],ptn[20];
int res,m,n,len,len1,i,j,k,table[1000];
int horspool(char p[], char t[]);
void main()
{
 struct timeval tv1,tv2;
struct rusage r_usage;

printf("Enter the text \n");
 gets(str);
 //we use gets() insetead of scanf because scanf stops readig after a space but gets stops only after newline
 //gets() treats space as anothher string
 printf("Enter the pattern to be found \n");
gets(ptn);
gettimeofday(&tv1,NULL);
 res=horspool(ptn,str);
gettimeofday(&tv2,NULL);
 if(res==-1)
     printf("\nPattern not found\n");
 else
     printf("Pattern found at %d position \n",res+1);
 printf("Time of Horsepool's Algorithm=%f microseconds \n",(double)(tv2.tv_usec-tv1.tv_usec));
 getrusage(RUSAGE_SELF,&r_usage);
 printf("Memory usage:%ld kilobytes \n",r_usage.ru_maxrss);
}

void shift(char p[])
{
 len=strlen(p);
 for(i=0;i<1000;i++)
   table[i]=len;
 for(j=0;j<=len-2;j++)
  table[p[j]]=len-1-j;
}

int horspool(char p[], char t[])
{
 shift(p);
 m=strlen(p);
 n=strlen(t);
 i=m-1;
 while(i<=n-1)
 {
  k=0;
  while(k<=m-1 && (p[m-1-k]==t[i-k]))
	k++;
  if(k==m)
        return i-m+1;
  else
        i=i+table[t[i]];
 }
 return -1;
}
