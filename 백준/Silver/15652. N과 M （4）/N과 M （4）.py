N, M = map(int, input().split())

arr = [x for x in range(1, N+1)]
ans = []


def dfs(x, depth):
    # depth = m인 경우
    if depth == M:
        # 정답 출력
        print(" ".join(ans))
        # return
        return
    # item : x부터 N까지 반복
    for item in range(x, N+1):
        # ans에 추가
        ans.append(str(item))
        # dfs(item, depth + 1)
        dfs(item, depth + 1)
        # ans에서 pop
        ans.pop()


for i in range(1, N+1):
    ans = [str(i)]
    dfs(i, 1)