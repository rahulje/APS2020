n=int(input())
k=int(input())
lis1=[]
for i in range(0,n):
    lsi=[]
    for j in range(0,k):
        lsi.append(0)
    lis1.append(lsi)
for i in range(0,n):
    for j in range(0,min(i,k)):
        if j==0 or j==i:
            lis1[i][j]=1
        else:
            lis1[i][j]=lis1[i-1][j-1]+lis1[i-1][j]
for i in range(n):
    for j in range(k):
        print(lis1[i][j],end='\t')
    print()

        