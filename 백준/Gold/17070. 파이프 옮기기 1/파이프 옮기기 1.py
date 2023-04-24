import sys
input = sys.stdin.readline

N = int(input())
house = []
ans = 0

for _ in range(N):
    house.append(list(map(int, input().split())))


# 가로 : 0, 세로 : 1, 대각 : 2
# x, y : 끝점
def dfs(x, y, dir):
    global ans
    # print(x, y, dir)

    if x == N-1 and y == N-1:
        ans += 1
        return

    if dir == 0:    #가로
        if x+1 < N and house[y][x+1] != 1:     # 가로
            # print(x, y, dir, "->", x+1, y, 0)
            dfs(x+1, y, 0)
        if x+1 < N and y+1 < N and house[y][x+1] != 1 and house[y+1][x] != 1 and house[y+1][x+1] != 1:  # 대각선
            # print(x, y, dir, "->", x+1, y+1, 2)
            dfs(x+1, y+1, 2)

    elif dir == 1:
        if y+1 < N and house[y+1][x] != 1:     # 세로
            # print(x, y, dir, "->", x, y+1, 1)
            dfs(x, y+1, 1)
        if x+1 < N and y+1 < N and house[y][x+1] != 1 and house[y+1][x] != 1 and house[y+1][x+1] != 1:  # 대각선
            # print(x, y, dir, "->", x+1, y+1, 2)
            dfs(x+1, y+1, 2)

    else:
        if x+1 < N and house[y][x+1] != 1:     # 가로
            # print(x, y, dir, "->", x+1, y, 0)
            dfs(x+1, y, 0)
        if y+1 < N and house[y+1][x] != 1:     # 세로
            # print(x, y, dir, "->", x, y+1, 1)
            dfs(x, y+1, 1)
        if x+1 < N and y+1 < N and house[y][x+1] != 1 and house[y+1][x] != 1 and house[y+1][x+1] != 1:  # 대각선
            # print(x, y, dir, "->", x+1, y+1, 2)
            dfs(x+1, y+1, 2)


dfs(1, 0,0)
print(ans)