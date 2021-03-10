s = input()
N = int(s)

all_cows = []
n_cows = []
e_cows = []

for i in range(N):
    s = input()
    coords = s.split()
    coords[1] = int(coords[1])
    coords[2] = int(coords[2])

    all_cows.append(coords + [0] + [i])

    if coords[0] == 'N':
        n_cows.append([coords[1],coords[2]])
    if coords[0] == 'E':
        e_cows.append([coords[1],coords[2]])
big=10000000000


for vector in all_cows: #lower bound on grass
    grass = big
    #debug(vector)

    if vector[0] == 'N':  #vector[1] is the x coord, vector[2] is the y coord
        for cutoff_cow in e_cows: #c_c[0] is x coord, c_c[1] is y coord
            dy = cutoff_cow[1] - vector[2]
            dx = vector[1] - cutoff_cow[0]

            if (dy > dx and dx > 0) and (grass > dy): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                grass = dy
    
    if vector[0] == 'E':# must be easet
        for cutoff_cow in n_cows: #c_c[0] is x coord, c_c[1] is y coord
            dx = cutoff_cow[0] - vector[1]
            dy = vector[2] - cutoff_cow[1]
            
            if (dx > dy and dy > 0) and (grass > dx): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                grass = dx
    vector[3]=grass
#debug(n_cows)
for _ in range(N*2):
    n_cows = []
    e_cows = []
    for vector in all_cows:
        if vector[0] == 'N':
            n_cows.append([vector[1],vector[2],vector[3]])
        else:
            e_cows.append([vector[1],vector[2],vector[3]])        
    #debug(n_cows)

    for vector in all_cows:
        grass = big

        if vector[0] == 'N':  #vector[1] is the x coord, vector[2] is the y coord
            for cutoff_cow in e_cows: #c_c[0] is x coord, c_c[1] is y coord
                dy = cutoff_cow[1] - vector[2]
                dx = vector[1] - cutoff_cow[0]

                if (dy > dx > 0 and cutoff_cow[2] > dx) and (grass > dy): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                    grass = dy
        
        if vector[0] == 'E':# must be easet
            for cutoff_cow in n_cows: #c_c[0] is x coord, c_c[1] is y coord
                dx = cutoff_cow[0] - vector[1]
                dy = vector[2] - cutoff_cow[1]
                
                if (dx > dy > 0 and cutoff_cow[2] > dy) and (grass > dx): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                    grass = dx
        vector[3]=grass

n_cows = []
e_cows = []
for vector in all_cows:
    if vector[0] == 'N':
        n_cows.append([vector[1],vector[2],vector[3],vector[4]])
    else:
        e_cows.append([vector[1],vector[2],vector[3],vector[4]])

#a cutoff b if b+b's grass = a's spot
print(all_cows)
indexes = []
for cutter in all_cows:
    temp = []
    print(cutter)
    if cutter[0] == 'N':
        for cuttee in e_cows:
            if cuttee[0]+cuttee[2] == cutter[1]:#x coords
                temp.append(cuttee[3])
    else:
        for cuttee in n_cows:
            if cuttee[1]+cuttee[2] == cutter[2]:# y coords
                temp.append(cuttee[3])
    indexes.append(temp)
print("indexes")
print(indexes)    

def blockage(index):
    if len(indexes[index]) == 0:
        return 0
    else:
        blocks = 0
        for val in indexes[index]:
            blocks += (1+blockage(val)) 
        return blocks
for l in range(N):
    print(blockage(l))

print()
print("Grass Levels:")
for vector in all_cows:
    if vector[3] == big:
        print("Infinity")
    else:
        print(vector[3])


