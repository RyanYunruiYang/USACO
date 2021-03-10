s = input()
N = int(s)

all_cows = []
n_cows = []
e_cows = []

for _ in range(N):
    s = input()
    coords = s.split()
    coords[1] = int(coords[1])
    coords[2] = int(coords[2])

    all_cows.append(coords + [0])

    if coords[0] == 'N':
        n_cows.append([coords[1],coords[2]])
    if coords[0] == 'E':
        e_cows.append([coords[1],coords[2]])

simulation_steps = 10000
for _ in range(simulation_steps):
    for vector in all_cows:
        if vector[0] == 'N':  #vector[1] is the x coord, vector[2] is the y coord
            vector[2]+=1
        if vector[0] == 'E':# must be easet
            vector[1]+=1