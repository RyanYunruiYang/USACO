list_of_seven = input()
entry = list_of_seven.split()
for i in range(7):
    entry[i] = int(entry[i])
entry = sorted(entry)
#print(entry)

if entry[0]+entry[1]+entry[2] == entry[6]:
    print(entry[0],end=' ')
    print(entry[1],end=' ')
    print(entry[2],end='')
if entry[0]+entry[1]+entry[3] == entry[6]:
    print(entry[0],end=' ')
    print(entry[1],end=' ')
    print(entry[3],end='')        