#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Mar 11 13:55:47 2020

@author: rahul
"""

#ra='nvg'
#data = (''.join(format(ord(x), 'b') for x in ra)) 
#print (data) 
#
#data=data+'000'
def xor(a,b):
    result=[]
    for i in range(0,len(b)):
        if a[i]==b[i]:
            result.append('0')
        else:
            result.append('1')
    return(''.join(result))
def check(temp):
   for i in range(0,len(temp)):
       if temp[i]=='1':
           return(len(temp[i:]))
   return 0
def remainder(data,key):
    pick=len(key)
    temp=data[0:pick]
    temp=xor(key,temp)
    i=pick
    while(i<len(data)):
        r=check(temp)
        print(temp)
        if r==3:
            temp=temp[1:]
            temp=temp+data[i]
            i += 1
            #print(temp)
            temp=xor(key,temp)
            
        elif r>=1 and r<3:
            temp=temp[(pick-r):]
            for h in range(0,(pick-r)):
                temp=temp+data[i]
                i += 1
            #print(temp)
            temp=xor(key,temp)
        else:
            temp=data[i:(i+4)]
            i += 4
            temp=xor(key,temp)
    print(temp)
remainder('100010110101101001110000','1001')        
                

