T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    farm = []
    for i in range(N):
        farm.append(list(map(int, input())))

    tot = 0

    for y in range(0, N // 2 + 1):
        for x in range(0, N):
            if (N // 2 - y) <= x <= (N // 2 + y):
                tot += farm[y][x]

    for y in range(N // 2 + 1, N):
        for x in range(0, N):
            if (N // 2 - (N - 1 - y)) <= x <= (N // 2 + (N - 1 - y)):
                tot += farm[y][x]

    print("#{0} {1}".format(test_case, tot))