N = int(input())
s = []
sum = 0

for _ in range(N):
    s.append(int(input()))
s.sort()
s.reverse()

for i in range(N):
    if s[i] - i < 0:
        sum += 0
    else:
        sum += s[i] - i

print(sum)