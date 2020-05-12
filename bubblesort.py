def read(n,arr):
    for i in range(0,n):
        arr.append(int(input()))


def sort1(n,arr):
    for i in range(0,n-1):
        for j in range(0,n-1):
            if arr[j]>arr[j+1]:
                temp=arr[j]
                arr[j]=arr[j+1]
                arr[j+1]=temp

def display(arr):
    for i in arr:
        print(i)



n=int(input("enter the range of the array\n"))
arr=[]
read(n,arr)
sort1(n,arr)
display(arr)

