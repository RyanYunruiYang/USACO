s = input()
N = int(s)

x_coords = []
y_coords = []
for i in range(N):
	x = input()
	entry = x.split()
	entry[0] = int(entry[0])
	entry[1] = int(entry[1])	

	x_coords.append([entry[0],i])
	y_coords.append([entry[1],i])

x = sorted(x_coords , key=lambda k: k[0])
y = sorted(y_coords , key=lambda k: k[0])

indexes = [False] * (2**N)
for a in range(N+1):
	for b in range(a):
		for c in range(N+1):
			for d in range(c):
				exes = [x[i][1] for i in range(b,a)]
				whys = [y[j][1] for j in range(d,c)]

				intersect = [index for index in exes if index in whys]
				
				val = 0
				for index in intersect:
					val += (2**index)
				indexes[val] = True

types = 0
for i in range(2**N):
	if indexes[i]:
		types+=1
print(types)
