def print_coins(R, coins):
    start = len(R) - 1

    if R[start] == -1:
        print ("No Solution Possible.")
        return

    print ("Coins:",)
    while start != 0:
        coin = coins[R[start]]
        print ("%d " % coin,)
        start = start - coin


def min_coins2(coins, total):
    cols = total + 1
    T =[0 if idx == 0 else float("inf") for idx in range(cols)]
    R = [-1 for _ in range(total + 1)]

    for j in range(len(coins)):
        for i in range(1, cols):
            coin = coins[j]
            if i >= coins[j]:
                if T[i] > 1 + T[i - coin]:
                    T[i] = 1 + T[i - coin]
                    R[i] = j
    print(R)
    print(T)
    print_coins(R, coins)
    return T[cols - 1]

if __name__ == '__main__':
    coins = [1, 5, 6, 8]
    total = 11
    expected = 2
    print(min_coins2(coins, total))
