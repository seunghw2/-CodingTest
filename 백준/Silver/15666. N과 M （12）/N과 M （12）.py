N, M = map(int, input().split())
arr = set(map(int, input().split()))
arr = list(arr)
arr.sort()

ans = []
N = len(arr)

def dfs(idx):
    if len(ans) == M:
        print(" ".join(map(str, ans)))
        return
    for i in range(idx, N):
        ans.append(arr[i])
        dfs(i)
        ans.pop()

dfs(0)

