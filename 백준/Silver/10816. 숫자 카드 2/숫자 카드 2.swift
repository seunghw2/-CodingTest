let N = Int(readLine()!)!
var arr = readLine()!.split(separator: " ").map{Int($0)!}
let M = Int(readLine()!)!
var brr = readLine()!.split(separator: " ").map{Int($0)!}
var crr: [Int: Int] = [:]
var drr: [Int] = []

arr.sort()

for i in arr{
    if crr.keys.contains(i){
        crr[i]! += 1
    }
    else{
        crr[i] = 1
    }
}

for i in brr{
    if crr.keys.contains(i){
        drr.append(crr[i]!)
    }
    else{
        drr.append(0)
    }

}
for i in drr{
    print(i, terminator: " ")
}
