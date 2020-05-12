n=int(input())
for i in range(0,n):
    lst2=[]
    flag=0
    a,b,c,d=map(int,input().split(' '))
    for j in range(0,d):
        lst=input().split(' ')
        lst2.append(lst)
    for k in lst2:
        if int(k[0])+b>=a and c>=int(k[1]):
            flag=1
            print("LuckyChef")
            break
    if flag==0:
        print("UnluckyChef")
