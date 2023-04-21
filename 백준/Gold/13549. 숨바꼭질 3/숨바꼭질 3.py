from collections import deque

MAX = 100001
N, K = map(int, input().split())
queue = deque([N])
Visited = [-1 for _ in range(100001)]
Visited[N] = 0

while queue:
    x = queue.popleft()

    if x == K:
        print(Visited[x])
        break

    if x*2 < MAX and Visited[x*2] == -1:
        Visited[x*2] = Visited[x]
        queue.appendleft(x*2)
    if 0 <= x-1 < MAX and Visited[x-1] == -1:
        Visited[x-1] = Visited[x] + 1
        queue.append(x-1)
    if 0 <= x+1 < MAX and Visited[x+1] == -1:
        Visited[x+1] = Visited[x] + 1
        queue.append(x+1)
