import math

def out_cir(r):
    cnt = 0
    for x in range(r+1):
        y = math.sqrt(r*r - x*x)
        y = math.floor(y)
        cnt += (y+1)
    cnt = (cnt * 4) - (2 * r + 1) * 2 - 1
    return cnt

def in_cir(r):
    cnt = 0
    bound = 0
    for x in range(r+1):
        y = math.sqrt(r*r - x*x)
        ori = y
        y = math.floor(y)
        if ori == y:
            bound += 1
        cnt += (y+1)
    cnt = (cnt * 4) - (2 * r + 1) * 2 - 1 - (bound * 4 - 4)
    return cnt

def solution(r1, r2):
    answer = out_cir(r2) - in_cir(r1)
    return answer