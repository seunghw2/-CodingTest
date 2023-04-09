let N = Int(readLine()!)!
var arr: [String: Int] = [:]

for _ in 1...N{
    let s: String = readLine()!
    arr[s] = s.count
}

let brr = arr.sorted{ (first, second) in
    if first.value == second.value{
        return first.key < second.key
    }
    else{
        return first.value < second.value
    }
}

for item in brr{
    print(item.key)
}
