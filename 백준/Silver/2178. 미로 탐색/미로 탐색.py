import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
graph = []
queue = deque([])

nx = [+1, 0, -1, 0]
ny = [0, +1, 0, -1]

for _ in range(N):
    graph.append(list(input().rstrip()))


def bfs():
    cnt = 0

    while queue:    # queue에 원소가 있을 때 계속 반복
        (x, y, cnt) = queue.popleft()
        if 0 <= x < M and 0 <= y < N:   # 배열 내부의 경우
            if graph[y][x] == '1':      # 수가 1인 경우
                graph[y][x] = '2'      # 방문한 곳을 또 방문하지 않기 위하여 체크함.
                cnt += 1
                if x == M-1 and y == N-1:   # 도착했을 때
                    print(cnt)
                    exit()
                else:
                    for i in range(4):  # 인근 좌표 모두 큐에 넣어줌
                        queue.append((x+nx[i], y+ny[i], cnt))


queue.append((0, 0, 0))
bfs()

