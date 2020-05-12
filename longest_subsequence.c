#include<stdio.h>
#include<string.h>
int max(int a,int b)
{
	return((a>b?a:b));
}
void findLongestSubsequence(char str1[10],char str2[10])
{
	int str[6][6]={0};
	for(int i=1;i<=strlen(str1);i++)
	{
		for(int j=1;j<=strlen(str2);j++)
		{
			if(str1[i]==str2[j])
			{
				str[i][j]=str[i-1][j-1]+1;
			}
			else
			{
				str[i][j]=max(str[i][j-1],str[i-1][j]);
			}
		}
	}
	for(int i=0;i<=strlen(str1);i++)
	{
		for(int j=0;j<=strlen(str2);j++)
		{
			printf("%d ",str[i][j]);
		}
		printf("\n");
	}
	
}
int main()
{
	char str1[10]="abcdef";
	char str2[10]="abchij";
	//int **str;
	findLongestSubsequence(str1,str2);
	
}
	
