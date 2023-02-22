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

paths = [[i] for i in range(N)]
pointer = [i for i in range(N)] #pointer[i] is the name of the cow currently at pos i



for i in range(K):
	x = input()
	entry = x.split()
	a = int(entry[0])-1
	b = int(entry[1])-1



	paths[pointer[b]].append(a)
	paths[pointer[a]].append(b)


	pointer[b],pointer[a]=pointer[a], pointer[b]	
#	print("pointer", pointer)

saved_values = [-1 for x in range(N)]
evaluated = [False for x in range(N)]
for c in range(N):
	if not evaluated[c]:
		
		evaluated[c] = True
		visited = [False for i in range(N)]

		pos = c
		first = True
		while(c!=pos or first):

			first  = False

			#print(c)
			#print(paths[c])
			for elem in paths[pos]:
				visited[elem] = True
			pos = pointer[pos]
			evaluated[pos]= True
		
		x = 0
		#print(visited)
		for i in range(N):
			if visited[i]:
				x+=1

		saved_values[c] = x

		pos = c
		first = True
		while(c!=pos or first):
			first  = False
			saved_values[pos] = x

			pos = pointer[pos]

		print(x)

	else:
		pos = c
		while(saved_values[pos] == -1):
			pos = pointer[pos]

		print(saved_values[pos])	
# for c in range(N):
# 	starts_at = c
# 	pos = starts_at
# 	visited=[False for x in range(N)]
# 	visited[c]=True
# 	not_first = True
# 	while (c != starts_at or not_first):
# 		# print('entered')
# 		not_first = False
# 		for entry in swaps:
# 			if entry[0] == pos:
# 				pos = entry[1]
# 				visited[pos] +=1
# 			elif entry[1] == pos:
# 				pos = entry[0]
# 				visited[pos] +=1

# 		starts_at = pos
# 	x = 0
# 	for i in range(N):
# 		if visited[i]:
# 			x+=1
# 	print(x)
