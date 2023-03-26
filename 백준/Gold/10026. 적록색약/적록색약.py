# 10026
import sys
sys.setrecursionlimit(10**6)

N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(str, input())))

# 방문 체크 배열 Visited : 방문시 True
Visited = [[False for _ in range(N)] for _ in range(N)]

xx = [-1, 1, 0, 0]
yy = [0, 0, -1, 1]


# DFS(x, y, Color)
def DFS(x, y, color):
    # 방문한 적이 없을 때
    if not Visited[y][x]:
        # Color과 같은 색일 때
        if arr[y][x] == color:
            # 방문 체크
            Visited[y][x] = True
            # 주변 배열에 대해 DFS 실행
            for i in range(4):
                # x, y가 배열의 정상 범위일 때
                if 0 <= x+xx[i] < N and 0 <= y+yy[i] < N:
                    DFS(x+xx[i], y+yy[i], color)


# DFS(x, y, Color)
def DFS_RG(x, y, color):
    # 방문한 적이 없을 때
    if not Visited[y][x]:
        # Color과 R 혹은 G라면
        if color == 'R' or color == 'G':
            # 현재가 R 혹은 G일 때
            if arr[y][x] == 'R' or arr[y][x] == 'G':
                # 방문 체크
                Visited[y][x] = True
                # 주변 배열에 대해 DFS 실행
                for i in range(4):
                    if 0 <= x + xx[i] < N and 0 <= y + yy[i] < N:
                        DFS_RG(x + xx[i], y + yy[i], color)
        # Color가 B라면
        elif color == 'B':
            # 현재가 B 일 때
            if arr[y][x] == 'B':
                # 방문 체크
                Visited[y][x] = True
                # 주변 배열에 대해 DFS 실행
                for i in range(4):
                    if 0 <= x + xx[i] < N and 0 <= y + yy[i] < N:
                        DFS_RG(x + xx[i], y + yy[i], color)


cnt = 0
cnt_RG = 0

# 배열을 모두 한번씩 돔
for y in range(N):
    for x in range(N):
        # 만약 not Visited
        if not Visited[y][x]:
            # 주변 배열에 대해 DFS 실행
            for i in range(4):
                if 0 <= x + xx[i] < N and 0 <= y + yy[i] < N:
                    DFS(x + xx[i], y + yy[i], arr[y][x])
            # 구역의 개수 추가
            cnt += 1

# 방문 체크 배열 Visited : 방문시 True
Visited = [[False for _ in range(N)] for _ in range(N)]

# 배열을 모두 한번씩 돔
for y in range(N):
    for x in range(N):
        # 만약 not Visited
        if not Visited[y][x]:
            # 주변 배열에 대해 DFS 실행
            for i in range(4):
                if 0 <= x + xx[i] < N and 0 <= y + yy[i] < N:
                    DFS_RG(x + xx[i], y + yy[i], arr[y][x])
            # 구역의 개수 추가
            cnt_RG += 1

print(cnt, cnt_RG)