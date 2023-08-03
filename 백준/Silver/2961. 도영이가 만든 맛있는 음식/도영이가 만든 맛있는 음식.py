from itertools import combinations
import sys
input = sys.stdin.readline
s = []

N = int(input())

# 쌍으로 입력받음
for _ in range(N):
    x = list(map(int, input().split()))
    s.append(x)

ans = abs(s[0][0] - s[0][1])  # 초기값 설정

for i in range(1, N+1):     # 원소 개수가 1인 것 ~ N인것 설정
    x = list(combinations(s, i))    # 원소 개수가 i인 모든 조합을 list에 넣음
    # print(x)
    for j in range(len(x)):     # 가능한 조합의 개수번만큼 실행
        mul = 1     # 초기값 설정
        add = 0
        for k in range(i):  # 만들어진 조합 내에서 연산
            mul *= x[j][k][0]
            add += x[j][k][1]
            
        ans = min(ans, abs(mul - add))  #더 작은 값이 있다면 교체

print(ans)