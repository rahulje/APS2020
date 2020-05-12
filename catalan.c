n=int(input("Enter n : "))
c=[0]*(n+1)
if n>=2:
    c[2]=2
c[0]=1
c[1]=1

for i in range(3,n+1):
    c[i]=0
    for j in range(i):
        c[i]+=c[j]*c[(i-1)-j]
#if n<3:
 #   print("Catalan number for n = "+str(n)+" is : ",c[n])

print("Catalan number for n = "+str(n)+" is : "+str(c[n]))
