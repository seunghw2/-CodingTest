N = int(input())
dp = [1, -1, 1, 2, -1, 2, 3, 2, 3, 4]    # 초기 dp
N -= 3      # 3부터 시작인 값을 0부터로 취급
cnt = 0
while N >= 10:
    N -= 5
    cnt += 1
print(dp[N] + cnt)




