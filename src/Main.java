
class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

public class Main {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        Node node = new Node(2);
        lista.insert(3);
        lista.insert(2);
        lista.insert(6);
        lista.insert(1);
        lista.insert(8);
        lista.insert(7);
        lista.displayList();
        lista.sort();
        lista.displayList();
        lista.reverse(6);
        lista.displayList();
    }
}

class LinkedList {
    public Node firstLink;

    LinkedList() {
        this.firstLink = null;
    }

    public boolean isVid() {
        return firstLink == null;
    }

    public void insert(int value) {
        Node newLink = new Node(value);
        if (isVid() == true) {
            firstLink = newLink;
        } else {
            Node currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = newLink;
        }
    }

    public void insert(Node node) {
        if (isVid() == true)
            firstLink = node;
        else {
            Node currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = node;
        }
    }

    public void displayList() {
        Node theLink = firstLink;
        while (theLink != null) {
            System.out.print(theLink.getValue() +" ");
            theLink = theLink.next;
            if (theLink == firstLink) {
                System.out.print(theLink.getValue());
                System.out.println();
                return;
            }
        }
        System.out.println();
    }

    public boolean isCircular() {
        Node theLink = firstLink;
        while (theLink != null) {
            theLink = theLink.next;
            if (theLink == firstLink)
                return true;
        }
        return false;
    }


    public Node removeByValue(int value) {
        Node currentLink = firstLink;
        Node previousLink = firstLink;

        while (currentLink.getValue() != value && currentLink != null) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        if (currentLink==firstLink) {
            firstLink = firstLink.next;
        }
        else{
            previousLink.next=currentLink.next;
        }
        return currentLink;
    }

    public void sort(){
        int count = 0;
        Node start = firstLink;
        Node current = null;
        Node node = null;
        Node temp = null;
        while(start!=null){
            count++;
            start=start.next;
        }
        for(int i=0;i<count;i++){
            current = node = firstLink;
            while(current.next !=null){
                if(current.getValue()> current.next.getValue())
                {
                    temp = current.next;
                    current.next = current.next.next;
                    temp.next = current;
                    if(current == firstLink) {
                        firstLink = node = temp;
                        //node = temp;
                    }
                    else{
                        node.next = temp;
                    }
                    current = temp;
                }
                node = current;
                current = current.next;
            }
        }
    }

    public void swaps(int k){

    }

   public void reverse(int k){
        int i=0;
        Node prev = null;
        Node current = firstLink;
        Node next = null;
        while(i < k && current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
            i++;
        }
        firstLink = prev;
        while(current!=null) {
            insert(current.getValue());
            current=current.next;
        }

    }

}
