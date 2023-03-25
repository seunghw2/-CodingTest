import heapq
import sys

maxHeap = []

N = int(sys.stdin.readline())

for _ in range(N):
    x = int(sys.stdin.readline())
    if x == 0:
        if len(maxHeap) == 0:   # 만약 배열 길이가 0이라면 0 출력
            print(0)
        else:   # 가장 큰 값 pop
            print(heapq.heappop(maxHeap)[1])
    else:   # 배열에 추가
        heapq.heappush(maxHeap, (abs(x), x))    # heapq는 작은 순으로 정렬되기 때문에 -x로 정렬시킴