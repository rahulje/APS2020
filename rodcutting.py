n=int(input())
res=[0]*(n+1)
for i in range(2,n+1):
    for j in range(1,int(i/2+1)):
        res[i]=max(res[i],j*(i-j),j*(res[i-j]))
print(res[n])
