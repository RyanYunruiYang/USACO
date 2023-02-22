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

barren_rut = []
#print(all_cows)

simulation_steps = 300
for _ in range(simulation_steps):
    eaten = []
    for vector in all_cows:
        if [vector[1],vector[2]] in barren_rut:
            #print("stopped a cow, feeling good")
            pass
        else:
            vector[3]+=1
            eaten.append([vector[1],vector[2]])
            if vector[0] == 'N':  #vector[1] is the x coord, vector[2] is the y coord
                vector[2]+=1
            if vector[0] == 'E':# must be easet
                vector[1]+=1

    barren_rut = barren_rut + eaten
    #print(barren_rut)
#print(all_cows)
for vector in all_cows:
    if vector[3] == simulation_steps:
        print("Infinity")
    else:
        print(vector[3])