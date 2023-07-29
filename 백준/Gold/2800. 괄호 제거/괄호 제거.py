from itertools import combinations

stack = list()
opt = list()
sent = input()
res = list()

for i in range(len(sent)):
    if sent[i] == '(':
        stack.append(i)
    elif sent[i] == ')':
        tmp = stack.pop()
        opt.append([tmp, i])

for i in range(1, len(opt)+1):
    combi = list(combinations(opt, i))
    for items in combi: # [6,10], [3, 11]
        noShow = list()
        for item in items:  # [6,10]
            for i in item:  # 6
                noShow.append(i)

        tmp = list()
        for i in range(len(sent)):
            if i not in noShow:
                tmp.append(sent[i])
        res.append(tuple(tmp))

res = list(set(res))
res.sort()

for items in res:
    if len(items) != 0:
        for item in items:
            for i in item:
                print(i, end='')
        print()