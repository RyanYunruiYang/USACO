cows = ['Beatrice','Belinda','Bella','Bessie','Betsy','Blue','Buttercup','Sue'] #07134526
 
with open("lineup.in","r") as f:
  N = int(f.readline())
  besides = [] 

  for i in range(N):
    line = f.readline().rstrip()
    x = line.split(" must be milked beside ")
    besides.append([cows.index(x[0]), cows.index(x[1])])

def toString(List): 
    return ''.join(List) 
 
def check(a, b):#a is a list, b is a 2d list of pairs
    for b_item in b:
        if not (abs(a.index(b_item[0]) - a.index(b_item[1])) == 1 ):
           return False
    return True


def permutation(lst, pre_list = []):
    if (len(lst) == 1):
        final = pre_list+lst
        if (check(final,besides)):
            o = open("lineup.out", "a")
            for i in range(n):
                o.write(cows[int(final[i])])
                o.write("\n")
            o.close()
            quit()
    else:
        for e in lst:
            remained_list = [item for item in lst if (item!= e)]

            permutation(remained_list, pre_list + [e])


n = 8
a = [i for i in range(n)]

permutation(a)


