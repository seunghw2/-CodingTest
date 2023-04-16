t = int(input())
for _ in range(t):
    n = int(input())
    cloth = dict()

    for _ in range(n):
        name, type = input().split()
        if type in cloth:
            cloth[type] += 1
        else:
            cloth[type] = 1

    arr = list(cloth.values())
    ans = 1
    for item in arr:
        ans *= (item + 1)

    print(ans-1)