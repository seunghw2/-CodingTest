import sys
input = sys.stdin.readline

N, X = map(int, input().split())
arr = list(map(int, input().split()))

sta = 0
end = X-1

max = 0
res = 0
tot = 0

while end != N:
    if sta == 0:
        for i in range(0, X):
            tot += arr[i]
    else:
        tot -= arr[sta-1]
        tot += arr[end]

    if tot > max:
        max = tot
        res = 1
    elif tot == max:
        res += 1

    sta += 1
    end += 1

if max == 0:
    print("SAD")
else:
    print(max)
    print(res)
