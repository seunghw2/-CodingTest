from math import sqrt, floor

def cir(r):
    cnt = 0
    for x in range(-r, r+1):
        y = sqrt(r*r - x*x)
        y = floor(y)
        cnt += (2 * y + 1)
    return cnt

def bound(r):
    cnt = 0
    for x in range(-r+1, r):
        y = sqrt(r*r - x*x)
        if y == floor(y):
            cnt += 2
    return cnt + 2

def solution(r1, r2):
    answer = cir(r2) - cir(r1) + bound(r1)
    return answer