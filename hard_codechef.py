n=int(input())
for i in range(0,n):
    lst1=[int(y) for y in raw_input().split(' ')]
    #k=int(input())
    lst=[int(x) for x in raw_input().split(' ')]
    b=sum(lst)
    print(b%lst1[1])
