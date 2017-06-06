
class List {
    public int value;
    public List next;

    public List(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value){this.value = value;}


}

public class Main {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        List node = new List(2);
        lista.insert(node);
        lista.insert(1);
        lista.insert(-2);
        lista.insert(10);
        lista.insert(9);
        lista.insert(node);
        System.out.println(lista.isCircular(node));

    }
}

class LinkedList {
    public List firstLink;

    LinkedList() {
        this.firstLink = null;
    }

    public List getFirstLink(){
        return firstLink;
    }

    public List getLastLink(){
        List focusNode=firstLink;
        while(focusNode.next!=null)
            focusNode = focusNode.next;
        return focusNode;
    }

    public boolean isVid() {
        return firstLink == null;
    }

    public void insert(int value) {
        List newLink = new List(value);
        if (isVid() == true) {
            firstLink = newLink;
        } else {
            List currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = newLink;
        }
    }

    public void insert(List node) {
        if (isVid() == true)
            firstLink = node;
        else {
            List currentLink = firstLink;
            while (currentLink.next != null) {
                currentLink = currentLink.next;
            }
            currentLink.next = node;
        }
    }

    public void displayList() {
        List theLink = firstLink;
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

    public void displayList(List node){
        while(node!=null)
        {
            System.out.print(node.getValue()+ " ");
            node = node.next;
        }
        System.out.println();
    }

    public boolean isCircular(List list) {
        List theLink = list;
        while (theLink != null) {
            theLink = theLink.next;
            if (theLink == list)
                return true;
        }
        return false;
    }


    public List removeByValue(int value) {
        List currentLink = firstLink;
        List previousLink = firstLink;

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
        List start = firstLink;
        List current = null;
        List node = null;
        List temp = null;
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

    public List mergeSort(List startNode,List lastNode){
        if(startNode == null || startNode.next==null)
            return startNode;
        if(startNode==lastNode)
            return startNode;
        List midle = getMidle(startNode,lastNode);
        List nextOfMidle=midle.next;
        midle.next=null;
        List left = mergeSort(startNode,midle);
        List right = mergeSort(nextOfMidle,lastNode);
        List sortedList = mergeLists(left,right);
        return sortedList;

    }

    private List mergeLists(List leftStart,List rightStart){
        if(leftStart==null)
            return rightStart;
        if(rightStart==null)
            return leftStart;

        List temp=null;
        if(leftStart.getValue()<=rightStart.getValue())
        {
            temp=leftStart;
            temp.next=mergeLists(leftStart.next,rightStart);
        }
        else{
            temp = rightStart;
            temp.next=mergeLists(leftStart,rightStart.next);
        }
        return temp;
    }


    private List getMidle(List node,List lastNode){
        if(node==null)
            return node;
        List babySteps=node;
        List bigSteps=node;
        while(bigSteps.next!=lastNode && bigSteps.next.next!=lastNode)
        {
            babySteps = babySteps.next;
            bigSteps = bigSteps.next.next;
        }
        return babySteps;

    }

    public void sortList(){
        int [] count = {0,0,0};
        List ptr = firstLink;

        while(ptr!=null){
            count[ptr.getValue()]++;
            ptr=ptr.next;
        }

        int i=0;
        ptr=firstLink;
        while(ptr!=null)
        {
            if(count[i]==0)
                i++;
            else{
                ptr.setValue(i);
                --count[i];
                ptr=ptr.next;
            }
        }
    }

   public void reverse(int k){
        int i=0;
        List prev = null;
        List current = firstLink;
        List next = null;
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
