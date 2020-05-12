#include<stdio.h>
#include<stdlib.h>
void Union(int a[],int u,int v)
{
	int temp=a[u];
	for(int i=0;i<10;i++)
	{
		if(a[i]==temp)
		{
			a[i]=a[v];
		}
	}
}
int main()
{
	//int n;
	//scanf("%d",&n);
	int a[10]={0,1,2,3,4,5,6,7,8,9};
	Union(a,2,1);
	Union(a,4,3);
	Union(a,8,4);
	Union(a,9,3);
	Union(a,6,5);
	
	for(int i=0;i<10;i++)
	{
		printf("%d ",a[i]);
	}
}
