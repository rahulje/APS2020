n=int(input("ennter the range of list\n"))
print("enter the list elements")
lst=[]
sum=0
for i in range(0,n):
    lst.append(int(input()))

min=lst[0]
for i in range(1,n):
    if(min>lst[i]):
        min=lst[i]
print("the minimun is:",min)

    



