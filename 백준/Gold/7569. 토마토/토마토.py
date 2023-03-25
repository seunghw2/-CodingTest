from collections import deque

global M, N, H
M, N, H = map(int, input().split())

arr = []
for _ in range(H):
    brr = []
    for _ in range(N):
        brr.append(list(map(int, input().split())))
    arr.append(brr)

global queue
queue = deque()

def putq(x, y, z, day):
    global M, N, H, queue
    if 0 <= x < M and 0 <= y < N and 0 <= z < H:
        queue.append([x, y, z, day])

nearx = [1, -1, 0, 0, 0, 0]
neary = [0, 0, 1, -1, 0, 0]
nearz = [0, 0, 0, 0, 1, -1]

ans = 0

# BFS
# 모든 배열에 접근
for z in range(H):
    for y in range(N):
        for x in range(M):
            # 만약 1이라면
            if arr[z][y][x] == 1:
                # 주변 6개를 queue에 넣음
                for i in range(6):
                    # day = 0
                    putq(x+nearx[i], y+neary[i], z+nearz[i], 0)


# queue가 비어있지 않을 때까지
while queue:
    # print(queue)
    # queue에서 pop
    item = queue.popleft()
    x = item[0]
    y = item[1]
    z = item[2]
    day = item[3]
    # 이 때 day가 진짜. ans = max(res, day)
    ans = max(ans, day)
    # 만약 0이라면
    if arr[z][y][x] == 0:
        arr[z][y][x] = 1
        # 주변 6개 모두 queue에 넣음 / day +1
        for i in range(6):
            putq(x + nearx[i], y + neary[i], z + nearz[i], day+1)
    # 만약 0이 아니라면
    else:
        continue

allsame = True

# print(arr)

# 모든 배열에 접근
for z in range(H):
    for y in range(N):
        for x in range(M):
            # 모든 토마토가 1이면 res 출력
            if arr[z][y][x] == 0:
                allsame = False
                print(-1)
                exit()
# 아니라면 -1 출력
print(ans)

