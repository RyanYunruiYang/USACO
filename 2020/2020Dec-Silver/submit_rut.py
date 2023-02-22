s = input()
N = int(s)
big=10000000000


class cow:
    def __init__(self, eastward, x, y, index, grass=big):
        self.eastward = eastward
        self.x = x
        self.y = y
        self.index = index
        self.grass = grass

all_cows = []
n_cows = []
e_cows = []

for i in range(N):
    s = input()
    coords = s.split()
    coords[1] = int(coords[1])
    coords[2] = int(coords[2])

    eastward = (coords[0] == 'E')
    new = cow(eastward, coords[1],coords[2],i)

    all_cows.append(new)
    if eastward:
        e_cows.append(new)
    else:
        n_cows.append(new)


for vector in all_cows: #lower bound on grass
    grass = big
    
    if vector.eastward:# must be easet
        for cutoff_cow in n_cows: #c_c[0] is x coord, c_c[1] is y coord
            dx = cutoff_cow.x - vector.x
            dy = vector.y - cutoff_cow.y
            
            if (dx > dy and dy > 0) and (grass > dx): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                grass = dx
    else:  #vector[1] is the x coord, vector[2] is the y coord
        for cutoff_cow in e_cows: #c_c[0] is x coord, c_c[1] is y coord
            dy = cutoff_cow.y - vector.y
            dx = vector.x - cutoff_cow.x

            if (dy > dx and dx > 0) and (grass > dy): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                grass = dy

    vector.grass = grass

noob = 0
while noob**5 < N:
    noob +=1
#noob^2 yields 4 test cases
#noob^4 yields 8 test cases
for _ in range(noob):
    # n_cows = []
    # e_cows = []
    # for vector in all_cows:
    #     if vector.eastward:
    #         e_cows.append(vector)   
    #     else:
    #         n_cows.append(vector)
            

    for vector in all_cows:
        grass = big
        
        if vector.eastward:# must be easet
            for cutoff_cow in all_cows: #c_c[0] is x coord, c_c[1] is y coord
                if cutoff_cow.eastward == False:
                    dx = cutoff_cow.x - vector.x
                    dy = vector.y - cutoff_cow.y
                    
                    if (dx > dy > 0 and cutoff_cow.grass > dy) and (grass > dx): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                        grass = dx
        else:  #vector[1] is the x coord, vector[2] is the y coord
            for cutoff_cow in all_cows: #c_c[0] is x coord, c_c[1] is y coord
                if cutoff_cow.eastward == True:
                    dy = cutoff_cow.y - vector.y
                    dx = vector.x - cutoff_cow.x

                    if (dy > dx > 0 and cutoff_cow.grass > dx) and (grass > dy): #Lhs is time it takes for north cow to reach intersecgt, RHS is time for east cow
                        grass = dy
        

        vector.grass=grass

n_cows = []
e_cows = []
for vector in all_cows:
    if vector.eastward:
        e_cows.append(vector)
    else:
        n_cows.append(vector)
    

#a cutoff b if b+b's grass = a's spot
#print(all_cows)
indexes = []

for cutter in all_cows:
    #print("hi")
    temp = []
    #print(cutter)
    if cutter.eastward:
        for cuttee in n_cows:
            if cuttee.y+cuttee.grass == cutter.y:# y coords
                temp.append(cuttee.index)
    else:
        for cuttee in e_cows:
            if cuttee.x+cuttee.grass == cutter.x:#x coords
                temp.append(cuttee.index)
    
    #print(temp)
    indexes.append(temp)
  

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

#print()
#print("Grass Levels:")
# for vector in all_cows:
#     if vector[3] == big:
#         print("Infinity")
#     else:
#         print(vector[3])


