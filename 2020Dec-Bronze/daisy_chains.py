s = input()
N = int(s)

list_entry = input()
entry = list_entry.split()
for i in range(N):
    entry[i] = int(entry[i])

K = 0
num = 0
while(K < N):
    K += 1
    s = []
    for i in range(N-K+1):
        sub = entry[i:i+K]
        avg = sum(sub)/len(sub)
        if avg in sub:
            num+=1
print(num)