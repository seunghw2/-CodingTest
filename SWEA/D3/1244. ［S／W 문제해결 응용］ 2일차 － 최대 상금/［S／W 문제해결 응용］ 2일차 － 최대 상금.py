T = int(input())
for test_case in range(1, T + 1):
    num, cnt = map(int, input().split())

    numset = [set() for _ in range(cnt+1)]
    numset[0].add(tuple(map(int, str(num))))
    ans = []

    for i in range(1, cnt+1):
        while numset[i-1]:
            popitem = numset[i-1].pop()
            popitem = list(popitem)
            for x in range(len(popitem)):
                for y in range(x+1, len(popitem)):
                    popitem[x], popitem[y] = popitem[y], popitem[x]
                    numset[i].add(tuple(popitem))
                    popitem[x], popitem[y] = popitem[y], popitem[x]



    for item in numset[cnt]:
        ans.append(list(item))

    listans = max(ans)
    print("#{0}".format(test_case), end=' ')
    for item in listans:
        print(item, end='')
    print()