import sys
input = sys.stdin.readline

N, M = map(int, input().split())

T = []
for _ in range(N):
    T.append(int(input()))

# 0부터 최소 시간이 걸리는 심사대 * 인원 수(하나의 심사대를 이용하는 방법 중 가장 빠른 시간)로 이진 탐색
start = 0
end = min(T) * M

while start < end:
    mid = (start + end) // 2
    quotient = 0
    for item in T:      # 각각의 심사대에서 mid초 동안 몇 몇을 받을 수 있는 지 계산 후 모두 합함.
        quotient += (mid // item)
    if M <= quotient:    # 정해진 인원(M)보다 같거나 많은 사람을 받은 경우 (같은 경우를 추가한 이유 : 더 작은 시간이 존재할 가능성 - 백준 예시 28초, 29초 : 동일하게 10명받을 수 있음)
        end = mid
    elif M > quotient:    # 정해진 인원(M)보다 적은 사람을 받은 경우
        start = mid + 1

print(start)