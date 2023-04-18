import sys
input = sys.stdin.readline

n = int(input())
dp = [[0], [0, 0]]

for _ in range(n):
    dp.append([0] + list(map(int, input().split())) + [0])

for y in range(2, n+2):
    for x in range(1, y):
        dp[y][x] = max(dp[y-1][x-1], dp[y-1][x]) + dp[y][x]

print(max(dp[n+1]))