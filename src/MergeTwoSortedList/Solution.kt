package MergeTwoSortedList

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 *  */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {


        if ((list1 == null && list2 != null) || (list1 != null && list2 == null)) {
            if (list2 != null) {
                val returnList = ListNode(list2.`val`)
                returnList.next = mergeTwoLists(null, list2.next)
                return returnList
            }
            if (list1 != null) {
                val returnList = ListNode(list1.`val`)
                returnList.next = mergeTwoLists(null, list1.next)
                return returnList
            }

        }

        if (list1 != null && list2 != null) {

            if (list1.`val` > list2.`val`) {
                val list = ListNode(list2.`val`)
                list.next = mergeTwoLists(list1, list2.next)
                return list
            }
            if (list2.`val` > list1.`val`) {
                val list = ListNode(list1.`val`)
                list.next = mergeTwoLists(list2, list1.next)
                return list
            }

            list2.next = mergeTwoLists(list1.next, list2.next)
            list1.next = list2


            return list1
        }

        return null
    }
}

fun main() {
    val list1One = ListNode(-9)
    val list1Two = ListNode(3)


    list1One.next = list1Two

    val list2One = ListNode(5)
    val list2Two = ListNode(7)


    list2One.next = list2Two

    val resList = Solution().mergeTwoLists(list1One, list2One)
    resList?.let {
        var currentList = it
        do {
            println(currentList.`val`)
            if (currentList.next == null) break
            currentList = currentList.next!!
        } while (true)


    }
}