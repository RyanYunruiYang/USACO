s=input()
entry = s.split()
N = int(entry[0])
Q = int(entry[1])

painting = input()
p = list(painting)
for i in range(len(p)):
	p[i] = ord(p[i])-65 #A:0, B:1,....Z:25



for i in range(2):
	x = input()
	entry = x.split()
	entry[0] = int(entry[0])
	entry[1] = int(entry[1])

	s1 = p[:entry[0]-1]
	a = len(s1)
	s2 = p[entry[1]:]

	print(s1)
	strokes = []
	num_strokes = 0

	contained = [False for x in range(26)]
	for elem in s1:
		contained[elem]=True

	for color in range(26):
		if(contained[color]):	
			stroke = 0
			#count # of times that it goes from high to low
			#also bonus for the first appearance, doable by letting first be infinity
			index = 0
			#print(a)
			while(index < a):
				while(index < a and s1[index]!=color):
					index+=1
				if index < a and s1[index] == color:
					stroke+=1
				#now s1[index] = color
				while(index < a and s1[index]>= color):
					index+=1

				#now s1[index] < color
			strokes.append(stroke)
			num_strokes +=stroke
		else:
			strokes.append(0)
	print(strokes)

















