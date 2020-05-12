n=int(input())
num=list(map(int,input().split()))
for j in range(1,n+1):
    for i in range(n-1):
        temp=num[i]
        num[i]=num[i+1]
        num[i+1]=temp
        for k in range(n):
            print(num[k],end=" ")
        print()


