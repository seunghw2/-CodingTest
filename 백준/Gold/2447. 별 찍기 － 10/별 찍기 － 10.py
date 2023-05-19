N = int(input())
k = 0
pow3 = []

for i in range(8):
    if pow(3, i) == N:
        k = i
        break

for i in range(k+1):
    pow3.append(pow(3, i))

arr = [set() for _ in range(k+1)]
star = [[1 for _ in range(N)] for _ in range(N)]


for i in range(1, k+1):
    for j in range(pow3[i-1], 2*pow3[i-1]):
        arr[i].add(j)

for y in range(N):
    for x in range(N):
        for i in range(1, k+1):
            if x % pow3[i] in arr[i] and y % pow3[i] in arr[i]:
                star[y][x] = 0
                break

for line in star:
    for item in line:
        if item == 1:
            print("*", end='')
        else:
            print(" ", end='')
    print()

