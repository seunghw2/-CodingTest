# list 'operator'에는 +, -, *, %가 들어갈 수 있으며, 각각의 연산자가 여러개 들어갈 수 있다.
# 'operator'에서 나올 수 있는 순열을 전부 구한다.
# permutation을 라이브러리에서 가져온다.
# 중복되는 순열은 하나로 취급한다.

from itertools import permutations

N = int(input())
num = list(map(int, input().split()))
plus, minus, mul, div = map(int, input().split())
operator = []
for _ in range(plus):
    operator.append('+')
for _ in range(minus):
    operator.append('-')
for _ in range(mul):
    operator.append('*')
for _ in range(div):
    operator.append('%')

operator_permutations = list(permutations(operator, len(operator)))
operator_permutations = list(set(operator_permutations))

res = []


for operator_permutation in operator_permutations:
    ans = num[0]
    for i in range(N-1):
        if operator_permutation[i] == '+':
            ans += num[i+1]
        elif operator_permutation[i] == '-':
            ans -= num[i+1]
        elif operator_permutation[i] == '*':
            ans *= num[i+1]
        else:
            if ans < 0 and num[i+1] > 0:
                ans = ((-1 * ans) // num[i+1]) * (-1)
            else:
                ans //= num[i+1]
    res.append(ans)

print(max(res))
print(min(res))
