N = int(input())
arr = list(map(int, input().split()))

brr = set(arr)
brr = list(brr)
brr.sort()

dic = dict()
for idx in range(len(brr)):
    dic[brr[idx]] = idx

for idx in range(len(arr)):
    if idx != len(arr) - 1:
        print(dic[arr[idx]], end=' ')
    else:
        print(dic[arr[idx]])