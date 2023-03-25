from collections import deque

T = int(input())
for _ in range(T):
    func = list(input())
    n = int(input())

    arr_tmp = []
    inp = input()

    arr_tmp = inp.split(",")

    tmp = list(arr_tmp[0])
    del tmp[0]
    arr_tmp[0] = ''.join(tmp)
    tmp = list(arr_tmp[-1])
    del tmp[-1]
    arr_tmp[-1] = ''.join(tmp)

    if n:
        arr = list(map(int, arr_tmp))
    else:
        arr = []
    queue = deque(arr)
    suc = True

    normal = True
    for item in func:
        if item == 'R':
            normal = False if normal else True
        elif item == 'D':
            if queue:
                queue.popleft() if normal else queue.pop()
            else:
                print("error")
                suc = False
                break

    if suc:
        if not normal:
            queue.reverse()
        print("[", ','.join(map(str, queue)), "]", sep="")