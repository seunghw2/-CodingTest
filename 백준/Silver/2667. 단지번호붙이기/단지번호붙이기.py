import sys
input = sys.stdin.readline

N = int(input())

graph = []
bui = []    # 단지내 집의 수를 담는 배열

dx = [+1, 0, -1, 0]
dy = [0, +1, 0, -1]

for _ in range(N):
    graph.append(list(input().rstrip()))


def dfs(x, y, cnt):
    if 0 <= x < N and 0 <= y < N:   # 배열 내부에 있는지 확인
        if graph[y][x] == '1':  # 1인 경우
            graph[y][x] = '0'   # 중복하여 방문하지 않기 위하여 0으로 표시
            cnt += 1    # 단지내 집의 수 +1
            for i in range(4):  # 인근 좌표를 dfs
                cnt = max(cnt, dfs(x+dx[i], y+dy[i], cnt))  # 현재까지 센 총 단지내 집의 수 : cnt

    return cnt


tot = 0
for j in range(N):
    for i in range(N):
        res = dfs(i, j, 0)
        if res:
            tot += 1
            bui.append(res)

bui.sort()

print(tot)
for item in bui:
    print(item)


