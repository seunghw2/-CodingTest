import sys
from collections import deque
input = sys.stdin.readline

V, E, start = map(int, input().split())
graph = [[] for _ in range(V+1) ]   # 0 ~ V 까지의 2차원 배열 graph 선언
visited = [False] * (V+1)

for _ in range(E):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(1, V+1):
    graph[i].sort()

def DFS(start):
    visited[start] = True
    print(start, end = ' ')

    for i in graph[start]:      # 작은 node부터 방문
        if not visited[i]:      # 방문하지 않았을 경우
            visited[i] = True        # 방문 처리
            DFS(i)  # DFS 실행

def BFS(start):
    queue = deque([start])

    while queue:
        x = queue.popleft()
        if not visited[x]:
            visited[x] = True
            print(x, end = ' ')
            for i in graph[x]:
                queue.append(i)

DFS(start)
visited = [False] * (V+1)
print()
BFS(start)