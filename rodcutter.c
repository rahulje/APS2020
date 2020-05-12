#include<stdio.h>
long int max(long int a,long int b)
{
    return (a>b?a:b);
}
long int rodcutter(long int b[1000],long int n)
{
    long int a[1000];
    long int res;
    a[0]=0;
    a[1]=b[0];
    for(long int i=2;i<=n;i++)
    {
        for( long int j=1;j<=(i/2);j++)
        {
            res=max(b[i-1],(a[j]+a[i-j]));
        }
        a[i]=res;
    }
    return(a[n]);
            
}
int main()
{
    long int n,maxProduct;
    long int b[1000];
    scanf("%ld",&n);
    for(long int i=0;i<n;i++)
    {
        scanf("%ld",&b[i]);
    }    
    maxProduct=rodcutter(b,n);
    printf("%ld\n",maxProduct);
}
    
    
