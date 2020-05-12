#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct
{
	int a[100];
	int top;
}stack;
int pop(stack *s)
{
	int temp;
	if(s->top==-1)
	{
		printf("empty\n");
	}
	else
	{
		temp=s->a[s->top];
		s->top=s->top-1;
		return(temp);
	}
}
void push(stack *s,int c)
{
	s->top=s->top+1;
	s->a[s->top]=c;
} 
int isempty(stack *s)
{
	if(s->top==-1)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
void dfs()
{
	int nodes;
	printf("enter the number of nodes\n");
	scanf("%d",&nodes);
	int graph[nodes+1][nodes+1];
	int visited[nodes+1];
	for(int m=1;m<nodes+1;m++)
	{
		visited[m]=0;
		for(int n=1;n<nodes+1;n++)
		{	
			if(m==n)
			{
				graph[m][n]=0;
			}
			else
			{
				printf("is there edge between %d and %d\n", m,n);
				scanf("%d",&graph[m][n]);
			}
		}
	}
	int flag;
	stack s;
	int count=1;
	int k;
	int first[100];
	int last[100];
	int i;
	s.top=-1;
	visited[1]=1;
	first[1]=1;
	count++;
	push(&s,1);
	printf("%d ",1);
	i=1;
	while(!isempty(&s))
	{
		flag=0;
		for(int j=1;j<nodes+1;j++)
		{
			//printf("%d %d\n",i,j);
			if(visited[j]==0 && graph[i][j]==1)
			{
				printf("%d ",j);
				visited[j]=1;
				first[j]=count;
				count++;
				push(&s,j);
				//printf("%d\n",j);
				i=j;
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			k=pop(&s);
			last[k]=count;
			count++;
			i=s.top;
		}
	}
	/*int temp=first[2];
	int temp2=last[2];
	printf("\n%d",2);
	for(int l=3;i<nodes+1;l++)
	{
		int temp3=first[l];
		int temp4=last[l];
		 if((temp3>temp && temp3<temp2) && (temp4>temp && temp4<temp2))
         {
               printf("%d",l);
         }
     }*/
     for(int l=0;l<nodes+1;l++)
     {
     	printf("%d %d",first[l],last[l]);
     }
}
int main()
{
	dfs();
}
	
