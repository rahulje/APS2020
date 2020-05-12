
class student:
    def readstudent(self,filename):
        fh=open(filename,'a')
        self.rollnor=int(input("enter the rollnor of student\n"))
        self.name=input("enter the name of the student\n")
        self.branch=input("enter the branch of the student\n")
        self.age=int(input("enter the age of the student\n"))
        st=str(self.rollnor)+"|"+self.name+"|"+self.branch+"|"+str(self.age)+"\n"
        print(self.rollnor,file=fh)
        fh.write(st)
        fh.close()
    def displaystudent(self,filename):
        fh=open(filename,"r")
        for ln in fh:
            st=ln.split("|")
            print(st[0],st[1],st[2],sep="\n")
        fh.close()
def main():
    filename="rahul.txt"
    s=student();
    while True:
        ch=int(input(""))
        if ch==1:
            s.readstudent(filename)
        elif ch==2:
            s.displaystudent(filename)
        else:
            break
main()
        
        