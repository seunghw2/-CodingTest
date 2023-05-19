n = int(input())
box = list(map(int, input().split()))
dp = [1 for _ in range(n)]

for i in range(1, n):
    maxdp = 0
    for j in range(i):
        if box[j] < box[i]:
            if dp[j] > maxdp:
                maxdp = dp[j]
    dp[i] = maxdp + 1

print(max(dp))