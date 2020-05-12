#include<stdio.h>
#include<iostream>
using namespace std;
#include<fstream>
class book
{
    int bookid;
    string name,pub,aut;
    int nop,price;
    public:
    void read()
    {
        ofstream fout("book.txt",ios::app);
        cout<<"enter the book details \nbook id,name,publisher,author,no of pages,price\n";
        cin>>bookid>>name>>pub>>aut>>nop>>price;
        fout<<endl<<bookid<<" "<<name<<" "<<pub<<" "<<aut<<" "<<nop<<" "<<price;
        fout.close();
    }
    void display()
    {
        ifstream fin("book.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price;
            cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price;
        }
        fin.close();
    }
    void search1(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        while(!fin.eof())
        {
             fin>>bookid>>name>>pub>>aut>>nop>>price;
             if(bookid==key)
             {
                flag=1;
                cout<<"record found\n:";
                cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price;
                break;
             }
        }
        fin.close();
        if(flag==0)
            cout<<"record not found\n";
    }
    void modify(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        ofstream fout("tmp.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price;
             if(bookid==key)
             {
                flag=1;
                cout<<"record found\n:";
                cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price;
                cout<<"enter the book details \nbook id,name,publisher,author,no of pages,price\n";
                cin>>bookid>>name>>pub>>aut>>nop>>price;
             }
             fout<<endl<<bookid<<" "<<name<<" "<<pub<<" "<<aut<<" "<<nop<<" "<<price;

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
    void delete1(int key)
    {
        int flag=0;
        ifstream fin("book.txt");
        ofstream fout("tmp.txt");
        while(!fin.eof())
        {
            fin>>bookid>>name>>pub>>aut>>nop>>price;
             if(bookid==key)
             {
                flag=1;
                cout<<"record found\n:";
                cout<<"book id:"<<bookid<<"\nname:"<<name<<"\npublisher:"<<pub<<"\nauthor:"<<aut<<"\nnumber of pages:"<<nop<<"\nprice:"<<price;
             }
             else
             {
                fout<<endl<<bookid<<" "<<name<<" "<<pub<<" "<<aut<<" "<<nop<<" "<<price;
             }

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

};
int main()
{
    book b;
    int key;
    int ch;
    do
    {
        cout<<"\nenter the choice\n1:read\n2:search\n3:modify\n4:delete\n5:display\n6:exit\n";
        cin>>ch;
        switch(ch)
        {
            case 1:b.read();
            break;
            case 2:cout<<"enter the key to be searched\n";
                    cin>>key;
                    b.search1(key);
                    break;
            case 3:cout<<"enter the key to be modifyed\n";
                    cin>>key;
                    b.modify(key);
                    break;
            case 4:cout<<"enter the key to be deleted\n";
                    cin>>key;
                    b.delete1(key);
                    break;
            case 5:b.display();
            break;
        }
    }while(ch!=6);
}
