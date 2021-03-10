s = input()
N = int(s)

coords = []
for i in range(N):
	x = input()
	entry = x.split()
	entry[0] = int(entry[0])
	entry[1] = int(entry[1])	

	coords.append(entry+[i])

indexes = [False] * (2**(N+1))

for cow1 in coords:
	for cow2 in coords:
		val = 0
		for cow3 in coords:
			if ((cow1[0]<=cow3[0]<=cow2[0]) or (cow1[1]>=cow3[1]>=cow2[1])) and ((cow1[1]<=cow3[1]<=cow2[1]) or (cow1[1]>=cow3[1]>=cow2[1])):
				val += 2**(cow3[2])
		indexes[val] = True

types = 0
for i in range(2**N):
	if indexes[i]:
		types+=1
print(types)