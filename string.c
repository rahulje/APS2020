#include<stdio.h>
#include<string.h>
void change(char *st)
{
	printf("%ld\n",strlen(st));
}

int main()
{
	char str[100];
	printf("enter\n");
	scanf("%s",str);
	//str[1]='e';
	printf("%s\n",str);
	change(str);
}
