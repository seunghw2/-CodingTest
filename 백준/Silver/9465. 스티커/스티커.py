import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    arr = []
    arr.append(list(map(int, input().split())))
    arr.append((list(map(int, input().split()))))

    if n == 1:
        print(max(arr[0][0], arr[1][0]))
        continue

    dp = [[-1 for _ in range(n)] for _ in range(2)]

    dp[0][0] = arr[0][0]
    dp[1][0] = arr[1][0]
    dp[0][1] = arr[0][1] + arr[1][0]
    dp[1][1] = arr[0][0] + arr[1][1]

    ans = max(dp[0][0], dp[0][1], dp[1][0], dp[1][1])

    for x in range(2, n):
        for y in range(2):
            if y == 0:
                dp[y][x] = max(dp[0][x-2], dp[1][x-2], dp[1][x-1]) + arr[y][x]
            else:
                dp[y][x] = max(dp[0][x-2], dp[0][x-1], dp[1][x-2]) + arr[y][x]
            if dp[y][x] > ans:
                ans = dp[y][x]

    print(ans)