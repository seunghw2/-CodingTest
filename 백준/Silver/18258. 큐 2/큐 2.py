# 10828
import sys
from collections import deque

N = int(input())
a = deque([])

for i in range(N):
    S = sys.stdin.readline().split()
    if S[0] == "push":
        a.append(int(S[1]))

    elif S[0] == "pop":
        if len(a) != 0:
            print(a[0])
            a.popleft()
        else:
            print(-1)

    elif S[0] == "size":
        print(len(a))

    elif S[0] == "empty":
        if len(a) == 0:
            print(1)
        else:
            print(0)

    elif S[0] == "front":
        if len(a) != 0:
            print(a[0])
        else:
            print(-1)

    elif S[0] == "back":
        if len(a) != 0:
            print(a[len(a)-1])
        else:
            print(-1)