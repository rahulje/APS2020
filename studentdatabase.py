import pymysql
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
d.close()

   
                    
                
