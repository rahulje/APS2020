n=int(input())
lst=[]
lst2=[]
flag=0
for i in range(0,n):
    women=input().split(' ')
    lst.append(women)
for i in lst:
    for j in range(0,len(i)):
        if i[j]=='-1':
            lst2.append(j+1)
for i in range(1,n+1):
    s=lst2.count(i)
    if s==n:
        print(i)
        flag=1
if flag==0:
    print(-1)
