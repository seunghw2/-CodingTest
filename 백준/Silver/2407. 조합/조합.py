n, m = map(int, input().split())

if m > n // 2:
    m = n - m

dp = [1]

for i in range(m+1):
    if i == 0:
        continue
    elif i == 1:
        dp.append(n)
    else:
        dp.append((dp[i-1] * (n - i + 1)) // i)

print(dp[m])
