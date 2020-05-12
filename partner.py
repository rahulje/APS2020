n=int(input())
lst1=[]
lst2=[]
lst3=[]
lst4=[]
for i in range(0,n):
    lst=[int(x) for x in input().split(' ')]
    lst1.append(lst)
    lst3.append([0,1])
for i in range(0,n):
    lst=[int(x) for x in input().split(' ')]
    lst2.append(lst)
    lst4.append([0,0,(n+1),0])
q=int(input())
w=int(input())
while True:
    count1=0
    for k in lst3:
        if k[0]==1:
            count1 += 1
    if count1 ==n:
        break
    else:
        for i in range(0,n):
            for j in range(0,n):
                print(i,j)
                if lst1[i][j]==lst3[i][1] and lst3[i][0]==0:
                    if lst4[j][0]==0 or lst2[i][j]<lst4[j][2]:
                        lst4[j][0]=1
                        lst4[j][1] += 1
                        lst4[j][2]=lst2[i][j]
                        if lst4[i][3]==0:
                            lst4[i][3]=i+1
                        else:
                            lst3[lst4[i][3]]=0
                            lst4[i][3]=i
                        lst3[i][0]=1
                        lst3[i][1] += 1
                        break;
                    else:
                        lst3[i][1] +=1
                        lst4[j][1] +=1
                        i=i-1
                        break
print(lst4[w-1][1])
