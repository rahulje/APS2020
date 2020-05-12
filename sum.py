bvb={}
n=int(input("enter the range\n"))
print("enter the details")
for i in range(0,n):
    pno=input("enter the pan number\n")
    d={'eno':int(input("enter the empno\n")),'empname':input("enter the name\n")}
    if pno in bvb:
        print("pan with already exist")
        i=i-1;
    else:
        bvb[pno]=d
print(bvb)
