with open("whereami.in","r") as f:
    N = int(f.readline())
    mailbox = f.readline()

K = 0
repeated_sequence = True
while(repeated_sequence):
    repeated_sequence = False
    K += 1
    s = []
    for i in range(N-K+1):
        sub = mailbox[i:i+K]
        if sub in s:
            repeated_sequence = True
        else:
            s.append(sub)
o = open("whereami.out","a")
o.write(str(K))
o.close()