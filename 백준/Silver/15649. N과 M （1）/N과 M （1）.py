from itertools import permutations

N, M = map(int, input().split())
arr = []

for i in range(1, N+1):
    arr.append(i)

ans = list(permutations(arr, M))
for line in ans:
    for item in line:
        print(item, end=' ')
    print()