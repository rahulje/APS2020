'''class NegativeException(Exception):
    def __str__(self):
        return("Error:negative Exception caugth")
class StackoverflowException(Exception):
    def __str__(self):
        return("Stack Overflow")
class StackUnderflowException(Exception):
    def __str__(self):
        return("Stack underflow")
class Stack:
    def __init__(self,a):
        if(a<=0):
            raise NegativeException
        self.stk=[]
        self.size=a
        self.top=-1
    def push(self,data):
        if self.top==self.size-1:
            raise StackoverflowException
        self.stk.append(data)
        self.top += 1
    def pop(self):
        if self.top==-1:
            raise StackUnderflowException
        data=self.stk[self.top]
        self.top -= 1
        return data
    def displaystacktop(self):
        if self.top==-1:
            raise StackUnderflowException
        return(self.stk[self.top])
    def displayall(self):
        if self.top==-1:
            raise StackUnderflowException
        for i in self.stk:
            print(i)
def main():
    print("enter the stack size")
    try:
        x=Stack(int(input()))
    except NegativeException as n:
        print(n)
        return(None)
    except ValueError as v:
        print(v)
        return(None)
    while True:
        print("enter the choice\n1:push\n2:pop\n3:stacktop\n4:displayall\n5:exit")
        ch=int(input())
        if ch==1:
            try:
                print("enter the data")
                x.push(int(input()))
            except StackoverflowException as s:
                print(s)
            except ValueError as v:
                print(v)
        elif ch==2:
          try:
              data=x.pop()
              print("poped data is:",data)
          except StackUnderflowException as s:
              print(s)
        elif ch==3:
           try:
               data=x.displaystacktop()
               print("the top is:",data)
           except StackUnderflowException as s:
               print(s)
        elif ch==4:
            try:
                x.displayall()
            except StackUnderflowException as s:
                print(s)
        else:
            break
        

main()'''

'''def remove(b,lis,c):
    for j in range(0,b):
        lis.remove(c)
str1=input("enter the name\n")
if len(str1)==0:
    print("the string empyty")
else:
    lis=list(str1)
    while len(lis)!=0:
        for i in range(0,len(lis)):
            b=lis.count(lis[i])
            print(lis[i]+":"+str(b))
            remove(b,lis,lis[i])
            break'''
                
'''import pymysql
pymysql.install_as_MySQLdb()
import MySQLdb
class students:
    def update(self,name,per):
        self.name=name
        self.per=per
    def readstudent(self):
        self.rollnor=int(input("enter the rollnor\n"))
        self.name=input("enter the name of the student\n")
        self.per=input("enter the percentage\n")
    def displaystudent(self):
        print("Rollnor:",self.rollnor,"\nname:",self.name,"\npercenatge:",self.per)
class database:
    def __init__(self):
        self.db=MySQLdb.connect("localhost","root","","BVB")
    def addStudent(self,s):
        cursor=self.db.cursor()
        sql="insert into student values("+str(s.rollnor)+",'"+s.name+"',"+str(s.per)+")"
        cursor.execute(sql)
        self.db.commit()
    def displayall(self):
        cursor=self.db.cursor()
        sql="select * from student"
        cursor.execute(sql)
        result=cursor.fetchall()
        print("Rollnor","Name","percenatge",sep="\t\t")
        for i in range(0,len(result)):
            for j in range(0,len(result[i])):
                print(result[i][j],end="\t\t")
            print("")
    def fetchStudent(self,roll):
        cursor=self.db.cursor()
        sql="select * from student where rollnor="+str(roll)
        cursor.execute(sql)
        result=cursor.fetchall()
        if(len(result)==0):
            print("The student record not found")
        else:
            
            print("the student record found")
            print("Rollnor","Name","percenatge",sep="\t\t")
            for i in range(0,len(result)):
                for j in range(0,len(result[i])):
                    print(result[i][j],end="\t\t")
                print("") 
    def deleteStudent(self,roll):
        cursor=self.db.cursor()
        sql="select * from student where rollnor="+str(roll)
        cursor.execute(sql)
        result=cursor.fetchall()
        if(len(result)==0):
            print("The student record not found")
        else:
            print("the student record found")
            print("Rollnor","Name","percenatge",sep="\t\t")
            for i in range(0,len(result)):
                for j in range(0,len(result[i])):
                    print(result[i][j],end="\t\t")
                print("") 
            sql="delete from student where rollnor="+str(roll)
            cursor.execute(sql)
            self.db.commit()
            print("The student record deleted succesfully")
    def updateStudent(self,roll,s):
        cursor=self.db.cursor()
        sql="select * from student where rollnor="+str(roll)
        cursor.execute(sql)
        result=cursor.fetchall()
        if(len(result)==0):
            print("The student record not found")
        else:
            print("the student record found before modification")
            print("Rollnor","Name","percenatge",sep="\t\t")
            for i in range(0,len(result)):
                for j in range(0,len(result[i])):
                    print(result[i][j],end="\t\t")
                print("") 
            print("enter the modified name and percentage")
            sql="update student set name='"+input()+"',per="+str(float(input()))+"where rollnor="+str(roll)
            cursor.execute(sql)
            self.db.commit()
            print("The student record modified  succesfully")
    def close(self):
        self.db.close()
        
            
d=database()
s=students()
while True:
    ch=int(input("enter the choice\n1:add student\n2:displayall\n3:search student\n4:delete student\n5:update student\n6:exit\n"))
    if ch==1:
        s.readstudent()
        d.addStudent(s)
    elif ch==2:
        d.displayall()
    elif ch==3:
        ch1=int(input("enter the rollnor to searchhed\n"))
        d.fetchStudent(ch1)
    elif ch==4:
        ch1=int(input("enter the rollnor to deleted\n"))
        d.deleteStudent(ch1)
    elif ch==5:
        ch1=int(input("enter the rollnor to searchhed\n"))
        d.updateStudent(ch1,s)
    else:
        break;
d.close()'''

 
'''import socket # for socket
import sys 

try:
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print ("Socket successfully created")
except socket.error as err:
    print ("socket creation failed with error %s" %(err))

# default port for socket
port = 80

try:
    host_ip = socket.gethostbyname('www.google.com')
except socket.gaierror:
    # this means could not resolve the host
    print ("there was an error resolving the host")
    sys.exit()

# connecting to the server
s.connect((host_ip,port))

print ("the socket has successfully connected to google \
on port == %s" %(host_ip))'''
'''import tkinter as t
from tkinter import messagebox
def okclicked():
    messagebox.showinfo("window","u clicked on ok")
win=t.Tk()
win.geometry('500x200')
win.title("window")
okbtn=t.Button(win,text="OK",command=okclicked)
okbtn.place(x=50,y=50,width=50,height=40)
win.mainloop()'''


'''def minion_game(n):
    s=list(n)
    vowels=['A','E','I','O','U']
    list1=[]
    list2=[]
    list3=[]
    list4=[]
    score1=0
    score2=0
    for i in s:
        if i in vowels:
            list1.append(i)
        else:
            list2.append(i)
    for j in s:
        if j in list2:
            if j not in list3:
                c=n.count(j)
                score1=score1+c
                prev=j
                list3.append(prev)
                b=s.index(j)
                for f in range(b,(len(s)-1)):
                    prev=prev+s[f+1]
                    if prev not in list3:
                        c=n.count(prev)
                        score1=score1+c
                        list3.append(prev)
        else:
            if j not in list3:
                c=n.count(j)
                score2=score2+c
                prev=j
                list3.append(prev)
                b=s.index(j)
                for f in range(b,(len(s)-1)):
                    prev=prev+s[f+1]
                    if prev not in list3:
                        c=n.count(prev)
                        score2=score2+c
                        list3.append(prev)
                    
                    

     if score1>score2:
        print("Stuart "+str(score1))
    else:
        print("Kevin "+str(score2))
        
            
  
    

if __name__ == '__main__':
    s = input()
    minion_game(s)
           '''

'''def minion_game(string):
    s=len(string)
    vowels=['A','E','I','O','U']
    score1=0
    score2=0
    list3=[]
    for i in range(0,s):
        prev=string[i]
        list3.append(prev)
        if prev in vowels:
            score2=score2+1
        else:
            score1=score1+1
        for j in range(i+1,s):
            prev=prev+string[j]
            list3.append(prev)
            if prev[0] in vowels:
                score2=score2+1
            else:
                score1=score1+1
    print(list3)
    if score1>score2:
        print("Stuart "+str(score1))
    elif score2>score1:
        print("Kevin "+str(score2))
    else:
        print("Draw")'''
       


#s = input("\n")
#minion_game(s)
        
def printMax(list1,n):
    s=((len(list1)+1)-n)
    for i in range(0,s):
        list2=list1[i:i+n]
        print(max(list2))
       
        
print("enter the list")
list1=eval(input("\n"))
print("enter the number" )
n=int(input("\n"))
printMax(list1,n)

        
                    
 netifaces.interfaces()               netifaces.ifaddresses('lo')
 netifaces.ifaddresses('enp2s0')
 
 
 
 netifaces.ifaddresses('wlo1')
 
 netifaces.ifaddresses('enp2so')
 netifaces.ifaddresses('wlo1')[netifaces.AF_LINK]
 netifaces.ifaddresses('wlo1')[AF_INET]
 
 netifaces.ifaddresses('wlo1')[netifaces.AF_INET]