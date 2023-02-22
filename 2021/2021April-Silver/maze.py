betty = 0
def read(string):
    if string == "###":
        return -1
    else:
        if (string == "..."):
            return 0
        else:
            if (string[0]=='B'):
                return 1000
            if (string[0]=='M'):
                return 100 + int(string[1]+string[2])
            else:
                return int(string[1]+string[2])    

def printboard():
    for a in range(N):
        for b in range(N):
            print(board[a][b],end=' ')
        print()

class special:
    def __init__(self,x=0,y=0,val=0,index=0):
        self.x=x
        self.y=y
        self.val = val
        self.index=index

def search(x,y,visited):
    visited.append(check(x,y+1,visited))
    visited.append(check(x,y-1,visited))
    visited.append(check(x-1,y,visited))
    visited.append(check(x+1,y,visited))
    return visited


def check(a,b,visited):
    if (board[a][b]==0 and ([a,b] not in visited )):
        visited.append([a,b])
        search(a,b,visited)
    elif (board[a][b]>0):
        return board[a][b]


squad = []
index=1
N = int(input())
board = [[0 for i in range(N)] for j in range(N)]

for a in range(N):
    s = input()
    
    for b in range(N):
        x = read(s[3*b:3*b+3])
        board[a][b] = x

        if(x>0):
            board[a][b]=index
            
            spec = special(a,b,x,index)
            squad.append(spec)
            if (x==1000):
                betty = index
            index+=1



graph = {}
for spec in squad:
    visited = []
    search(spec.x,spec.y,visited)
    reachable = []
    for elem in visited:
        try:
            elem+=1
            elem-=1
            if (elem not in reachable) and (elem != spec.index):                
                reachable.append(elem)
        except TypeError:
            pass
    graph[spec.index]=reachable
print(graph)

count = 0

M=1.0201
O=1.03
yay = M+2*O
def moo(visited):
    tt = [[-1 for i in range(3)]for j in range(3)]
    for elem in visited:
        x = squad[elem-1].val
        #print(x)
        if (x!=1000):
            if x>100:
                x-=100
                d = x%10
                x = (x-d)//10
                if (tt[x-1][d-1]==-1):
                    tt[x-1][d-1]=M
                else:
                    return False
            else: 
                d = x%10
                x = (x-d)//10
                if (tt[x-1][d-1]==-1):
                    tt[x-1][d-1]=1.03
                else:
                    return False
    for r in range(3):
        sum_3 = tt[r][0]+tt[r][1]+tt[r][2]
        if (sum_3==yay):
            return True
    for c in range(3):
        sum_3 = tt[0][c]+tt[1][c]+tt[2][c]
        if (sum_3==yay):
            return True
    if((tt[0][0]+tt[1][1]+tt[2][2])==yay or (tt[0][2]+tt[1][1]+tt[2][0])==yay):
        return True
    return False
def Union(lst1, lst2):
    final_list = list(set(lst1) | set(lst2))
    return final_list

def search(graph,node,used=[]):
    global count
    print(used)

    if moo(used):
        count+=1
        print(used)

    available = []
    for root in used:
        available = Union(available,graph[root])


    for neighbor in available:
        if neighbor not in used:
            used.append(neighbor)
            search(graph,neighbor,used)
            used.remove(neighbor)




# Driver Code

search(graph, betty, [betty])

print("count:"+str(count))

printboard()