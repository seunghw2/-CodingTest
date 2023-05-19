N = int(input())
k = 0
for i in range(8):
    if pow(3, i) == N:
        k = i
        break

arr = [set() for _ in range(k+1)]
star = [[1 for _ in range(N)] for _ in range(N)]

for i in range(1, k+1):
    for j in range(pow(3, i-1), 2*pow(3, i-1)):
        arr[i].add(j)

for y in range(N):
    for x in range(N):
        for i in range(1, k+1):
            if x % pow(3, i) in arr[i] and y % pow(3, i) in arr[i]:
                star[y][x] = 0
                break

for line in star:
    for item in line:
        if item == 1:
            print("*", end='')
        else:
            print(" ", end='')
    print()

