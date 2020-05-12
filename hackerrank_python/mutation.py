def mutate_string(string, position, character):
    s=string[0:position]
    c=s+character
    a=c+string[position+1:len(string)]
    return a

if __name__ == '__main__':
    s = input()
    i, c = input().split()
    s_new = mutate_string(s, int(i), c)
    print(s_new)
