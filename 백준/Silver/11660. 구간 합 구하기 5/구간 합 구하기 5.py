import sys
input = sys.stdin.readline

N, M = map(int, input().split())

dp = [[0 for _ in range(N+1)]]

for _ in range(N):
    dp.append([0] + list(map(int, input().split())))

for y in range(1, N+1):
    for x in range(1, N+1):
        dp[y][x] = dp[y-1][x] + dp[y][x-1] - dp[y-1][x-1] + dp[y][x]

# for line in dp:
#     for item in line:
#         print(item, end=' ')
#     print()

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    tot = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]
    print(tot)
