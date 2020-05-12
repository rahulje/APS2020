'class node:
    def __init__(self,n):
        self.data=n
        self.next=None
class link:
    def __init__(self):
        self.first=None
    def insertRear(self):
        n=node(int(input("enter the data\n")))
        if self.first==None:
            self.first=n
        else:
            i=self.first
            while i.next!=None:
                i=i.next
            i.next=n
    def display(self):
        i=self.first
        while i!=None:
            print(i.data)
            i=i.next
                
l=link()
l.insertRear()
l.insertRear()
l.insertRear()
l.insertRear()
l.display()
