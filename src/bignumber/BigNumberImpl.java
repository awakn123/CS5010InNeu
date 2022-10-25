package bignumber;

public class BigNumberImpl implements BigNumber{

    private Node head;
    private Node tail;

    public BigNumberImpl() {
        this.head = new Node(0);
        this.tail = this.head;
    }

    public BigNumberImpl(String bigNumberStr) {
        char[] chars = bigNumberStr.toCharArray();
        Node node = null;
        Node prev = null;
        for (char c: chars) {
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
        for (int i = 0; i< shiftNum; i++) {
            node.next = new Node(0);
            node = node.next;
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
        } else {
            node.next = null;
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
        bigNumber.add(this);
        return bigNumber;
    }

    @Override
    public void addDigit(int digit) {

    }

    @Override
    public BigNumber add(BigNumber bigNumber) {
        if (!(bigNumber instanceof BigNumberImpl)) {
            return this.add(new BigNumberImpl(bigNumber.toString()));
        }

        BigNumberImpl n2 = (BigNumberImpl) bigNumber;
        Node last1 = this.tail;
        Node last2 = n2.getTail();
        while (last1 != null && last2 != null) {

        }
        return null;
    }

    @Override
    public int compareTo(BigNumber o) {
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
    }
}
