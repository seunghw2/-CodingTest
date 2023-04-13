import Foundation

let N = Int(readLine()!)!
var arr: [(String, Int, Int)] = []

for i in 1...N{
    let input = readLine()!.split(separator: " ").map{String($0)}
    arr.append((input[1], Int(input[0])!, i))
}

let brr = arr.sorted{
    if $0.1 == $1.1{
        return $0.2 < $1.2
    }
    else{
        return $0.1 < $1.1
    }
}

for item in brr{
    print(item.1, item.0)
}
