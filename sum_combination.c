#include<stdio.h>
#include<string.h>
void getTotal(int *result,int n)
{
	result[0]=1;
	for(int i=3;i<=n;i++)
	{
		result[i]=result[i-3]+result[i];
	}
	for(int i=5;i<=n;i++)
	{
		result[i]=result[i-5]+result[i];
	}
	for(int i=10;i<=n;i++)
	{
		result[i]=result[i-10]+result[i];
	}
	for(int i=0;i<=n;i++)
	{
		printf("%d	 ",result[i]);
	}
}
int main()
{
	int n;
	scanf("%d",&n);
	int arr[n+1];
	memset(arr,0,(n+1)*sizeof(arr[0]));
	getTotal(arr,n);
}
