coin=list(map(int,input().split()))
amt=int(input("Enter amount : "))
res=[[0 if col == 0 else float("inf") for col in range(amt+1)] for _ in range(len(coin))]
for i in range(len(coin)):
    for j in range(1,amt+1):
        if(j<coin[i]):
            res[i][j]=res[i-1][j]
        else:
            res[i][j]=min(res[i-1][j],1+res[i][j-coin[i]])
res[len(coin)-1][amt]


