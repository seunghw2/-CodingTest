import sys

input = sys.stdin.readline
N = int(input())

# 숫자열과 숫자열을 뒤집은 숫자열 생성, LCS 계산을 위하여 앞에 0을 붙임
arr = [0] + list(map(int, input().split()))
rev = [0] + list(reversed(arr))
rev.pop()

lcs = [[0 for _ in range(len(arr))] for _ in range(len(arr))]

# 숫자를 하나씩 늘려가며 비교함
for j in range(1, len(arr)):
    for i in range(1, len(arr)):
        # 같으면 왼쪽 위의 값 + 1
        if arr[i] == rev[j]:
            lcs[j][i] = lcs[j-1][i-1] + 1
        # 다르면 왼쪽과 위의 값 중 큰 것
        else:
            lcs[j][i] = max(lcs[j-1][i], lcs[j][i-1])

print(N - lcs[-1][-1])