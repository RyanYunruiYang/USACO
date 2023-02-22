s = input()
N = int(s)

indexes = [0 for x in range(N)]
for _ in range(N-1):
	x = input()
	coords = x.split()
	coords[0] = int(coords[0])
	coords[1] = int(coords[1])

	indexes[coords[0]-1]+=1
	indexes[coords[1]-1]+=1
indexes[0]+=1

days = N-1
for i in range(N):
	deg = indexes[i]
	k = 0
	while(2**k < deg):
		k+=1
	days += k
print(days)