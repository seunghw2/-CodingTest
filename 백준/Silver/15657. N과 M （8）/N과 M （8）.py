N, M = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()
ans = []


def dfs(i, depth):
    # depth = m인 경우
    if depth == M:
        # 정답 출력
        print(" ".join(ans))
        # return
        return
    # item : x부터 N까지 반복
    for idx in range(i, len(arr)):
        # ans에 추가
        ans.append(str(arr[idx]))
        # dfs(item, depth + 1)
        dfs(idx, depth + 1)
        # ans에서 pop
        ans.pop()


dfs(0, 0)