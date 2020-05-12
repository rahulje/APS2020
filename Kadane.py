#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Mar  3 19:50:00 2020

@author: rahul
"""

'''lis=eval(input())
lis1=[]
for i in range(0,len(lis)*4):
    lis1.append(0)
def segement(lis,v,l,r):
    if(l==r):
        lis1[v]=lis[l]
    else:
        mid=(l+r)//2
        segement(lis,v*2,l,mid)
        segement(lis,v*2+1,mid+1,r)
        lis1[v]=lis1[v*2]+lis1[v*2+1]
segement(lis,1,0,len(lis)-1)
print(lis1)'''

import sys
def kadane(lis,n):
    Max=-sys.maxsize-1
    t=0
    st=0
    ed=0
    s=0
    for i in range(0,n):
        t=t+lis[i]
        if Max<t:
            Max=t;
            st=s
            ed=i
        if t<0:
            t=0
            s=i+1
    return Max,st,ed
Max1=-999999999
left=-1
right=-1
h=-1
c=-1
for i in range(0,n):
    lis=[0 for c in range(0,n)]
    for j in range(0,m):
        for s in range(0,n):
            lis[s] += lis1[s][j]
        Max,st,ed=kadane(lis,len(lis))
        if Max>Max1:
            Max1=Max
            left=i
            right=j
            h=st
            c=ed

    
        
        
    