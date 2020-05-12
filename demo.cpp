#include<iostream>
using namespace std;
#include<string>
class customer;
class cashCard
{
    protected:
        int cvv;
        string CardNo;
        string CardType;
        int pin;
        int balance;

};
class debitCard:public cashCard
{
    public:
        debitCard()
        {
            cvv=231;
            CardNo="12345678907890";
            CardType="debit";
            pin=1234;
            balance=500;
        }
        void swipe()
        {
            int x;
            cout<<"enter the pin\n";
            cin>>x;
            if(x==pin)
            {
                cout<<"enter the amount to be payed\n";
                cin>>x;
                balance -=x;
                cout<<"updated balance is:"<<balance;
            }
            else
            {
                cout<<"inavlid pin\n";
            }
        }
        void changepin()
        {
            int x;
            cout<<"enter the prevoius pin id\n";
            cin>>x;
            if(x==pin)
            {
                cout<<"enter the new pin id\n";
                cin>>pin;
                cout<<"pin updated suceefully\n";
            }
            else
            {
                cout<<"pin invalid\n";
            }

        }
        friend class customer;

};
class creditCard:public cashCard
{
    public:
        creditCard()
        {
            cvv=231;
            CardNo="12345678";
            CardType="credit";
            pin=5678;
            balance=500;
        }
        void swipe()
        {
            int x;
            cout<<"enter the pin\n";
            cin>>x;
            if(x==pin)
            {
                cout<<"enter the amount to be payed\n";
                cin>>x;
                balance -=x;
                cout<<"updated balance is:"<<balance;
            }
            else
            {
                cout<<"inavlid pin\n";
            }
        }
        void changepin()
        {
            int x;
            cout<<"enter the prevoius pin id\n";
            cin>>x;
            if(x==pin)
            {
                cout<<"enter the new pin id\n";
                cin>>pin;
                cout<<"pin updated suceefully\n";
            }
            else
            {
                cout<<"pin invalid\n";
            }

        }
        friend class customer;
};
class customer
{
    string name;
    creditCard c;
    debitCard b;
    public:
        customer()
        {
            name="rahul";
        }
        void shop()
        {
            int ch;
            cout<<"enter the card type you want to pay \n1:credit\n2:debit\n";
            cin>>ch;
            if(ch==1)
            {
                c.swipe();
            }
            else
            {
                b.swipe();
            }
        }
        void changePin()
        {
            int ch;
            cout<<"enter the card type you want to change pin \n1:credit\n2:debit\n";
            cin>>ch;
            if(ch==1)
            {
                c.changepin();
            }
            else
            {
                b.changepin();
            }
        }
        void printcard()
        {
            int ch;
            cout<<"enter the card type you want to display pin \n1:credit\n2:debit\n";
            cin>>ch;
            if(ch==1)
            {
                int x;
                cout<<"enter the pin\n";
                cin>>x;
                if(x==c.pin)
                {
                    cout<<"cvv:"<<c.cvv<<"\ncardno:"<<c.CardNo<<"\ncardType:"<<c.CardType<<"\nbalance:"<<c.balance<<"\npin:"<<c.pin;
                }
                else
                {
                    cout<<"invalid pin\n";
                }
            }
            else
            {
                int x;
                cout<<"enter the pin\n";
                cin>>x;
                if(x==b.pin)
                {
                    cout<<"cvv:"<<b.cvv<<"\ncardno:"<<b.CardNo<<"\ncardType:"<<b.CardType<<"\nbalance:"<<b.balance<<"\npin:"<<b.pin;
                }
                else
                {
                    cout<<"invalid pin\n";
                }
            }
        }


};
int main()
{
   int ch;
   customer c;
   c.shop();
   c.changePin();
   c.printcard();
}
