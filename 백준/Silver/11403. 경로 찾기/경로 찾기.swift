let N = Int(readLine()!)!
var arr: [[Int]] = []

for _ in 0..<N{
    arr.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

var visited = Array(repeating: 0, count: N)

func dfs(_ start: Int, _ dest: Int){
    if arr[start][dest] == 1{
        if visited[dest] == 0{
            visited[dest] = 1
            for i in 0..<N{
                dfs(dest, i)
            }
        }
    }
}

for i in 0..<N{
    visited = Array(repeating: 0, count: N)
    for j in 0..<N{
        if arr[i][j] == 1{
            dfs(i, j)
        }
    }
    for item in visited{
        print(item, terminator: " ")
    }
    print()
}
