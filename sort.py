'''lis=eval(input("enter the list\n"))
lis1=sorted(lis,reverse=True)
print(lis1)
b=lis1.count(lis1[0])
c=lis1[0]
for i in range(0,b):
    lis1.remove(c)
if len(lis1)==0:
    print("No runner up")
else:
    lis1=sorted(lis1,reverse=True)
    print(lis1[0])'''




'''dic1={1:10,2:20}
dic2={3:30,4:40}
dic3={5:50,6:60}

dic1.update(dic2)
dic1.update(dic3)
print(dic1)'''


x=int(input("\n"))
y=int(input("\n"))
z=int(input("\n"))
n=int(input("\n"))
lis=[]
for i in range(0,x+1):
    for j in range(0,y+1):
        for k in range(0,z+1):
            if i+j+k==n:
                continue
            else:
                li=[]
                li.append(i)
                li.append(j)
                li.append(k)
                lis.append(li)
print(lis)
