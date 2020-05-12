#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 22 09:55:39 2020

@author: rahul
"""

import sys
n=int(input())
for i in range(0,n):
    n1,d=tuple([int(x) for x in input().split(' ')])
    lis=[int(x) for x in input().split(' ')]
    lis2=[]
    f=d
    count=0
    for j in range(0,len(lis)):
        if(lis[j]>d):
            lis2.append(-sys.maxsize)
        else:
            lis2.append(d-lis[j])
    min1=max(lis2)
    while(d>(f-min1)):
        count += 1
        lis2.remove(min1)
        d=d-(f-min1)
        min1=max(lis2)
    print(count)