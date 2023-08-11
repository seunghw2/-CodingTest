N = int(input())

for i in range(1000001):
    s = str(i)
    res = i
    for x in s:
        res += int(x)
    if res == N:
        print(i)
        exit()
print(0)