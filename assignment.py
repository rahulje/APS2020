#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 22 09:59:51 2020

@author: rahul
"""
import sys
def Path(lst,n):
    lst1=[]
    for i in range(0,2**n):
        if i==0:
            lst1.append(0)
        else:
            lst1.append(sys.maxsize)
    for i in range(0,2**n):	
        s=bin(i)[2:].zfill(n)
        #print(s)
        #print(type(s))
        count=len(s)-1
        x=list(s).count('1')
        #print(x)
        for j in range(0,len(s)):
            if s[count]!='1':
                lst1[i|(1<<j)]=min(lst1[i|(1<<j)],(lst1[i]+lst[x][j]))
            count -= 1
    print(lst1[(2**n)-1])
n=int(input())
lst=[]
for i in range(0,n):
    lst1=[]
    for j in range(0,n):
        lst1.append(int(input()))
    lst.append(lst1)
Path(lst,n)