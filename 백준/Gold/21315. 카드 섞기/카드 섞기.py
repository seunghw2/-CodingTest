def shuffle(k, cards):
    btm = len(cards)
    
    for i in range(1, k+2):
        node = k + 1 - i

        node = 2 ** node

        
        next_cards = cards[btm-node: btm]
        next_cards += cards[:btm-node]
        next_cards += cards[btm:]

        btm = node
        cards = next_cards

        #print(cards, k , node)
    return cards
    
N = int(input())

origin = list(map(int, input().split()))

cards_origin = [_ for _ in range(1, N+1)]

ans = -1
check = False


for i in range (1, 10):
    for j in range (1,10):
        cards = cards_origin.copy()
        temp = shuffle(j, cards)
        if origin == shuffle(i, temp):
            print(j, i)
            check = True
            break
        #print("============")
    if check:
        break