/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) return null;

        Node newhead = new Node(head.val);
        Map<Node , Node> map = new HashMap<>();
        map.put(head, newhead);
        

        Node oldtemp = head.next;
        Node newtemp = newhead;

        while(oldtemp != null){
            Node copynode = new Node(oldtemp.val);
            map.put(oldtemp, copynode);
            newtemp.next = copynode;

            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }

        oldtemp = head;
        newtemp = newhead;

        while(oldtemp != null){
            newtemp.random = map.get(oldtemp.random);
            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }
        return newhead;

    }
}