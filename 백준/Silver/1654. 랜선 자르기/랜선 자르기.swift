let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let K = input[0]
let N = input[1]
var arr: [Int] = []

for _ in 0..<K{
    arr.append(Int(readLine()!)!)
}

func search(_ start: Int, _ end: Int)->Int{
    let m = (start + end) / 2
    if start > end{
        return m
    }
    var cnt = 0
    for item in arr{
        cnt += (item / m)
    }
    if cnt < N{
        return search(start, m-1)
    }
    else{
        return search(m+1, end)
    }
}

print(search(1, arr.max()!))