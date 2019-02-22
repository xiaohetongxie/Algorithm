package src;

import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class QueueToStack {

//思路：将queue1用作进栈出栈，queue2作为一个中转站
//入栈时，直接压入queue1中
//出栈时，先将queue1中的元素除最后一个元素外依次出队列，并压入队列queue2中，将留在queue1中的最后一个元素出队列即为出栈元素，最后还要把queue2中的元素再次压入queue1中

    //进栈操作
    void stackpush(Queue<Integer> q1, Queue<Integer> q2, int m)
    {
        q1.add(m);
    }

    //出栈操作
    void stackpop(Queue<Integer> q1,Queue<Integer> q2,int m)
    {
        int p = q1.size();
        for (int i=0;i<p-1;i++)
        {
            q2.add(q1.remove());
        }

        m = q1.remove();//m为出栈元素

        int l = q2.size();
        for (int j = 0;j<l;j++)
        {
            q1.add(q2.remove());
        }
    }
}
