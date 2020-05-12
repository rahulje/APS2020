#include<stdio.h>
int binSubtracton(int a, int b) 
{
      int carry;
      //get 2's compliment of b and add in a
      b = binAddition(~b, 1);
 
      while (b != 0) {
              //find carry and shift it left    
              carry = (a & b) << 1;
              //find the sum
              a = a ^ b;
              b = carry;
      }
      return a;
}
int main() 
{
    int number1,number2, binAdd, binSub;
 
    printf("Input first integer value: ");
    scanf("%d",&number1);
   
    printf("Input second integer value: ");
    scanf("%d",&number2);
 
    
    binSub=binSubtracton(number1,number2);
 
    
    printf("Binary Subtraction: %d\n",binSub);
 
    return 0;
 
}
