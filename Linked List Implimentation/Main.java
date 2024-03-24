class Linked_List{
    private ListNode head = null;  // Head of the linked list

    // Inner class representing a node in the linked list
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            val = value;
            next = null;
        }
    }

    // Method to add a node at the beginning of the linked list
    public void addFirst(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    // Method to add a node at the end of the linked list
    void addLast(int value){
        ListNode node = new ListNode(value);
        if(head == null){
            head = node;
        }
        else{
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    // Method to get the size of the linked list
    int size(){
        ListNode temp = head;
        int node_count = 0;
        while (temp != null){
            temp = temp.next;
            node_count++;
        }
        return node_count;
    }

    // Method to add a node at a specified index in the linked list
    void add(int index, int value){
        if(index <= size() && index >= 0){
            if(index == 0){
                addFirst(value);
            }
            else if(index == size()){
                addLast(value);
            }
            else{
                ListNode node = new ListNode(value);
                ListNode temp = head;
                while (index > 1 && temp.next != null){
                    index--;
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
        }
        else{
            throw new RuntimeException("IndexOutOfBoundsException");
        }
    }

    // Method to remove the first node from the linked list
    public int removeFirst(){
        if (head == null){
            throw new RuntimeException("NoSuchElementException");
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    // Method to remove the last node from the linked list
    public int removeLast(){
        if (head == null){
            throw new RuntimeException("NoSuchElementException");
        }
        else if (head.next == null) {
            return removeFirst();
        }
        else{
            ListNode temp = head;
            while(temp.next != null && temp.next.next != null){
                temp = temp.next;
            }
            int value = temp.next.val;
            temp.next = null;
            return value;
        }
    }

    // Method to remove a node at a specified index from the linked list
    int remove(int index){
        if(index < size() && index >= 0){
            if(index == 0){
                return removeFirst();
            }
            else if(index == size()-1){
                return removeLast();
            }
            else{
                ListNode temp = head;
                while (index > 1 && temp.next != null){
                    index--;
                    temp = temp.next;
                }
                int value = temp.next.val;
                temp.next = temp.next.next;
                return value;
            }
        }
        else{
            throw new RuntimeException("IndexOutOfBoundsException");
        }
    }

    /*
    // Method to retrieve the value of the first element
    public int getFirst(){
        // Practice
    }

    // Method to retrieve the value of the last element
    public int getLast(){
        // Practice
    }

    // Method to retrieve the value of the element at a specified index
    public int get(int index){
        // Practice
    }
    */

    // Method to set the value of the element at a specified index
    public int set(int index, int value){
        if(index < size() && index >= 0){
            ListNode temp = head;
            while (index > 0 && temp.next != null){
                index--;
                temp = temp.next;
            }
            int removed_value = temp.val;
            temp.val = value;
            return removed_value;
        }
        else{
            throw new RuntimeException("IndexOutOfBoundsException");
        }
    }

    // Method to clear the linked list
    public void clear(){
        head = null;
    }

    // Method to display the elements of the linked list
    public void display(){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp);
    }
}

public class Main {
    public static void main(String[] args) {
        Linked_List li = new Linked_List();
        /*
        li.addFirst(10);
        li.addFirst(20);
        li.addFirst(30);
        li.addFirst(40);
        li.addFirst(50);
        li.addFirst(60);
        li.display();
        */

        li.addLast(10);
        li.addLast(20);
        li.addLast(30);
        li.addLast(40);
        li.addLast(50);
        li.display();

        /*
        li.add(6, 100);
        li.display();

        System.out.println(li.removeFirst());
        System.out.println(li.removeFirst());
        System.out.println(li.removeFirst());
        li.display();

        System.out.println(li.removeLast());
        System.out.println(li.removeLast());
        System.out.println(li.removeLast());
        li.display();

        System.out.println(li.remove(2));
        System.out.println(li.remove(-1));
        li.display();

        li.clear();
        li.display();

        li.display();
        System.out.println(li.set(0, 100));
        System.out.println(li.set(4, 100));
        System.out.println(li.set(10, 100));
        li.display();
        */
    }
}