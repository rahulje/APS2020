import sys
def kadane(a,n):
    
    max1=-sys.maxsize-1
    tmax=0
    u=0
    v=0
    x=0
    if len(a)==0:
        max1=0
    else:
        for i in range(n):
            
            tmax+=a[i]
        
            if max1<tmax:
                max1=tmax
                u=x
                v=i
            if tmax<0:
                tmax=0
                x=i+1
    return max1,u,v


n=int(input())
a=list(map(int,input().split()))
max1,u,v=kadane(a,n)
l=[]
l.extend(a[0:u])
l.extend(a[v+1:])


max2,u1,v1=kadane(l,len(l))
print(max1)
print(max2)
