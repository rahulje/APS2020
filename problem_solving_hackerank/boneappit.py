n,k=tuple([int(x) for x in input().split(' ')])
lis=[int(x) for x in input().split(' ')]
b=int(input())
lis[k]=0
c=sum(lis)//2
if c==b:
    print("Bon Appetit")
else:
    print(b-c)

