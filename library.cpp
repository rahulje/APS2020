#include<stdio.h>
#include<iostream>
#include<fstream>
using namespace std;
#include<string>
class library;
struct date
{
    int day;
    int mm;
    int year;
    public:
        void increment();
        friend class library;
        friend void update(int);
};
void date::increment()
{
    day++;
    if((mm==2)&&(year%4!=0)&&(day==29))
        {
            day=1;
            mm++;
        }
    else if((mm==4||mm==6||mm==9||mm==11)&&(day==31))
    {
        day=1;
        mm++;
    }
    else if(day==32)
    {
        day=1;
        mm++;
        if(mm==13)
        {
            mm=1;
            year++;
        }
    }
}
class student
{
    string name,usn,contact;
    int m1,m2,total,rollnor,issue=0;
    float per;
    public:
        void read()
        {
            ofstream fout("student.txt",ios::app);
            cout<<"\nenter the student detail\n****name,roll nor,usn,m1,m2,contact number\n";
            cin>>name>>rollnor>>usn>>m1>>m2>>contact;
            total=m1+m2;
            per=total/2.0f;
            fout<<endl<<name<<"   "<<rollnor<<"   "<<usn<<"   "<<m1<<"   "<<m2<<"   "<<total<<"   "<<per<<"   "<<contact<<"   "<<issue;
            fout.close();
        }
        void display()
        {
            ifstream fin("student.txt");
            while(!fin.eof())
            {
                fin>>name>>rollnor>>usn>>m1>>m2>>total>>per>>contact;
                cout<<endl<<"student name:"<<name<<" "<<"roll nor:"<<rollnor<<" "<<"usn:"<<usn<<" "<<"marks1:"<<m1<<" "<<"marks2:"<<m2<<" "<<"total:"<<total<<" "<<"percentage:"<<per<<" "<<"contact number:"<<contact<<" "<<"number of book issued:"<<issue;

            }
            fin.close();

        }
        int search1(int key);
        void modify(int key);
        void update(int key);
        int check(int n)
        {
            ifstream fin("student.txt");
            int flag=0;
            while(!fin.eof())
            {
                fin>>name>>rollnor>>usn>>m1>>m2>>total>>per>>contact>>issue;
                if(rollnor==n)
                {
                    if(issue==0)
                    {
                        fin.close();
                        return 1;
                    }
                    else
                    {
                        fin.close();
                        return 0;
                    }
                }
            }
        }

};
int student::search1(int key)
{
    ifstream fin("student.txt");
    int flag=0;
    while(!fin.eof())
    {
        fin>>name>>rollnor>>usn>>m1>>m2>>total>>per>>contact>>issue;
        if(rollnor==key)
        {
            flag=1;
            cout<<"record found\n";
            cout<<endl<<"student name:"<<name<<" "<<"roll nor:"<<rollnor<<" "<<"usn:"<<usn<<" "<<"marks1:"<<m1<<" "<<"marks2:"<<m2<<" "<<"total:"<<total<<" "<<"percentage:"<<per<<" "<<"contact number:"<<contact<<" "<<"number of book issued:"<<issue;
            return 1;
        }

    }
    fin.close();
    if(flag==0)
    {
        return 0;
    }
}
void student::update(int key)
{
    ifstream fin("student.txt");
    ofstream fout("temp.txt");
    int flag=0;
    while(!fin.eof())
    {
        fin>>name>>rollnor>>usn>>m1>>m2>>total>>per>>contact>>issue;
        if(rollnor==key)
        {
            flag=1;
            issue--;
        }
        fout<<endl<<name<<"   "<<rollnor<<"   "<<usn<<"   "<<m1<<"   "<<m2<<"   "<<total<<"   "<<per<<"   "<<contact<<"   "<<issue;
    }
    fout.close();
    fin.close();
    if(flag==0)
    {
        cout<<"record not found:\n";
    }
    else
    {
        remove("student.txt");
        rename("temp.txt","student.txt");
    }
}

void student::modify(int key)
{
    ifstream fin("student.txt");
    ofstream fout("temp.txt");
    int flag=0;
    while(!fin.eof())
    {
        fin>>name>>rollnor>>usn>>m1>>m2>>total>>per>>contact>>issue;
        if(rollnor==key)
        {
            flag=1;
            issue++;
        }
        fout<<endl<<name<<"   "<<rollnor<<"   "<<usn<<"   "<<m1<<"   "<<m2<<"   "<<total<<"   "<<per<<"   "<<contact<<"   "<<issue;
    }
    fout.close();
    fin.close();
    if(flag==0)
    {
        cout<<"record not found:\n";
    }
    else
    {
        remove("student.txt");
        rename("temp.txt","student.txt");
    }
}
class book
{
    int bookid;
    string name,pub,aut;
    int nop,price,issue=0;
    public:
    void read()
    {
        ofstream fout("book.txt",ios::app);
        cout<<"enter the book details \nbook id,name,publisher,author,no of pages,price\n";
        cin>>bookid>>name>>pub>>aut>>nop>>price;
        fout<<endl<<bookid<<"   "<<name<<"   "<<pub<<"   "<<aut<<"   "<<nop<<"   "<<price<<"   "<<issue;
        fout.close();
    }
    void display()
    {
        ifstream fin("book.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price;
            cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price<<"\nissue:"<<issue;
        }
        fin.close();
    }
    int search1(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        while(!fin.eof())
        {
             fin>>bookid>>name>>pub>>aut>>nop>>price>>issue;
             if(bookid==key)
             {
                flag=1;
                cout<<"record found\n:";
                cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price<<"\nissue:"<<issue;
                return 1;
             }
        }
        fin.close();
        if(flag==0)
            return 0;
    }

    void update(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        ofstream fout("tmp.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price>>issue;
             if(bookid==key)
             {
                flag=1;
                issue--;
             }
             fout<<endl<<bookid<<"   "<<name<<"   "<<pub<<"   "<<aut<<"   "<<nop<<"   "<<price<<"   "<<issue;

        }
        fin.close();
        fout.close();
        if(flag==0)
            cout<<"record not found\n";
        else
        {
            remove("book.txt");
            rename("tmp.txt","book.txt");
        }
    }
    void modify(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        ofstream fout("tmp.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price>>issue;
             if(bookid==key)
             {
                flag=1;
                issue++;
             }
             fout<<endl<<bookid<<"   "<<name<<"   "<<pub<<"   "<<aut<<"   "<<nop<<"   "<<price<<"   "<<issue;

        }
        fin.close();
        fout.close();
        if(flag==0)
            cout<<"record not found\n";
        else
        {
            remove("book.txt");
            rename("tmp.txt","book.txt");
        }
    }
    int check(int n)
    {
        ifstream fin("book.txt");
        while(!fin.eof())
        {
             fin>>bookid>>name>>pub>>aut>>nop>>price>>issue;
             if(bookid==n)
             {
                if(issue==0)
                {
                    fin.close();
                    return 1;
                }
                else
                {
                    fin.close();
                    return 0;
                }
             }
        }

    }

};
class library
{
    student s;
    book b;
    public:
        void issue();
        void return1();
};
void library::issue()
{
    int x,y,i=0;
    date d1,d2;
    char temp;
    cout<<"\nenter the student roll nor\n";
    cin>>x;
  if(x>0)
  {
    if(s.search1(x))
    {
        if(s.check(x))
        {
            cout<<"\nenter the book id you want to take from library \n";
            cin>>y;
            if(b.search1(y))
            {
                if(b.check(y))
                {
                    cout<<"\nenter the today date\n";
                    cin>>d1.day>>temp>>d1.mm>>temp>>d1.year;
                    d2=d1;
                    while(i!=16)
                    {
                        d2.increment();
                        i++;
                    }
                    ofstream fout("library.txt",ios::app);
                    fout<<endl<<x<<"   "<<y<<"   "<<d2.day<<" "<<d2.mm<<" "<<d2.year<<"   "<<d1.day<<" "<<d1.mm<<" "<<d1.year;
                    s.modify(x);
                    b.modify(y);
                    cout<<"\nbook issued by student whose roll nor is:"<<x;
                    cout<<"\nbook issued successfully\n";
                    cout<<"\nlast date to return book is:\n";
                    cout<<d2.day<<"-"<<d2.mm<<"-"<<d2.year;
                    fout.close();
                }
                else
                {
                    cout<<"\nbook is already taken by others student\n";
                }
            }
            else
            {
                cout<<"\nbook record not found\n";
            }
        }
        else
        {
            cout<<"\nu have already took a book from library\n";
        }
    }

    else
    {
        cout<<"\nstudent record not found\n";
    }
  }
  else
  {
        cout<<"\ninvalid roll nor\n";
  }
}
void update(int x)
{
    int z,y;
    date d1,d2;
    int flag=0;
    ifstream fin("library.txt");
    ofstream fout("tmp1.txt");
    while(!fin.eof())
    {
            fin>>z>>y>>d1.day>>d1.mm>>d1.year>>d2.day>>d2.mm>>d2.year;
            if(z==x)
            {
                flag=1;
            }
            else
            {
                fout<<endl<<z<<"    "<<y<<"    "<<d1.day<<" "<<d1.mm<<" "<<d1.year<<"    "<<d2.day<<" "<<d2.mm<<" "<<d2.year;

            }
    }
    fin.close();
    fout.close();
    if(flag==1)
    {
        remove("library.txt");
        rename("tmp1.txt","library.txt");
    }
}
int search2(int x,int y)
{
    int a,b;
    int flag=0;
    ifstream fin("library.txt");
    while(!fin.eof())
    {
        fin>>a>>b;
        if((a==x)&&(b==y))
        {
            fin.close();
            return(1);
        }
    }
    fin.close();
    if(flag==0)
    {
        return(0);
    }

}
void library::return1()
{
    int x,y,w,z;
    int flag=0;
    char temp;
    date d1,d2;
    cout<<"enter your roll nor\n";
    cin>>x;
  if(x>0)
  {
    if(s.search1(x))
    {
        if(!s.check(x))
        {
            cout<<"\nenter the book id that is to be returned\n";
            cin>>y;
            if(b.search1(y))
            {
                if(!b.check(y))
                {
                    if(search2(x,y))
                    {
                        cout<<"\nenter the todays date\n";
                        cin>>d1.day>>temp>>d1.mm>>temp>>d1.year;
                        ifstream fin("library.txt");
                        while(!fin.eof())
                        {
                            fin>>w>>z>>d2.day>>d2.mm>>d2.year;
                            if(x==w)
                            {
                                if(((d1.day<d2.day)||(d1.day>=d2.day))&&(d1.mm<=d2.mm)&&(d1.year<=d2.year))
                                {
                                    s.update(x);
                                    b.update(y);
                                    fin.close();
                                    update(x);
                                    cout<<"\nbook returned successfully on time\n";
                                    break;
                                }
                                else
                                {
                                    if((d1.day>d2.day)||(d1.day<d2.day)&&(d1.mm>=d2.mm)&&(d1.year>=d2.year))
                                    {
                                        while((d1.day!=d2.day)||d1.mm!=d2.mm||d1.year!=d2.year)
                                        {
                                             flag++;
                                            d2.increment();

                                        }
                                        cout<<"\nu have returned the book late by "<<flag<<" days\n";
                                        s.update(x);
                                        b.update(y);
                                        fin.close();
                                        update(x);
                                        break;
                                    }
                                }
                            }
                        }

                    }
                    else
                    {
                        cout<<"\nbook id is not match with your USN\n";
                    }

                }
                else
                {
                    cout<<"\nthe book has not issued yet\n";
                }

            }
            else
            {
                cout<<"\nbook record not found\n";
            }
        }
        else
        {
            cout<<"\nyou didn't took any book from library\n";
        }
    }
    else
    {
        cout<<"\nstudent record not found\n";
    }
  }
  else
  {
      cout<<"\ninvalid roll nor\n";
  }
}

int main()
{
     student s;
     book b;
     library l;
     int ch;
     do
     {
         cout<<"\n*****library management***\n";
         cout<<"\nenter the choice\n1:new student registration\n2:new book registration\n3:issue book\n4:return book\n5:exit\n";
         cin>>ch;
         switch(ch)
         {
            case 1:s.read();
            break;
            case 2:b.read();
            break;
            case 3:l.issue();
            break;
            case 4:l.return1();
            break;
         }
     }while(ch!=5);

}
