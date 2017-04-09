
class Link {
    public int value;
    public Link next;

    public Link(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}

public class Main {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        Link node = new Link(2);
        lista.insert(node);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.removeByValue(4);
        lista.displayList();
    }
}

class LinkedList {
    public Link firstLink;

    LinkedList() {
        this.firstLink = null;
    }

    public boolean isVid() {
        return firstLink == null;
    }

    public void insert(int value) {
        Link newLink = new Link(value);
        if (isVid() == true) {
            firstLink = newLink;
        } else {
            Link currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = newLink;
        }
    }

    public void insert(Link node) {
        if (isVid() == true)
            firstLink = node;
        else {
            Link currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = node;
        }
    }

    public void displayList() {
        Link theLink = firstLink;
        while (theLink != null) {
            System.out.println(theLink.getValue());
            theLink = theLink.next;
            if (theLink == firstLink) {
                System.out.print(theLink.getValue());
                return;
            }
        }
    }

    public boolean isCircular() {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink = theLink.next;
            if (theLink == firstLink)
                return true;
        }
        return false;
    }

    public Link remoFirstLink() {
        Link linkReference = firstLink;
        while (firstLink.next != null) {
            firstLink = firstLink.next;
        }
        return linkReference;
    }

    public Link removeByValue(int value) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;

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
}
