# 10828
import sys

N = int(input())
a = []

for i in range(N):
    S = sys.stdin.readline().split()
    if S[0] == "push":
        a.append(int(S[1]))

    elif S[0] == "pop":
        if len(a) != 0:
            print(a[len(a)-1])
            a.pop(len(a)-1)
        else:
            print(-1)

    elif S[0] == "size":
        print(len(a))

    elif S[0] == "empty":
        if len(a) == 0:
            print(1)
        else:
            print(0)

    elif S[0] == "top":
        if len(a) != 0:
            print(a[len(a)-1])
        else:
            print(-1)