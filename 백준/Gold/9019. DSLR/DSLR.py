from collections import deque

def D(num):
    return (num << 1) % 10000

def S(num):
    if num == 0:
        return 9999
    else:
        return num - 1

def L(num):
    first = num // 1000
    rest = num - (first * 1000)
    return (rest * 10) + first

def R(num):
    last = num % 10
    rest = num - last
    return last * 1000 + (rest // 10)


T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    # queue : [값, 지금까지의 연산을 string으로]
    queue = deque()
    # A를 queue에 넣음
    queue.append([A, ""])
    visited = set()
    # 반복
    while True:
        # pop
        item = queue.popleft()
        # print(item)
        val = item[0]
        str = item[1]
        # A == B이면 종료
        if val == B:
            print(str)
            break
        # 아니라면
        else:
            # queue에 [D, S, L, R한 값, 지금까지의 연산 string+지금 연산] 추가
            if not L(val) in visited:
                queue.append([L(val), str+"L"])
                visited.add(L(val))
            if not R(val) in visited:
                queue.append([R(val), str+"R"])
                visited.add(R(val))
            if not D(val) in visited:
                queue.append([D(val), str+"D"])
                visited.add(D(val))
            if not S(val) in visited:
                queue.append([S(val), str+"S"])
                visited.add(S(val))
