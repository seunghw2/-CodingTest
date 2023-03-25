let input = readLine()!.split(separator: " ").map{Int(String($0))!}

let N = input[0]
let M = input[1]

var arr: [[Int]] = Array(repeating: [], count: N+1)

for _ in 0..<M{
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    arr[input[0]].append(input[1])
    arr[input[1]].append(input[0])
}

func bfs(_ start: Int) -> Int{
    var queue: [(Int, Int)] = []

    var cnt = Array(repeating: Int.max, count: N+1)
    cnt[0] = 0
    var res = 0
    
    queue.append((start, 0))
    while !queue.isEmpty{
        let popItem = queue.removeFirst()
        if popItem.1 <= cnt[popItem.0]{
            cnt[popItem.0] = popItem.1
            for item in arr[popItem.0]{
                queue.append((item, popItem.1 + 1))
            }
        }
        else{
            continue
        }
    }
    for item in cnt{
        res += item
    }
    return res
}

var minv = bfs(1)
var minidx = 1

for i in 2...N{
    if minv > bfs(i){
        minv = bfs(i)
        minidx = i
    }
}
print(minidx)
