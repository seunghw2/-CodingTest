import sys
input = sys.stdin.readline

arr = [[-1, -1] for _ in range(26)]

N = int(input())
for _ in range(N):
    root, left, right = input().split()

    root = ord(root) - 65
    left = ord(left) - 65
    right = ord(right) - 65

    if left == -19:
        left = -1
    if right == -19:
        right = -1

    arr[root][0] = left
    arr[root][1] = right


def front(root):
    if root == -1:
        return
    print(chr(root + 65), end='')
    front(arr[root][0])
    front(arr[root][1])


def mid(root):
    if root == -1:
        return
    mid(arr[root][0])
    print(chr(root + 65), end='')
    mid(arr[root][1])


def back(root):
    if root == -1:
        return
    back(arr[root][0])
    back(arr[root][1])
    print(chr(root + 65), end='')


front(0)
print()
mid(0)
print()
back(0)
print()