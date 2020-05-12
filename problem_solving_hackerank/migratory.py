n=int(input())
lis=[int(x) for x in input().split(' ')]
max1=max(lis)
min=-1
for i in range(1,max1+1):
    s=lis.count(i)
    if s>min:
        min=s
        h=i
print(h)



