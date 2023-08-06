import sys
input = sys.stdin.readline

RIGHT = 0
LEFT = 1
DOWN = 2

START = -1
EXTRA = 10

y, x = map(int, input().split())
arr = []

for i in range(y):
    arr.append(list(map(int, input().split())))

brr = []

def move(i, j, cnt, tot, dir, arr_dir):

    if cnt == 0:    # 초기화
        arr_dir.clear()
        arr_dir.append(i)
        arr_dir.append(j)

    if i < 0 or i >= x or j < 0 or j >= y:  # 실패할 경우
        # print(arr_dir, "FAIL")
        arr_dir.pop()
        return 0

    tot += arr[j][i]  # 합
    cnt += 1  # 방문 횟수 증가

    if cnt == 4:  # 종료 조건 - 성공
        brr.append(tot)
        # print(arr_dir, "SUCCESS", tot)
        arr_dir.pop()
        return 0

    if dir != LEFT:
        arr_dir.append("RIGHT")
        move(i + 1, j, cnt, tot, RIGHT, arr_dir)

    if dir != RIGHT:
        arr_dir.append("LEFT")
        move(i - 1, j, cnt, tot, LEFT, arr_dir)

    arr_dir.append("DOWN")    # 위로 이동하는 코드는 필요없음!
    move(i, j + 1, cnt, tot, DOWN, arr_dir)

    if cnt == 3:
        if arr_dir[2] == "RIGHT" and arr_dir[3] == "RIGHT":
            arr_dir.append("EXTRA")
            move(i - 1, j + 1, cnt, tot, EXTRA, arr_dir)
            arr_dir.append("EXTRA")
            move(i - 1, j - 1, cnt, tot, EXTRA, arr_dir)

        elif arr_dir[2] == "DOWN" and arr_dir[3] == "DOWN":
            arr_dir.append("EXTRA")
            move(i + 1, j - 1, cnt, tot, EXTRA, arr_dir)
            arr_dir.append("EXTRA")
            move(i - 1, j - 1, cnt, tot, EXTRA, arr_dir)

    arr_dir.pop()


arr_dir = []
# move(2, 1, 0, 0, START, arr_dir)

for j in range(y):
    for i in range(x):
        move(i, j, 0, 0, -1, arr_dir)

print(max(brr))