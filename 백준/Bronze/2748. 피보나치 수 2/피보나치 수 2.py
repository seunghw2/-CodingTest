N = int(input())
arr = []
arr.append(0)
arr.append(1)
for i in range(2, N+1):
    arr.append(arr[i-2] + arr[i-1])



print(arr[N])