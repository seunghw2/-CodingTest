# 2417
def bisearch(left, right, target):
    mid = (left + right) // 2
    num = mid * mid
    if left > right:
        return mid+1
    if target > num:
        return bisearch(mid + 1, right, target)
    else:
        return bisearch(left, mid-1, target)


n = int(input())
print(bisearch(0, n, n))
