import Foundation

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
var N = input[0]
var r = input[1]
var c = input[2]

var res: Int = 0

func pos(max: Int, x: Int, y: Int) -> Int{
    
    if y < max / 2{
        return (x < max / 2) ? 1 : 3
    }
    else{
        return (x < max / 2) ? 2 : 4
    }
}

while N >= 1{
    let max = Int(pow(2.0, Double(N)))
    
    let num = pos(max: max, x: r, y: c)
    res += (num - 1) * (max / 2) * (max / 2)
    N -= 1
    if num == 2 || num == 4{
        c -= (max / 2)
    }
    if num == 3 || num == 4{
        r -= (max / 2)
    }
}

print(res)
