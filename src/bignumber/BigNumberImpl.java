package bignumber;

public class BigNumberImpl implements BigNumber {

    private Node head;
    private Node tail;

    public BigNumberImpl() {
        this.head = new Node(0);
        this.tail = this.head;
    }

    public BigNumberImpl(String bigNumberStr) {
        char[] chars = bigNumberStr.toCharArray();
        Node node = null;
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("The string contains a nonDigit character:" + c);
            }
            if (node == null) {
                this.head = new Node(Character.digit(c, 10));
                node = this.head;
            } else {
                node.next = new Node(Character.digit(c, 10), node);
                node = node.next;
            }
        }
        this.tail = node;
    }

    public BigNumberImpl(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Node node = head;
        while (node != null) {
            out.append(node.val);
            node = node.next;
        }
        return out.toString();
    }

    @Override
    public int length() {
        int l = 0;
        Node node = head;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

    @Override
    public void shiftLeft(int shiftNum) {
        if (shiftNum < 0) {
            shiftRight(-shiftNum);
            return;
        }
        if (shiftNum == 0)
            return;
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        for (int i = 0; i < shiftNum; i++) {
            node.addNext(new Node(0));
        }
    }

    @Override
    public void shiftRight(int shiftNum) {
        if (shiftNum < 0) {
            shiftLeft(-shiftNum);
            return;
        }
        if (shiftNum == 0)
            return;
        Node node = getNodeFromRight(shiftNum);
        if (node == null) {
            head = new Node(0);
            tail = head;
        } else {
            node.next = null;
            tail = node;
        }
    }

    @Override
    public int getDigitAt(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("The position cannot be negative");
        }
        Node node = getNodeFromRight(position);
        if (node == null) {
            throw new IllegalArgumentException("The position is too big:" + position);
        }
        return node.val;
    }

    /**
     * get the node from right, start from 0
     *
     * @param position
     * @return
     */
    private Node getNodeFromRight(int position) {
        Node node = head;
        Node lastNode = head;
        int l = 0;
        while (node != null) {
            node = node.next;
            if (l > position) {
                lastNode = lastNode.next;
            }
            l++;
        }
        if (l <= position) {
            return null;
        }
        return lastNode;
    }

    @Override
    public BigNumber copy() {
        BigNumberImpl bigNumber = new BigNumberImpl();
        return bigNumber.add(this);
    }

    @Override
    public void addDigit(int digit) {
        Node curNode = this.tail;
        int carry = 0;
        while (digit != 0 && carry != 0) {
            curNode.val = digit % 10 + curNode.val + carry;
            carry = curNode.val / 10;
            curNode.val = curNode.val % 10;
            if (curNode.prev == null) {
                curNode.addPrev(new Node(0));
            }
            curNode = curNode.prev;
            digit /= 10;
        }
        if (curNode.val == 0) {
            curNode = curNode.next;
            curNode.prev = null;
        }
        if (curNode.prev == null) {
            this.head = curNode;
        }
    }

    @Override
    public BigNumber add(BigNumber bigNumber) {
        if (!(bigNumber instanceof BigNumberImpl)) {
            return this.add(new BigNumberImpl(bigNumber.toString()));
        }

        BigNumberImpl n2 = (BigNumberImpl) bigNumber;
        Node last1 = this.tail;
        Node last2 = n2.getTail();
        Node tail = new Node(0);
        Node currentHandleNode = tail;
        int carry = 0;
        while (last1 != null && last2 != null) {
            currentHandleNode.val = last1.val + last2.val + carry;
            carry = currentHandleNode.val / 10;
            currentHandleNode.val = currentHandleNode.val % 10;

            last1 = last1.prev;
            last2 = last2.prev;
            currentHandleNode.addPrev(new Node(0));
        }

        Node iterNode = last1 == null ? last2 : last1;

        while (iterNode != null) {
            currentHandleNode.val = iterNode.val + carry;
            carry = currentHandleNode.val / 10;
            currentHandleNode.val = currentHandleNode.val % 10;

            iterNode = iterNode.prev;
            currentHandleNode.addPrev(new Node(0));
        }

        if (carry != 0) {
            currentHandleNode.val = carry;
        } else {
            currentHandleNode = currentHandleNode.next;
            currentHandleNode.prev = null;
        }

        return new BigNumberImpl(currentHandleNode, tail);
    }

    @Override
    public int compareTo(BigNumber o) {
        int l1 = this.length(), l2 = o.length();
        if (l1 < l2) {
            return -1;
        } else if (l1 > l2) {
            return 1;
        }
        if (!(o instanceof BigNumberImpl)) {
            return this.compareTo(new BigNumberImpl(o.toString()));
        }
        Node node1 = this.getHead();
        Node node2 = ((BigNumberImpl) o).getHead();
        while (node1 != null & node2 != null) {
            if (node1.val < node2.val) {
                return -1;
            } else if (node1.val > node2.val) {
                return 1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return 0;
    }

    public class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }

        public void addPrev(Node prev) {
            this.prev = prev;
            prev.next = this;
        }

        public void addNext(Node next) {
            this.next = next;
            next.prev = this;
        }

    }
}
