from collections import deque

N = int(input())
arr = [[] for _ in range(N+1)]
ans = dict()
queue = deque()

for _ in range(N-1):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

queue.append(1)
while queue:
    x = queue.popleft()
    for item in arr[x]:
        if not item in ans:
            queue.append(item)
            ans[item] = x


for i in range(2, N+1):
    print(ans[i])