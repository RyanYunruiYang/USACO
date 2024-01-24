with open("moobuzz.in") as f:
    N = int(f.readline())

non_words = [1,2,4,7,8,11,13,14]



with open("moobuzz.out","a") as o:
    o.write(str(15*((N-1)//8) + non_words[(N % 8) - 1]))
