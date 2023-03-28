# 16928
from collections import deque

global queue, snake, ladder
queue = deque()
queue.append([1,0])
snake = {}
ladder = {}
cnt = {}

def BFS():
    global queue, snake, ladder
    # 계속 진행
    while True:
        # x = queue에서 pop
        x = queue.popleft()
        popnum = x[0]
        popcnt = x[1]
        # 만약 x가 100이라면
        if popnum == 100:
            # 종료, 프린트
            print(popcnt)
            break
        elif popnum > 100:
            continue
        else:
            # 이미 방문한 포인트라면 continue
            if popnum in cnt:
                continue
            else:
                cnt[popnum] = popcnt
            # x+1 ~ x+6 중에서
            for i in range(popnum + 1, popnum+7):
                # ladder에 해당하는 값이 있다면 queue에 추가
                if i in ladder:
                    queue.append([ladder[i], popcnt+1])
                # snake가 아닌 것중 최대값 queue에 추가
                elif i in snake:
                    queue.append([snake[i], popcnt+1])
                else:
                    queue.append([i, popcnt+1])


N, M = map(int, input().split(" "))
for _ in range(N):
    a, b = map(int, input().split(" "))
    ladder[a] = b

for _ in range(M):
    a, b = map(int, input().split(" "))
    snake[a] = b


BFS()