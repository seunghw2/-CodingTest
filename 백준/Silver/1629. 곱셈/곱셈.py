import sys
input = sys.stdin.readline

global A, C
A, B, C = map(int, input().split())

def calc(exp):
    if exp == 1:
        return A % C
    else:
        tmp = calc(exp // 2)
        if exp % 2 == 0:
            return tmp * tmp % C
        else:
            return (tmp * tmp * A) % C

print(calc(B))