n=int(input("ennter the range of list\n"))
print("enter the list elements")
lst=[]
sum=0
for i in range(0,n):
    lst.append(int(input()))

i=0;
j=n-1
while(i<j):
    temp=lst[i]
    lst[i]=lst[j]
    lst[j]=temp
    i=i+1
    j=j-1
print(lst)

    


 
