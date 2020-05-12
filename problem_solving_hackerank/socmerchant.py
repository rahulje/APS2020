n=int(input())
lis=[int(x) for x in input().split(' ')]
s=max(lis)
count=0
for i in range(1,s+1):
    f=lis.count(i)
    if f%2==0:
        count=count+f//2
    elif f>2:
        count += f//2
print(count)

