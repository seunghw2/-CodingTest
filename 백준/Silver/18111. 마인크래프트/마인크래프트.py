import sys

N, M, B = map(int, input().split())
arr = []

minh = 257
maxh = -1

for _ in range(N):
    tmp = list(map(int, input().split()))
    arr.append(tmp)
    minh = min(minh, min(tmp))
    maxh = max(maxh, max(tmp))

resTime = sys.maxsize
resHeight = 257

for h in range(minh, maxh+1):
    time = 0
    cntB = 0

    for line in arr:
        for item in line:
            if item > h:
                time += 2 * (item - h)
                cntB -= (item - h)
            elif item < h:
                time += (h - item)
                cntB += (h - item)
            else:
                continue

    if cntB > B:    # 부족
        continue
    else:
        if time <= resTime:
            resTime = time
            resHeight = h

print(resTime, resHeight)






