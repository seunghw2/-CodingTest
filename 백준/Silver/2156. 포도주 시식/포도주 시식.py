import sys
input = sys.stdin.readline

N = int(input())

gra = [0 for _ in range(N)]
dp = [0 for _ in range(N)]

for i in range(N):
    gra[i] = int(input())

dp[0] = gra[0]
if N == 1:
    print(dp[0])
    exit()
dp[1] = gra[0] + gra[1]
if N == 2:
    print(dp[1])
    exit()
dp[2] = gra[0] + gra[1] + gra[2] - min(gra[0], gra[1], gra[2])
if N == 3:
    print(dp[2])
    exit()

for i in range(3, N):
    dp[i] = max(dp[i-1], dp[i-2] + gra[i], dp[i - 3] + gra[i - 1] + gra[i])

print(dp[N-1])

