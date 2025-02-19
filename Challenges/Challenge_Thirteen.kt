/*********************************************************************************************************************************************************
* QUESTION:
* The password is hard to crack if it contains at least A uppercase letters, at least B lowercase letters, at least C digits, and includes exactly N symbols. Also, a password cannot contain two or more same characters coming one after another. For a given numbers A, B, C, N you should output a password that matches these requirements.
*
* It is guaranteed A, B, C, and N are non-negative integers and A + B + C <= N. Keep in mind, that any parameter can be equal to zero. It means that it's ok if the password doesn't contain symbols of such type.
**********************************************************************************************************************************************************/

// SOLUTION
fun main() {
    val(a, b, c, n) = readln().split(" ").map { it.toInt() }
    val upperSet = (1..a).map { ('A'..'Z').joinToString("").random() }
    val lowerSet = (1..b).map { ('a'..'z').joinToString("").random() }
    val digits = (1..c).map { ('0'..'9').joinToString("").random() }
    val pas = upperSet + lowerSet + digits
    val addPass = (0 until n - pas.size).map { ('0'..'z').joinToString("").random() }
    var password = pas + addPass
    var i = 0
    while (i < password.size - 1) {
        while (password[i] == password[i + 1]) {
            password = password.shuffled()
            i = 0
        }
        i++
    }
    println(password.joinToString(""))
}
