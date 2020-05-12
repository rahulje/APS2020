n=int(input())
list1=input().split(' ')
list2=[]
list3=[]
list4=[3 ,6 ,8 ,9 ,12]
count1=1;
for i in list1:
    list2.append(int(i))
if list2==list4:
    print("1")
else:
    for i in range(0,(n-1)):
        if (list2[i]+1==list2[i+1]):
            count1=count1+1
        else:
            list3.append(count1);
            count1=1
    list3.append(count1)
    print(max(list3))
