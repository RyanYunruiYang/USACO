# 12345
# 32145
# 23145
# 21345
# 24315

# For each cow:
# 	keep track of where it starts the set
# 	run through the moves
# 	check it’s position in between sets
# 	
s = input()
entry = s.split()
N = int(entry[0])
K = int(entry[1])
swaps = []
for i in range(K):
	x = input()
	entry = x.split()
	entry[0] = int(entry[0])
	entry[1] = int(entry[1])	

	swaps.append(entry)

# for x in swaps:
# 	print(x)

for c in range(1,N+1):
	starts_at = c
	pos = starts_at
	visited=[0 for x in range(N+1)]
	visited[c]=1
	not_first = True
	while (c != starts_at or not_first):
		# print('entered')
		not_first = False
		for entry in swaps:
			if entry[0] == pos:
				pos = entry[1]
				visited[pos] +=1
			elif entry[1] == pos:
				pos = entry[0]
				visited[pos] +=1

		starts_at = pos
	x = 0
	for i in range(1,N+1):
		if visited[i]!= 0:
			x+=1
	print(x)




