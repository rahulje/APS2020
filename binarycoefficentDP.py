n=int(input())
k=int(input())
c= [[0 for x in range(n+1)] for x in range(n+1)] 
if k<=n:
    for i in range(0,n+1):
        for j in range(min(i,k)+1):
            #print(i,j)
            if j==0 or j==i:
                c[i][j]=1
            else:
                c[i][j]=c[i-1][j-1]+c[i-1][j]
    print(c[n][k])
