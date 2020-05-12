def read(n,arr):
    for i in range(0,n):
        arr.append(int(input()))


def insertion(n,arr):
    for i in range(0,n-1):
        min=i
        for j in range(i+1,n):
            if arr[min]>arr[j]:
                min=j
        if i!=min:
            temp=arr[i]
            arr[i]=arr[min]
            arr[min]=temp

def display(arr):
    for i in arr:
        print(i)



n=int(input("enter the range of the array\n"))
arr=[]
read(n,arr)
insertion(n,arr)
display(arr)

