
class Link{
    public int value;
    public Link next;

    public Link(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }


}

public class Main {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);
        lista.displayList();
    }
}

class LinkedList{
    public Link firstLink;
    LinkedList(){
        this.firstLink=null;
    }

    public boolean isVid(){
        return firstLink==null;
    }

    public void insert(int value){
        Link newLink = new Link(value);
        if (isVid()==true)
        {
            firstLink=newLink;
        }
        else
        {
            Link currentLink=firstLink;
            while(currentLink.next!=null){
                currentLink=currentLink.next;
            }
            currentLink.next=newLink;
        }

    }

    public void displayList(){
        Link theLink = firstLink;
        while (theLink!=null)
        {
            System.out.println(theLink.getValue());
            theLink=theLink.next;
        }
    }
}
