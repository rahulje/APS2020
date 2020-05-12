#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
#include<string>
class Person
{
    string name;
    int age;
    public:
        virtual void getdata()
        {
            cin>>name>>age;
        }
        virtual void putdata()
        {
            cout<<name<<" "<<age;
        }
};
class Professor:public Person
{
    int publications,cur_id;
    static int count1;
    public:
    Professor()
    {
        count1++;
        cur_id=count1;
    }
    void getdata()
    {
        Person::getdata();
        cin>>publications;
    }
    void putdata()
    {
        Person::putdata();
        cout<<" "<<publications<<" "<<cur_id<<endl;
    }
};
class Student:public Person
{
    static int count2;
    int cur_id;
    int marks[6];
    public:
        Student()
        {
            count2++;
            cur_id=count2;
        }
        void getdata()
        {
            Person::getdata();
            for(int i=0;i<6;i++)
            {
                cin>>marks[i];
            }
        }
        void putdata()
        {
            Person::putdata();
            int sum=0;
            for(int i=0;i<6;i++)
            {
                sum=sum+marks[i];
            }
            cout<<" "<<sum<<" "<<cur_id<<endl;
        }
};
int Professor::count1=0;
int Student::count2=0;
int main(){
