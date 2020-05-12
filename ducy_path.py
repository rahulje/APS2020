def Path(b):
	flag=0
	for i in range(0,b):	
		s=bin(i)[2:].zfill(2*n)
		count1=0
		count2=0
		if s[0]=='0' and s[len(s)-1]=='1':
			if s.count('1')==s.count('0'):	
				for j in range(0,len(s)):
					if s[j]=='0':
						count1 += 1;
					elif s[j]=='1':
						count2 += 1;
						if(count2>count1 and count2!=count1):
							flag=1
							break
				if flag==0:
					s=s.replace('0','X')
					s=s.replace('1','Y')
					flag=0
					print(tuple(s))
				else:
					flag=0
n=eval(input())
b=(2**(2*n))
Path(b)
