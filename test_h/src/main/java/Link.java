

import java.util.HashMap;

public class Link {

    static class node{   //声明链表节点类
        Object value;
        node next;
        node(Object o){
            this.value = o;
        }
    }

    static node head; //头结点
    /**
     * 单链表是否有环
     */
    //思路：使用快慢指针，慢指针每次走一步，快指针每次走两步，当链表有环时，快指针会一直在环中，当慢指针进入环后，快指针最后一定会追上慢指针，
    // 就像环形跑道上的两个人一样，如果速度不一致那么最后快者那个会领先一圈追上慢者，当两指针相遇时则说明链表存在环。
    // 平均时间复杂度为O（n），空间复杂度为O（1）

    public static boolean circle() {
        if (head == null || head.next == null) {
            return false;
        }

        node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;  //若为true，则证明有环
            }
        }
        return false;
    }


    /**
     * 单链表若有环，求环的长度
     */
    //求环的长度也很简单，同样利用快慢指针的思路，两个指针同时从环上的同一点出发，当它们再次相遇时，慢指针走了s步，快指针走了2s步，它们依然在起点处相遇，环的长度即为s。
    // 平均时间复杂度为O（n），空间复杂度为O（1）
    public static int perimeter() {
        node slow = head.next, fast = head.next.next;
        //第一步，先让两个指针指向环上的同一点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //计算环长度逻辑
        int perimeter = 1;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            perimeter++;
        }
        return perimeter;
    }


    /**
     * 单链表若有环，求环的入口
     */
    //我们可以用一个HashMap，以节点为键，节点下标为值，当用put（）放入重复节点时，就会返回该节点的下标。平均时间复杂度和空间复杂度均为为O（n），代码如下：
    public static int intersection() {
        HashMap<node,Integer> map = new HashMap<node,Integer>();
        node p = head;
        int step = 0;
        Integer tmp;
        while(p!=null) {
            tmp = map.put(p,step++);
            if(tmp!=null)
                return tmp;
            p = p.next;
        }
        return step;
    }


    /**
     * 求两个链表的第一个交叉点
     */


}
