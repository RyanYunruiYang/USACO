n = int(input())

L = []
G = []

for j in range(n):
	s = input()
	print(s.split())
	if(s[0] == "G"):
		G.append(int(s.split()[1]))
	else:
		L.append(int(s.split()[1]))

	G.sort()
	L.sort()

	print(G)
	print(L)


	minliars = min(len(G),len(L)) #-infty or infty cases

	lindex = 0
	for i in range(len(G)):
		while(lindex<len(L) and L[lindex]<G[i]):
			lindex+=1

		x = (lindex-1) + i

		if(x<minliars):
			minliars = x

	print(minliars)

