N, M = map(int, input().split())

lis = set()
see = set()

for _ in range(N):
    lis.add(input())
for _ in range(M):
    see.add(input())

ans = list(lis.intersection(see))
ans.sort()

print(len(ans))
for item in ans:
    print(item)