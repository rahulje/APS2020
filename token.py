str1=input()
n=int(input())
list1=[]
for i in range(0,n):
    str2=input()
    list1.append(str2)
    
list2=str1.split(' ')
str3=""
for j in list2:
    str3=str3+j

str3=str3+'0'

count=int(str3)
for j in list1:
    if j=='request':
        count=count+1
    elif j=='print':
        print(count)
    elif j=='cancel':
        count=count-1;
