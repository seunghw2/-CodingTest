import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))   # 입력받은 숫자 배열

sta = 0     # arr에서 최장 연속 부분 수열의 원소로 count중인 수열의 첫 index
end = 0     # arr에서 최장 연속 부분 수열의 원소로 count중인 수열의 마지막 index
res = 0     # 결과 값 (최장 연속 부분 수열의 길이)
dic = {}    # 딕셔너리 (값 : 값의 개수)

for X in arr:   # arr에 있는 원소 순서대로 봄.
    # 같은 게 있는지 체크
    if X in dic:    # X가 dic에 있는 경우
        dic[X] += 1
        end += 1
        if dic[X] > K:   # 개수가 K개 초과인 경우
            while True:   # 초과하는 아이템까지 개수 -1 처리 (3 2 5 5 6 4 4 5 로 5가 3번 나오면 3 2 5를 지워버림)
                item = arr[sta]
                sta += 1
                dic[item] -= 1
                if dic[item] < 0:       # 개수가 0보다 작으면 아예 삭제
                    del dic[item]
                if item == X:
                    break
    else:   # X가 dic에 없는 경우
        dic[X] = 1
        end += 1

    res = max(res, end - sta)
    # print(cnt, res)

print(res)