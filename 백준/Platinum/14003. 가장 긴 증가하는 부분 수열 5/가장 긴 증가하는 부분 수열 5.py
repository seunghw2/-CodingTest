# 11053
from bisect import bisect_left

N = int(input())
A = [-int(1e10)] + list(map(int, input().split()))
D = [0]
minA = [-int(1e10)]

for i in range(1, len(A)):
    # minA 최대값보다 크다면
    if A[i] > minA[-1]:
        # D에 minA길이 인덱스 추가
        D.append(len(minA))
        # minA에 추가
        minA.append(A[i])
    # minA 최대보다 작다면
    else:
        # minA 이분 탐색(왼쪽 index)
        idx = bisect_left(minA, A[i])
        # 교체
        minA[idx] = A[i]
        # D에 index 추가
        D.append(idx)

ans = []
target = len(minA)-1

for i in range(len(A)-1, 0, -1):
    if D[i] == target:
        ans.append(A[i])
        target -= 1
    if target == 0:
        break

print(len(minA)-1)
for i in range(len(ans)-1, -1, -1):
    print(ans[i], end=' ')