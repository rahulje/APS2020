#include < stdio.h>
#include < stdlib.h>
#define NULL 0
int main()
{
char *str;
str = (char *)malloc(10);
if(str==NULL)
{
printf("\n Memory could not be allocated");
exit(1);
}
strcpy(str,"Hi");
printf("\n STR = %s", str);
/*Reallocation*/
str = (char *)realloc(str,20);
if(str==NULL)
{
printf("\n Memory could not be reallocated");
exit(1);
}
printf("\n STR size modified\n");
printf("\n STR = %s\n", str);
strcpy(str,"Hi there");
printf("\n STR = %s", str);
/*freeing memory*/
free(str);
return 0;
}
