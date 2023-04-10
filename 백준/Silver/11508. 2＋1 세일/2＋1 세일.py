import sys
input = sys.stdin.readline

N = int(input())
res = 0
arr = []
for _ in range(N):
    arr.append(int(input()))

#유제품을 크기가 큰 순서로 정렬후 묶음
arr.sort()
arr.reverse()

#묶음에서 가장 작은 것은 제외하고 더함
for i in range(N):
    if (i+1) % 3 != 0:
        res += arr[i]

print(res)
