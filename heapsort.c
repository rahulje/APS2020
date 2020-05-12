arr=[0]
a=list(map(int,input().split()))
arr.extend(a)
n=len(a)
for i in range(n//2,0,-1):
    
    k=i
    v=arr[i]
    heap=False
    #print("i : k: ",i,k)
    while((not heap) and 2*k<=n):
        j=2*k
        #print(j)
        if j<n:
            if arr[j]<arr[j+1]:
                j+=1
        if v>=arr[j]:
            heap=True
        else:
            arr[k]=arr[j]
            k=j
    arr[k]=v

print(arr)
