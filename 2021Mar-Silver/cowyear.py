s = input()
entry = s.split()
N = int(entry[0])
K = int(entry[1])

size=10
must_visit = [False for i in range(size)]
oldest_year = 0
for i in range(N):
	year = int(input())
	x = year//12
	must_visit[x] = True

	if x > oldest_year:
		oldest_year = x

k = 0

cur_false = 0
false_runs = []
print(must_visit)
while k <= oldest_year:
	if must_visit[k] == True:
		false_runs.append(cur_false)
		cur_false = 0

	else:
		cur_false += 1


	k+=1
	#print(cur_false)

false_runs.sort(reverse=True)
#print(false_runs)
#print(oldest_year)
#print(false_runs)

skipped = 0
for i in range(K-1):
	skipped += false_runs[i]

print(12*(oldest_year+1-skipped))