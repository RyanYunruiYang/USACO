import csv

with open('RoomUsageSheet.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    room_count = 0
    name_count = 0
    firstLine = False

    extraName = 0
    extraRoom = 0    

    rooms = []
    room_num = [0 for x in range(20)]
    room_users = [0 for x in range(20)]
    names = []

    app = []
    app_num = 0

    for row in csv_reader:
        #print("debug")
        if firstLine:
            for x in range(6):
                #print("debug")
                if row[5*x] not in names:
                    names.append(row[5*x])
                    name_count+=1
                else:
                    extraName+=1
                if row[5*x+2] not in rooms:# (0,2) (4,6) (8,10) (10,12)
                    rooms.append(row[5*x+2])
                    room_count+=1
                else:
                    extraRoom+=1                    

        else:
            #print("debug")
            firstLine = True

with open('RoomUsageSheet.csv') as csv_file2:
    csv_reader2 = csv.reader(csv_file2, delimiter = ',')
    for row in csv_reader2:
        if firstLine:
            for x in range(6):
                app.append([row[5*x],row[5*x+2]])
                app_num+=1

        else:
            firstLine = True


    names2 = []
    for i in range(app_num):
        for x in range(room_count):
            if app[i][1] == rooms[x]:
                room_num[x]+=1
            if app[i][1] == rooms[x] and app[i][0] not in names2:
                room_users[x]+=1
                names2.append(app[i][0])
    
    print(f'room_num: {room_num}')
    print(f'room_users: {room_users}')
    print(room_users.sort())

    
    print(f'Processed {room_count} rooms and {name_count} names')
    print(f'Processed {extraRoom} extra rooms and {extraName} extra names')


    #Processed 20 rooms and 35 names
    #Processed 112 extra rooms and 97 extra names