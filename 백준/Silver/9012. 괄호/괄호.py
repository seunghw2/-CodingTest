# 9012

N = int(input())
for i in range(N):
    a = input()
    b = []
    for i in a:
        if i == '(':
            b.append(i)
        elif i == ')':
            if len(b) == 0:
                print("NO")
                break
            else:
                x = b.pop()
                if x == ')':
                    print("NO")
                    break
    else:
        if len(b) != 0:
            print("NO")
        else:
            print("YES")
            