package Structures

class Node (code : String, result : Double){
    var code = code
    var result = result

    override fun toString():String {
        return "$code ---- Result: $result"
    }
}