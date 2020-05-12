#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int find(int a[],int n)
{
    int b[n];
    for(int k=0;k<n;k++)
    {
        b[k]=1;
    }
    int i,j;
    int max;
    for( i=1;i<n;i++)
    {
        for(j=0;j<i;j++)
        {
            if(a[i]>a[j] && (b[j]+1)>b[i])
            {
                b[i]=b[i]+1;
            }
        }
    }
    max=b[0];
    for(i=1;i<n;i++)
    {
        if(b[i]>max)
            max=b[i];
    }
    return max;
}
int main()
{
    int a[10000];
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    n=find(a,n);
    printf("%d\n",n);
}
