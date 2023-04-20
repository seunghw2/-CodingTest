import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    dp = []
    dp.append(list(map(int, input().split())))
    dp.append((list(map(int, input().split()))))

    if n == 1:
        print(max(dp[0][0], dp[1][0]))
    else:
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]

        for x in range(2, n):
            dp[0][x] += max(dp[1][x-2], dp[1][x-1])
            dp[1][x] += max(dp[0][x-2], dp[0][x-1])

        print(max(dp[0][-1], dp[1][-1]))