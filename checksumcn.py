#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 14 22:48:32 2020

@author: rahul
"""

import socket                

def beforeAppend(x):
    d=8-len(x)
    for i in range(0,d):
        x='0'+x
    return x
    
    
def complment(lis):
    b1=''
    for k in range(0,len(lis)):
            if lis[k]=='1':
                b1=b1+'0'
            else:
                b1=b1+'1'
    return b1

def computechecksum(n):
    lis=[]
    if(len(n)%8==0):
        j=0
        for i in range(0,len(n)//8):
            lis.append('0b'+n[j:j+8])
            j=j+8
            print(lis)
            sum1=0
        for i in range(0,len(lis)):
            print(int(lis[i],2))
            sum1=sum1+int(lis[i],2)
        b=bin(sum1)
        b=b[2:]
        print(b)
        if((len(b))==8):
            return b
        else:
            sum2=0
            s=len(b)%8
            n1='0b'+b[s:]
            n2='0b'+b[:s]
            print(n1,n2)
            sum2=sum2+int(n1,2)+int(n2,2)
            print(int(n1,2),int(n2,2))
            print(sum2)
            b=bin(sum2)[2:]
            print(b)
            if len(b)<8:
                b= beforeAppend(b)
            return(b)
s = socket.socket()          
port = 12345                
s.bind(('', port))  
s.listen(5)      
while True:  
   c, addr = s.accept()        
   n1=c.recv(1024).decode()
   checksum=c.recv(1024).decode()
   n= (''.join(format(ord(x), 'b') for x in n1)) 
   b=''
   if(len(n)%8==0):
    	b=computechecksum(n)
    	
   else:
    d=(len(n)%8)
    d=8-d
    for i in range(0,d):
        n=n+'0'
    b=computechecksum(n)
    b='0b'+b
    checksum='0b'+checksum
    s=int(b,2)+int(checksum,2)
    s=bin(s)[2:]
    s=complment(s)
    s='0b'+s
    s=int(s,2)
    if s==0:
    	print("No error occured");
    else:
    	print("Error occured")
    c.close() 
         
        
        
        
            
    
    