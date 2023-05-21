N, M = map(int, input().split())
arr = set()
ans = 0

for _ in range(N):
    arr.add(input())

for _ in range(M):
    x = input()
    if x in arr:
        ans += 1

print(ans)