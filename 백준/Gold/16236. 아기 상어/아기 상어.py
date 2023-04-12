from collections import deque

N = int(input())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

xx = [0, -1, 1, 0]
yy = [-1, 0, 0, 1]


def bfs(x, y, level):
    queue = deque()
    queue.append([x, y, 0])
    Visited = [[False for _ in range(N)] for _ in range(N)]
    Visited[y][x] = 0
    cand = []

    while queue:
        x, y, cnt_tmp = queue.popleft()
        # print(x, y, cnt_tmp)
        if 1 <= arr[y][x] < level:
            cand.append([x, y, cnt_tmp])
        for i in range(4):
            newx = x + xx[i]
            newy = y + yy[i]
            if 0 <= newx < N and 0 <= newy < N:
                if not Visited[newy][newx]:
                    if arr[newy][newx] <= level:
                        queue.append([newx, newy, cnt_tmp+1])
                        Visited[newy][newx] = True

    cand.sort(key = lambda x : (x[2], x[1], x[0]))

    if not cand:
        return [-1, -1, -1]
    else:
        return cand[0]

level = 2
exp = 0
res = 0

for j in range(N):
    for i in range(N):
        if arr[j][i] == 9:
            startx = i
            starty = j

arr[starty][startx] = 0

while True:
    x, y, cnt = bfs(startx, starty, level)
    if x == -1:
        break
    else:
        res += cnt
        arr[y][x] = 0
        exp += 1
        if exp == level:
            level += 1
            exp = 0
        startx = x
        starty = y

print(res)