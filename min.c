#include <stdio.h>
#include <string.h> 
#include <math.h>
#include <stdlib.h>
#include<limits.h> 
int main() {

    int n,n1;
    int c,d;
    scanf("%d%d",&n,&n1);
    int a[n];
    int min=INT_MAX;
    int f;
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
        if(a[i]<min)
        {
            min=a[i];
            f=i;
        }
    }
    for(int j=0;j<n1;j++)
    {
        scanf("%d%d",&c,&d);
        if(f>=c && f<=d)
        {
            printf("%d\n",a[f]);
        }
        else{
            min=a[c];
        for(int k=c+1;k<=d;k++)
        {
            if(a[k]<min)
            {
                min=a[k];
            }
        }
        printf("%d\n",min);
        }
    }
    return 0;
}

