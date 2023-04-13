N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(input())

W = "WBWBWBWB"
B = "BWBWBWBW"

ansW = [W, B, W, B, W, B, W, B]
ans = 65

def compare(arr):
    cntW = 0
    for j in range(8):
        for i in range(8):
            if arr[j][i] != ansW[j][i]:
                cntW += 1
    return min(cntW, 64-cntW)


for y in range(0, N-7):
    for x in range(0, M-7):
        sample = []
        for i in range(8):
            sample.append(arr[y+i][x:x+8])
        ans = min(ans, compare(sample))

print(ans)