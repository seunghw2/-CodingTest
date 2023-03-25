let N = Int(readLine()!)!
var arr: [(Int, Int)] = []
var res: [(Int, Int)] = []

for _ in 1...N{
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    arr.append((input[0], input[1]))
}

arr.sort{
    if $0.1 == $1.1{
        return $0.0 < $1.0
    }
    else{
        return $0.1 < $1.1
    }
}


for item in arr{
    if res.count != 0{
        if item.0 < res[res.endIndex - 1].1{
            continue
        }
    }
    res.append(item)
}

print(res.count)
