import sys
input = sys.stdin.readline

N = int(input())

a = []

for _ in range(N):
    a.append(list(map(int, input().split())))

for item in sorted(a):
    print(item[0], item[1], end = ' ')
    print()