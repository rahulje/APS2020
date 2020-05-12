try:
    n=int(input())
    for i in range(0,n):
        a,v=map(int,input().split(' '))
        lst2=[int(x) for x in input().split(' ')]
        for j in range(0,a):
            v=v-lst2[j]
        if v<0:
            print("NO")
        else:
            print("YES")
except EOFError as e : 
    pass
    
    

