N = int(input())

color = []  # R, G, B

for _ in range(N):
    color.append(list(map(int, input().split())))

dp_color = [color[0]] + [[-1, -1, -1] for _ in range(N-1)]   # R, G, B

for i in range(1, N):
    dp_color[i][0] = min(dp_color[i-1][1], dp_color[i-1][2]) + color[i][0]
    dp_color[i][1] = min(dp_color[i - 1][0], dp_color[i - 1][2]) + color[i][1]
    dp_color[i][2] = min(dp_color[i - 1][0], dp_color[i - 1][1]) + color[i][2]

print(min(dp_color[N-1][0], dp_color[N-1][1], dp_color[N-1][2]))