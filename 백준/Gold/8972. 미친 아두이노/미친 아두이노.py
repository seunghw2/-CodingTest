import sys
input = sys.stdin.readline

R, C = map(int, input().split())
I = []
Rlist = []

for y in range(R):
    line = input()
    for x in range(len(line)):
        if line[x] == "I":
            I.append([x, y])
        elif line[x] == "R":
            Rlist.append([x, y])

global Ix, Iy
Ix = I[0][0]
Iy = I[0][1]

orders = input()

movx = [0, -1, 0, 1, -1, 0, 1, -1, 0, 1]
movy = [0, 1, 1, 1, 0, 0, 0, -1, -1, -1]

def moveR(x, y):
    global Ix, Iy
    if x < Ix:
        x += 1
    elif x > Ix:
        x -= 1
    if y < Iy:
        y += 1
    if y > Iy:
        y -= 1
    return x, y

for idx in range(len(orders)-1):
    order = int(orders[idx])
    Ix += movx[order]
    Iy += movy[order]
    Rdict = dict()
    RlistAfter = []

    for i in range(len(Rlist)):
        x, y = Rlist[i][0], Rlist[i][1]
        x, y = moveR(x, y)

        if Ix == x and Iy == y:
            print("kraj", idx+1)
            exit(0)

        if (x, y) not in Rdict:
            Rdict[(x, y)] = 1
            RlistAfter.append([x, y])
        elif Rdict[(x, y)] == 1:
            Rdict[(x, y)] = 2
            RlistAfter.remove([x, y])

    Rlist = RlistAfter.copy()

for y in range(R):
    for x in range(C):
        if [x, y] == [Ix, Iy]:
            print("I", end="")
        elif [x, y] in Rlist:
            print("R", end="")
        else:
            print(".", end="")
    print()