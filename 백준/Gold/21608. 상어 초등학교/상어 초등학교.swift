import Foundation

let n = Int(readLine()!)!
let num = n * n
let level = [0, 1, 10, 100, 1000]
var chair = Array(repeating: Array(repeating: -1, count: n + 2), count: n + 2)
var point = Array(repeating: Array(repeating: 0, count: 4), count: num)
var result = 0

for i in 1...n {
    for j in 1...n {
        chair[i][j] = 0
    }
}

for _ in 0..<num {
    let input =  readLine()!.components(separatedBy: " ").map {Int($0)!}
    let student = input[0]
    let like = input[1...4]
    
    for i in 0..<4 {
        point[student - 1][i] = input[i + 1]
    }

    
    var arr:[Int] = []
    
    for i in 1...n {
        for j in 1...n {
            if chair[i][j] == 0 {
                var p = 0
                if like.contains(chair[i][j - 1]) {
                    p += 5
                }
                if like.contains(chair[i - 1][j]) {
                    p += 5
                }
                if like.contains(chair[i + 1][j]) {
                    p += 5
                }
                if like.contains(chair[i][j + 1]) {
                    p += 5
                }
                
                if chair[i][j - 1] == 0 {
                    p += 1
                }
                if chair[i - 1][j] == 0 {
                    p += 1
                }
                if chair[i + 1][j] == 0 {
                    p += 1
                }
                if chair[i][j + 1] == 0 {
                    p += 1
                }
                
                arr.append(p)
            } else {
                arr.append(-1)
            }
        }
    }
    
    if let index = arr.firstIndex(of: arr.max()!) {
        let i = index / n
        let j = index % n
        chair[i + 1][j + 1] = student
    }
    
}

for i in 1...n {
    for j in 1...n {
        var count = 0
        let num = chair[i][j] - 1
        
        if point[num].contains(chair[i][j - 1]) {
            count += 1
        }
        if point[num].contains(chair[i - 1][j]) {
            count += 1
        }
        if point[num].contains(chair[i + 1][j]) {
            count += 1
        }
        if point[num].contains(chair[i][j + 1]) {
            count += 1
        }
        result += level[count]
        
    }
}

print(result)