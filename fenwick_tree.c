#include<stdio.h>
int BIT[1000],a[1000];
int n=10;
void update(int index,int val)
{
	for( ;i<=n;i+=(i &-i))
	{
		BIT[i] += value;
		
	}		
} 
int query(int x)
{
	int sum=0;
	for(;x>=0;i=i-(i&-i))
	{
		sum=sum+BIT[i];
	}
	return sum;
}
int main()
{
	int index,val;
	scanf("%d%d",&index,&val);
	update(index,val);
	for(int i=0;i<n;i++)
	{
		printf("%d ",BIT[i]);
	}
	printf("\n");
	int x;
	scanf("%d",&x); 
	int
	

