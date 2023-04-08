let N = Int(readLine()!)!
var arr: [Int] = []

for _ in 1...N{
    arr.append(Int(readLine()!)!)
}
for item in arr.sorted(){
    print(item)
}
