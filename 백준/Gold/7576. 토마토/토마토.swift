import Foundation

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let M = input[0]
let N = input[1]

var visit: [(Int, Int, Int)] = []
var res: Int = 0

var arr: [[Int]] = []

for _ in 0..<N{
    arr.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}


for y in 0..<N{
    for x in 0..<M{
        if arr[y][x] == 1{
            visit.append((x, y, 0))
        }
    }
}

let xx = [0, 0, -1, 1]
let yy = [-1, 1, 0, 0]
var id = 0

while id < visit.count{
    let item = visit[id]
    id += 1
    
    let x = item.0
    let y = item.1
    var day = item.2
    res = max(res, day)

    for idx in 0...3{
        let nx = x+xx[idx]
        let ny = y+yy[idx]
        if nx >= 0 && nx < M && ny >= 0 && ny < N{
            if arr[ny][nx] == 0{
                visit.append((nx, ny, day+1))
                arr[ny][nx] = 1
//                print(visit)
//                for item in arr{
//                    print(item)
//                }
            }
        }
    }
}

for temp in arr{
    for item in temp{
        if item == 0{
            print(-1)
            exit(0)
        }
    }
}

print(res)
