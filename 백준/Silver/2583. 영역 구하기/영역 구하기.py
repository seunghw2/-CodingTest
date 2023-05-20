import sys
sys.setrecursionlimit(10**6)

global M, N, cnt
M, N, K = map(int, input().split())
box = []
visited = set()
xxyy = [[-1, 0], [1, 0], [0, -1], [0, 1]]
ans = []

def dfs(x, y):
    global cnt
    if not (x, y) in visited:
        visited.add((x, y))
        cnt += 1
        for xx, yy in xxyy:
            movx = x + xx
            movy = y + yy
            if 0 <= movx < N and 0 <= movy < M:
                if not (movx, movy) in visited:
                    dfs(movx, movy)


for _ in range(K):
    box.append(list(map(int, input().split())))

for x1, y1, x2, y2 in box:
    for x in range(x1, x2):
        for y in range(y1, y2):
            visited.add((x + 0.5, y + 0.5))

for y in range(M):
    for x in range(N):
        cnt = 0
        dfs(x+0.5, y+0.5)
        if cnt != 0:
            ans.append(cnt)
            cnt = 0

print(len(ans))
ans.sort()
for item in ans:
    print(item, end=' ')