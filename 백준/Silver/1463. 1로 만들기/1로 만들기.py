def make_one(n,lst):
    if n==1:
        return 0
    elif lst[n] != -1:  #저장되어 있다면 불러오기
        return lst[n]
    else:               #저장안되어 있다면 저장하기
        if n % 6 == 0: 
            lst[n] = min(make_one(n//3,lst), make_one(n//2,lst)) +1
        elif n %3 == 0: 
            lst[n] = min(make_one(n//3,lst), make_one(n-1,lst)) +1
        elif n %2 == 0: 
            lst[n] = min(make_one(n//2,lst), make_one(n-1,lst)) +1
        else: 
            lst[n] = make_one(n-1,lst) +1
        return lst[n]


n = int(input())
case = [-1] * (n+1)         #DP에 사용할 리스트 생성
case[0],case[1] = False,0

print(make_one(n,case))