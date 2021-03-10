s = input()
N = int(s)

entry = []
for i in range(N):
	x = input()
	entry = x.split()
	entry[0] = int(entry[0])
	entry[1] = int(entry[1])	

	coords.append(entry+[i])

indexes = [False] * (2**N)

for cow1 in coords:
	for cow2 in coords:
		val = 0
		for cow3 in coords:
			if #cow3 is in cow1,cow2L
				val += 2**(cow3[2])
		indexes[val] = True
