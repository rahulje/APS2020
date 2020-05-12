if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    lis1=sorted(arr,reverse=True)
    b=lis1.count(lis1[0])
    c=lis1[0]
    for i in range(0,b):
        lis1.remove(c)
    if len(lis1)==0:
        print()
    else:
        lis1=sorted(lis1,reverse=True)
        print(lis1[0])




