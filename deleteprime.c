#include <stdio.h>

//function to check number is prime or not
//function will return 1 if number is prime
int isPrime(int num)
{
	int i; //loop counter
	//it will be 1 when number is not prime
	int flag=0; 
	//loop to check number is prime or not
	//we will check, if number is divisible
	//by any number from 2 to num/2, then it
	//will not be prime
	for(i=2; i<num/2; i++)
	{
		if(num%i ==0)
		{
			flag =1;
			break;
		}
	}
	//flag is 1, if number is not prime
	if(flag==1)
		return 0;
	else
		return 1;
}

int main()
{
	int i,j; //loop counters
	//declaring array with prime and not prime numbers
	int arr[]={100, 200, 31, 13, 97, 10, 20, 11};
	//calculate length of the array
	int len = sizeof(arr)/sizeof(arr[0]);
	
	//delete prime numbers
	for(i=0; i<len; i++)
	{
		if(isPrime(arr[i]))
		{
			//number is prime, then shift other
			//elements to the left
			for(j=i; j<len; j++)
			{
				arr[j] = arr[j+1];
			}
			//decrease loop counter by 1,
			//to check shifted element
			i--;
			//decrease the length
			len--;			
		}
	}
	
	//print elements after removing prime numbers
	printf("Array elements after removing prime numbers:\n");
	for(i=0; i<len; i++)
		printf("%3d\n",arr[i]);
	
	printf("\n");
	
	return 0;	
}
