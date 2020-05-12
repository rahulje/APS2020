a=list(map(int,input().split()))
n=len(arr)
lis=[1]*n
for i in range(1,n):
    for j in range(i):
        if a[i]>a[j] and (lis[j]+1)>lis[i]:
            lis[i]=lis[j]+1
print(lis[n-1])


