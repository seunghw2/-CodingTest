import sys
input = sys.stdin.readline

A, B = map(int, input().split())
arrA = list(map(int, input().split()))
arrB = list(map(int, input().split()))
arrR = []

ptrA = 0
ptrB = 0

while ptrA + ptrB != A + B:
    # 한 배열에서 포인터가 끝까지 이동한 경우(반대쪽 배열에서 더 큰것만 남음) : 반대쪽 배열의 아이템 추가
    if ptrA == A:
        arrR.append(arrB[ptrB])
        ptrB += 1
    elif ptrB == B:
        arrR.append(arrA[ptrA])
        ptrA += 1

    # 포인터가 가리키는 아이템끼리 비교하여 작은것을 넣음.
    elif arrA[ptrA] <= arrB[ptrB]:
        arrR.append(arrA[ptrA])
        ptrA += 1
    elif arrA[ptrA] > arrB[ptrB]:
        arrR.append(arrB[ptrB])
        ptrB += 1

for item in arrR:
    print(item, end = ' ')

