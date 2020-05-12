#include <stdio.h>

int main()
{
	unsigned int n;
	printf("enter the integer\n");
	scanf("%d",&n);
	int count=0;
	while(n!=0){
		if(n & 1 == 1) //if current bit is 1
			break; //no more trailing zero
		n=n>>1; //right shift
		count++; //if trailing zero, increase count
	}

	printf("no of trailing zero ");
	//print no of trailing zero
	printf("in its binary representation: %d \n",count); 

	return 0;
}
