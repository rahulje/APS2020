#include<stdio.h>
#include<stdlib.h>
void weighted_union(int a[],int size[],int u,int v)
{
	int rootu,rootv;
	rootu=a[u];
	rootv=a[v];
	if(size[u]<size[v])
	{	
		a[rootu]=a[rootv];
		size[rootv] += size[rootu];
	}
	else
	{
		a[rootv]=a[rootu];
		size[rootu] += size[rootv];
	}
}
		
int main()
{
	int a[6]={0,1,2,3,4,5};
	int size[6]={1,1,1,1,1,1};
	weighted_union(a,size,0,1);
	weighted_union(a,size,1,2);
	weighted_union(a,size,3,2);
	for(int i=0;i<6;i++)
	{
		printf("%d ",a[i]);
	}
	printf("\n");
	for(int i=0;i<6;i++)
	{
		printf("%d ",size[i]);
	}
}
	
