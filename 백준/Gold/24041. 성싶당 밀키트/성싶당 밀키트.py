# 11053
import bisect
import sys

# day일 때 최대 K개를 제외한 세균수를 구하는 함수 germ(arr, day, K)
def germ(arr, day, K):
    # 세균수 배열 germCnt = []
    germCnt = []
    # item in arr
    for speed, limit in arr:
        germCnt.append(speed * max(1, day - limit))
    # K개 pop
    if K != 0:
        if K > len(arr):
            K = len(arr)

        germCnt.sort()
        for _ in range(K):
            germCnt.pop()
    # germCnt에 있는 값 모두 더해서 return
    tot = 0
    for item in germCnt:
        tot += item
    return tot


N, G, K = map(int, input().split())
x0 = []
x1 = []

for _ in range(N):
    S, L, X = map(int, input().split())
    if X == 0:
        x0.append([S, L])
    else:
        x1.append([S, L])

left = 0
right = int(2e9)
res = 0

while left <= right:
    mid = (left + right) // 2
    # day일 때 최대 0개를 제외한 세균 수를 구하는 함수 germ(x0, day, 0)
    germ0 = germ(x0, mid, 0)
    # day일 때 최대 K개를 제외한 세균 수를 구하는 함수 germ(x1, day, K)
    germ1 = germ(x1, mid, K)

    if germ0 + germ1 > G or germ1 == -1:
        right = mid - 1
    else:
        res = mid
        left = mid + 1


print(res)
