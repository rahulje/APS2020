if __name__ == '__main__':
    x = int(raw_input())
    y = int(raw_input())
    z = int(raw_input())
    n = int(raw_input())
    lis=[]
    for i in range(0,x+1):
        for j in range(0,y+1):
            for k in range(0,z+1):
                lis1=[]
                if((i+j+k)!=n):
                    lis1.append(i)
                    lis1.append(j)
                    lis1.append(k)
                    lis.append(lis1)

    print(lis)

