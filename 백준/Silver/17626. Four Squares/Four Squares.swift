import Foundation

let N = Int(readLine()!)!
var square: Set<Int> = []
var doubsquare: Set<Int> = []

for i in 1...223{
    square.insert(i*i)
}

for i in square{
    for j in square{
        doubsquare.insert(i+j)
    }
}

if square.contains(N){
    print(1)
    exit(0)
}
if doubsquare.contains(N){
    print(2)
    exit(0)
}
for i in square{
    if doubsquare.contains(N - i){
        print(3)
        exit(0)
    }
}
print(4)
