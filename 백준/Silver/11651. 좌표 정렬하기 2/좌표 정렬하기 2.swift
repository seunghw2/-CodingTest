let N = Int(readLine()!)!
var dic: [(Int, Int)] = []

for _ in 1...N{
    var input = readLine()!.split(separator: " ").map{Int(String($0))!}
    dic.append((input[0], input[1]))
}

let arr = dic.sorted(by: {
    if $0.1 == $1.1 {
        return $0.0 < $1.0
    }
    else {
        return $0.1 < $1.1
    }
})

for item in arr{
    print(item.0, item.1)
}
