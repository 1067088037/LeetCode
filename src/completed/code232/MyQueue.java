package completed.code232;

import java.util.Stack;

class MyQueue {

    private final Stack<Integer> main = new Stack<>();
    private final Stack<Integer> assist = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        main.push(x);
    }

    public int pop() {
        while (!main.isEmpty()) {
            assist.push(main.pop());
        }
        int ret = assist.pop();
        main.clear();
        while (!assist.isEmpty()) {
            main.push(assist.pop());
        }
        return ret;
    }

    public int peek() {
        while (!main.isEmpty()) {
            assist.push(main.pop());
        }
        int ret = assist.peek();
        while (!assist.isEmpty()) {
            main.push(assist.pop());
        }
        return ret;
    }

    public boolean empty() {
        return main.isEmpty();
    }
}