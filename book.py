class NegativeException(Exception):
    def __str__(self):
        return("negative Exception caught")
class NumericException(Exception):
    def __str__(self):
        return("Error: The string  should contain only alphabets" )
class book:
    def readbook(self):
        print("enter the book details\n1:author\n2:title\n3:price\n4:publisher\n5:stock")
        self.__auth=input()
        if not self.__auth.isalpha():
            raise NumericException
        self.__til=input()
        if not self.__til.isalpha():
            raise NumericException
        self.__price=int(input())
        if self.__price<=0:
            raise NegativeException
        self.__pub=input()
        if not self.__pub.isalpha():
            raise NumericException
        self.__stock=int(input())
        if self.__stock<0:
            raise NegativeException
    def display(self):
        print("author:",self.__auth,"\ntitle:",self.__til,"\nprice:",self.__price,"\npublisher:",self.__pub,"\nstock:",self.__stock)
    def returnau(self):
        return(self.__auth)
    def returnti(self):
        return(self.__til)
    def update(self,a):
        self.__stock=self.__stock-a
    def returnst(self):
        return(self.__stock)
    def returnpr(self):
        return(self.__price)
class bookstall:
    counter=0
    def __init__(self):
        self.__b=[]
    def addbook(self):
        self.__b.append(book());
        self.__b[bookstall.counter].readbook()
        bookstall.counter=bookstall.counter+1
    def displayall(self):
        for i in self.__b:
            i.display()
            print("-------------------------------------")
    def searchbook(self):
        x=input("enter the book author\n")
        if not x.isalpha():
            raise NumericException
        y=input("enter the book title\n")
        if not y.isalpha():
            raise NumericException
        for i in self.__b:
            if i.returnau()==x and i.returnti()==y:
                print("the book found")
                i.display()
                return
        print("the book not found")
    def purchasebook(self):
        x=input("enter the book author\n")
        if not x.isalpha():
            raise NumericException
        y=input("enter the book title\n")
        if not y.isalpha():
            raise NumericException
        for i in self.__b:
            if i.returnau()==x and i.returnti()==y:
                print("the book found")
                i.display()
                print("enter the number of books u want")
                j=int(input())
                if j<0:
                    raise NegativeException
                if j>i.returnst():
                    print("not stock avilable")
                    return
                else:
                    print("the total price of book is:",i.returnst()*i.returnpr())
                    print("want to buy a book if yes press 1 else press 2")
                    if int(input())==1:
                        i.update(j)
                        print("book purchased succesfully")
                        return
        print("book not found")
        
def main():
    x=bookstall()
    while True:
        print("enter the choice\n1:add book\n2:search book\n3:displayall\n4:purchase book")
        ch=int(input())
        if ch==1:
            try:
                x.addbook()
            except NegativeException as n:
                print(n)
            except ValueError as v:
                print(v)
            except NumericException as e:
                print(e)
        elif ch==2:
            try:
                x.searchbook()
            except NumericException as e:
                print(e)
        elif ch==3:
            x.displayall()
        elif ch==4:
            try:
                x.purchasebook()
            except NumericException as e:
                print(e)
            except ValueError as v:
                print(v)
            except NegativeException as n:
                print(n)
        else:
            break;
            
main()        
