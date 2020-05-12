
#include<iostream>
#include<string>
using namespace std;
class student
{

    int rollnor;
    string name;
    int m1,m2,total;
  public:
    void setrollnor(int nor)
    {
        if(nor<0)
        {
            cout<<"invalid rollnor\n";
                return;
        }
        rollnor=nor;
    }
    void setname(string nm)
    {
        name=nm;
    }
    void setmarks1(int m1)
    {
        if(m1<0)
        {
            cout<<"invalid marks\n";
                return;
        }
        this->m1=m1;
        total=m1+m2;
    }
    void setmarks2(int m)
    {
        if(m<0)
        {
            cout<<"invalid marks\n";
                return;
        }
        this->m2=m;
        total=m1+m2;
    }
    void getrollnor()
    {
        cout<<"rollnor:"<<rollnor;
    }
    void getname()
    {
        cout<<"name:"<<name;
    }
    void getmarks1()
    {
        cout<<"marks1:"<<m1;
    }
    void getmarks2()
    {
        cout<<"marks2:"<<m2;
    }
    void gettotal()
    {
        cout<<"total:"<<total;
    }
    void readwholestudent()
    {
        cout<<"enter the student detail\n";
        cin>>rollnor>>name>>m1>>m2;
        total=m1+m2;
    }
    void displaywholestudent()
    {
        cout<<"rollnor:"<<rollnor<<endl<<"name:"<<name<<endl<<"marks1:"<<m1<<endl<<"marks2:"<<m2<<endl<<"total:"<<total;
    }



};
int main()
{
    student s;
    int ch,m1;
    string nm;
    do
    {
        cout<<"\n***********MENU***********\n";
        cout<<"1:setonlyrollnor\n2:setonlyname\n3:setonlymarks1\n4:setonlymarks2\n5:getrollnor\n6:getname\n7:getmarks1\n8:getmarks2\n9:gettotal\n10:readwholestudent\n11:displaywholestudent\n";
        cin>>ch;
        switch(ch)
        {
        case 1:int rno;
               cout<<"entre the rollnor"<<endl;
               cin>>rno;
               s.setrollnor(rno);
               break;
        case 2:
               cout<<"enter the name:"<<endl;
               cin>>nm;
               s.setname(nm);
               break;
        case 3:
               cout<<"enter the marks1:"<<endl;
               cin>>m1;
               s.setmarks1(m1);
               break;
        case 4:cout<<"enter the marsk2:"<<endl;
               cin>>m1;
               s.setmarks2(m1);
               break;
        case 5:s.getrollnor();
               break;
        case 6:s.getname();
               break;
        case 7:s.getmarks1();
                break;
        case 8:s.getmarks2();
               break;
        case 9:s.gettotal();
               break;
        case 10:s.readwholestudent();
                break;
        case 11:s.displaywholestudent();
                break;
        }
    }while(ch!=12);

}
