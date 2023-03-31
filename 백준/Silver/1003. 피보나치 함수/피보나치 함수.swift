var zer: [Int] = [1, 0]
var one: [Int] = [0, 1]

for i in 2...40{
    zer.append(zer[i-2] + zer[i-1])
}
for i in 2...40{
    one.append(one[i-2] + one[i-1])
}

let T = Int(readLine()!)!
for _ in 0..<T{
    let N = Int(readLine()!)!
    print(zer[N], one[N], terminator: " ")
    print()
}
