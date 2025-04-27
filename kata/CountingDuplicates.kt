package kata

/*
Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string. The input string can be assumed to
contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
*/

fun duplicateCount(input: String): Int {
    var counter = 0
    var inputTemp = input
    inputTemp.forEach { singleLetter ->
        val singleLetterIndex = inputTemp.indexOf(singleLetter, inputTemp.indexOf(singleLetter) + 1)
        if (singleLetterIndex > 0) {
            inputTemp = inputTemp.replace(singleLetter.toString(), "")
            counter++
        }
    }
    return counter
}

fun `abcde returns zero`() {
    print("${0 == duplicateCount("abcde")}\n")
}

fun `abcdea returns one`() {
    print("${1 == duplicateCount("abcdea")} ${duplicateCount("abcdea")}\n")
}

fun `indivisibility returns one`() {
    print("${1 == duplicateCount("indivisibility")}\n")
}

fun `really long string containing duplicates returns three`() {
    val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
    print("${3 == duplicateCount(text)}\n")
}

fun main() {
    `abcde returns zero`()
    `abcdea returns one`()
    `indivisibility returns one`()
    `really long string containing duplicates returns three`()
}