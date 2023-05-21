T = int(input())
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    dis = (pow((x1 - x2), 2) + pow((y1 - y2), 2)) ** 0.5

    if dis == 0 and r1 == r2:
        print(-1)
    elif r1 + r2 < dis:
        print(0)
    elif abs(r1 - r2) > dis:
        print(0)
    elif abs(r1 - r2) == dis:
        print(1)
    elif r1 + r2 == dis:
        print(1)
    else:
        print(2)