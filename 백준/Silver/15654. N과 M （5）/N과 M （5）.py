N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
global Visited
Visited = dict()

for item in arr:
    Visited[item] = False

ans = []

def dfs(item, depth):
    global Visited
    # Visited 표시
    Visited[item] = True
    ans.append(str(item))
    # depth == M 이라면 출력 + 종료
    if depth == M:
        print(" ".join(ans))
        return
    # arr에 있는 item에 대하여
    for x in arr:
        # 방문하지 않은 경우 dfs
        if not Visited[x]:
            dfs(x, depth+1)
            # 방문 체크 해제
            ans.pop()
            Visited[x] = False


for i in arr:
    ans = []
    for item in arr:
        Visited[item] = False
    dfs(i, 1)