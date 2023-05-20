import sys
sys.setrecursionlimit(10**6)
M, N, K = map(int, input().split())
paper = [[0 for _ in range(N)] for _ in range(M)]
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            paper[i][j] = 1

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
def dfs(x, y):
    global cnt
    paper[x][y] = 1
    cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<M and 0<=ny<N and paper[nx][ny] == 0:
            dfs(nx, ny)

result = []
for i in range(M):
    for j in range(N):
        if paper[i][j] == 0:
            cnt = 0
            dfs(i, j)
            result.append(cnt)

print(len(result))
print(*sorted(result))
