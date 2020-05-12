#include<iostream>
#include<array>
#include<string>
using namespace std;
class studentarray;
class student
{
    private:
        int rollnor;
        string name;
        int m1,m2,total;
    public:
        void read();
        void display();
        friend class studentarray;

};
void student::read()
{
    cout<<"\nenter the student details\n";
    cin>>rollnor>>name>>m1>>m2;
    total=m1+m2;
}
void student::display()
{
    cout<<"\nrollnor:"<<rollnor<<"\nname:"<<name<<"\nmarks1:"<<m1<<"\nmarks2:"<<m2<<"\ntotal:"<<total;
}

class studentarray
{
    private:
        student s[100];
    public:
        void readstudent(int n)
        {
            for(int i=0;i<n;i++)
            {
                s[i].read();
            }
        }
        void displaystudent(int n)
        {
            for(int i=0;i<n;i++)
            {
                s[i].display();
            }
        }
        void searchstudent(int n);
        int deletestudent(int n);
        void modifystudent(int n);
};
void studentarray::searchstudent(int n)
{
    int key;
    int flag=0;
    cout<<"enter the rollnor to be searched\n";
    cin>>key;
    for(int i=0;i<n;i++)
    {
        if(s[i].rollnor==key)
        {
            flag=1;
            cout<<"student found\n";
            s[i].display();
            break;
        }
    }
    if(flag==0)
        cout<<"student rollnor not found\n";
}
void studentarray::modifystudent(int n)
{
    int key;
    int flag=0;
    cout<<"enter the rollnor to be modified\n";
    cin>>key;
    for(int i=0;i<n;i++)
    {
        if(s[i].rollnor==key)
        {
            flag=1;
            cout<<"student found and his prevoius detail is\n";
            s[i].display();
            cout<<"enter the new details of the student\n";
            s[i].read();
            break;
        }
    }
    if(flag==0)
        cout<<"student rollnor not found\n";
}
int studentarray::deletestudent(int n)
{
    int key;
    int flag=0;
    cout<<"enter the rollnor to be deleted\n";
    cin>>key;
    for(int i=0;i<n;i++)
    {
        if(s[i].rollnor==key)
        {
            flag=1;
            cout<<"student found\n";
            s[i].display();
            for(int j=i;j<(n-1);j++)
            {
                s[j]=s[j+1];
            }
            n--;
            break;
        }
    }
    if(flag==0)
        cout<<"student rollnor not found\n";
    else
    {
        return(n);
    }
}
int main()
{
    int ch;
    int n;
    cout<<"enter the size of the array\n";
    cin>>n;
    studentarray s;
    s.readstudent(n);
    do
    {
        cout<<"\nenter the choice\n1:search\n2:modify\n3:delete\n4:display all\n5:exit\n";
        cin>>ch;
        switch(ch)
        {
            case 1:s.searchstudent(n);
            break;
            case 2:s.modifystudent(n);
            break;
            case 3:n=s.deletestudent(n);
            break;
            case 4:s.displaystudent(n);
            break;
            case 5:break;
        }
    }while(ch!=5);
}
