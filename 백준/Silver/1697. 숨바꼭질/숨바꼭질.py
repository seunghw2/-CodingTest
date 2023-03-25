from collections import deque

N, K = map(int, input().split())
queue = deque([])
visited = [False for _ in range(100001)]


def bfs(x):
    # print(x)
    if 0 <= x <= 100000:
        if not visited[x]:
            visited[x] = True
            queue.append(x - 1)
            queue.append(x + 1)
            queue.append(x * 2)


cnt = 0
res = 0
queue.append(N)

while True:
    # print(queue)
    x = len(queue)
    for _ in range(x):
        y = queue.popleft()
        if y == K:
            print(cnt)
            exit()
        else:
            bfs(y)

    cnt += 1
