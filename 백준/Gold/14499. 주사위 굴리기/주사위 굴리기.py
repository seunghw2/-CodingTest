import sys
input = sys.stdin.readline

N, M, x, y, K = map(int, input().split())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

seq = list(map(int, input().split()))

dice = [0 for _ in range(6)]


def movMap(x, y, num):
    if num == 1:
        y += 1
    elif num == 2:
        y -= 1
    elif num == 3:
        x -= 1
    else:
        x += 1

    if 0 <= x < N and 0 <= y < M:
        return x, y
    else:
        return -1, -1


def movDice(num):
    if num == 1:
        dice[1], dice[2], dice[3], dice[5] = dice[2], dice[3], dice[5], dice[1]
    elif num == 2:
        dice[1], dice[2], dice[3], dice[5] = dice[5], dice[1], dice[2], dice[3]
    elif num == 3:
        dice[0], dice[2], dice[4], dice[5] = dice[5], dice[0], dice[2], dice[4]
    else:
        dice[0], dice[2], dice[4], dice[5] = dice[2], dice[4], dice[5], dice[0]

for k in seq:
    tmpx, tmpy = x, y
    x, y = movMap(x, y, k)
    if x != -1:
        movDice(k)
        if arr[x][y] == 0:
            arr[x][y] = dice[2]
        else:
            dice[2] = arr[x][y]
            arr[x][y] = 0
        print(dice[5])
    else:
        x, y = tmpx, tmpy