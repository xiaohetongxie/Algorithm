package src;

import java.util.Stack;


/**
 * 两个队列实现一个栈
 */


/**
 * 两个栈实现一个队列
 */

//压入元素直接压入stack1
//删除元素先查看stack2是否为空，非空则弹出；空则将stack1中元素取出，置于stack2中
public class StackQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        if (stack2.empty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}

