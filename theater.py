'''def Delete(lst,sum1):
    flag=0
    lst6=[]
    for g in range(0,len(lst)):
        if(sum(lst[g])==0):
            lst6.append(g)
            sum1=sum1-100
            flag=1
    if(flag==1):
        for b in range(0,len(lst6)):
            lst.pop(lst6[b])
    return(sum1)
n=int(input())
lst4=[]
for i in range(0,n):
    j=int(input())
    if(j==0):
        print(-400)
        lst4.append(-400)
    else:
        lst=[[0 for col in range(4)] for row in range(4)]
        for k in range(0,j):
            #lst=[[0 for col in range(13)] for row in range(4)]
            lst2=input().split(' ')
            if lst2[0]=='A':
                lst[0][(int(lst2[1])//3)-1] += 1
            elif lst2[0]=='B':
                lst[1][(int(lst2[1])//3)-1] += 1
            elif lst2[0]=='C':
                lst[2][(int(lst2[1])//3)-1] += 1
            else:
                lst[3][(int(lst2[1])//3)-1] += 1
        sum1=0
        print(lst)
        sum1=Delete(lst,sum1)
        k=len(lst)
        m=100
        while(k>0):
            max1=0
            for e in range(0,len(lst)):
                    d=max(lst[e])
                    if(d>max1):
                        x=lst[e].index(d)
                        max1=d
                        l=e
            lst.pop(l)
            for z in range(0,len(lst)):
                lst[z][x]=0
            sum1=sum1+(m*max1)
            d=m-25
            sum1=Delete(lst,sum1)
            k=len(lst)
        print(sum1)
        lst4.append(sum1)
print(sum(lst4))'''
                
'''k=4
        b=100
        sum1=0
        while(k>0):
            lst5=max(lst6)
            if(sum(lst5)==0):
                sum1=sum1-100
                lst6.remove(lst5)
                k = k-1
            else:
                lst6.remove(lst5)
                g=max(lst5)
                #print(g*b)
                sum1=sum1+(g*b)
                b=b-25
                k=k-1
        print(sum1)
        lst4.append(sum1)
print(sum(lst4))'''

'''import calendar

c = calendar.Calendar(firstweekday=calendar.SUNDAY)
month=2
n=int(input())
for i in range(0,n):
    lst1=[int(x) for x in input().split(' ')]
    lst2=[int(x) for x in input().split(' ')]
    count=0
    if(lst1[0]>2):
        lst1[1] +=1
    if(lst2[0]<2):
        lst2[1] -=1
    for j in range(lst1[1],lst2[1]+1):
        monthcal = c.monthdatescalendar(j,month)
        third_friday = [day for week in monthcal for day in week if \
                        day.weekday() == calendar.FRIDAY and \
                        day.month == month][0]
        d=int(str(third_friday).split("-")[2])
        third_friday = [day for week in monthcal for day in week if \
                day.weekday() == calendar.SUNDAY and \
                day.month == month][2]
        e=int(str(third_friday).split("-")[2])
        d=d+10
        if(e<d):
            count += 1
    print(count)'''
    
from itertools import permutations
n=int(input())
lst4=[]
for i in range(0,n):
    j=int(input())
    if(j==0):
        print(-400)
        lst4.append(-400)
    else:
        lst=[[0 for col in range(4)] for row in range(4)]
        for k in range(0,j):
            #lst=[[0 for col in range(13)] for row in range(4)]
            lst2=input().split(' ')
            if lst2[0]=='A':
                lst[0][(int(lst2[1])//3)-1] += 1
            elif lst2[0]=='B':
                lst[1][(int(lst2[1])//3)-1] += 1
            elif lst2[0]=='C':
                lst[2][(int(lst2[1])//3)-1] += 1
            else:
                lst[3][(int(lst2[1])//3)-1] += 1
        ls=list(permutations([0,1,2,3]))
        lst8=[]
        for h in range(0,len(ls)):
            lst7=[]
            for l in range(0,len(ls[h])):
                lst7.append(lst[l][ls[l]])
            lst7.sort()
            sum1=0
            b=100
            for m in lst7:
                if m!=0:
                    sum1=sum1+(b*m)
                    b=b-25
                else:
                    sum1=sum1-100
            lst8.append(sum1)
        lst4.append(max(lst8))
print(sum(lst4))
            
                

        