import java.lang.IndexOutOfBoundsException;
public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   this.size = 0;
   this.start = null;
   this.end = null;
 }
 public int size() {
   return this.size;
 }

 private Node getNthNode(int n) {
   Node current = this.start;
   if ((n<0)||(n > this.size)) {
     throw new IndexOutOfBoundsException("Index out of bounds");
   }
   for (int i = 0; i < n; i ++) {
     current = current.getNext();
     }
  return current;
 }

 public boolean add(String value) {
   if (this.size == 0) {
     this.start = new Node(value);
     this.end = this.start;
     this.size = 1;
     return true;
   }
   else {
     Node newnode = new Node(value);
     this.end.setNext(newnode);
     newnode.setPrev(this.end);
     this.end = newnode;
     this.size ++;
     return true;
   }
 }

 public void add(int index, String value) {
    Node newnode = new Node(value);
    // EMPTY:
   if (this.size == 0) {
     this.start = newnode;
     this.end = this.start;
     this.size = 1;
   }
   // START:
  else if (index == 0) {
    newnode.setNext(this.start);
    this.start.setPrev(newnode);
    this.start = newnode;
    this.size ++;
  }
   // END:
  else if (index == this.size) {
    this.end.setNext(newnode);
    newnode.setPrev(this.end);
    this.end = newnode;
    this.size ++;
  }
  // MIDDLE:
  else {
    Node indexnode = getNthNode(index);
    indexnode.getPrev().setNext(newnode);
    newnode.setPrev(indexnode.getPrev());
    newnode.setNext(indexnode);
    indexnode.setPrev(newnode);
    this.size ++;
  }
 }

 public String get(int index){
   return getNthNode(index).getData();
 }

 public String set(int index, String value){
   Node oldnode = getNthNode(index);
   getNthNode(index).setData(value);
   return oldnode.getData();
 }

 public String toString() {
   Node current = this.start;
   String output = "[";
   while (current != null) {
     output += current.getData();
     current = current.getNext();
     if (current != null) {
       output += ", ";
     }
   }
   output += "]";
   return output;
 }

 public String toStringReversed() {
   Node current = this.end;
   String output = "[";
   while (current != null) {
     output += current.getData();
     current = current.getPrev();
     if (current != null) {
       output += ", ";
     }
   }
   output += "]";
   return output;
 }

 public String remove(int index) {
   Node oldnode = getNthNode(index);
   // START:
   if (index == 0) {
     Node oldstart = this.start;
     this.start = oldstart.getNext();
     // this.start.setPrev() = null;
     this.size --;
   }
   // END:
   else if (index == this.size-1) {
     Node oldend = this.end;
     this.end = oldend.getPrev();
     // this.end.setNext() = null;
     this.size --;
   }
   // FINAL NODE:
   else if (this.size == 1) {
     this.start = null;
     this.end = null;
     this.size --;
   }
   // MIDDLE:
   else {
     Node prevnode = getNthNode(index-1);
     Node nextnode = getNthNode(index+1);
     prevnode.setNext(nextnode);
     nextnode.setPrev(prevnode);
     this.size --;
   }
   return oldnode.getData();
 }
 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
  public void extend(MyLinkedList other){
    if (other.size == 0) {
      return;
    }
    else if (this.size == 0) {
      this.start = other.start;
      this.end = other.end;
      this.size = other.size;
      other.start = null;
      other.end = null;
      other.size = 0;
    }
    // else if (other.size = 1) {
    //
    // }
    else {
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    this.end = getNthNode(other.size-1);
    this.size = this.size + other.size;
    other.start = null;
    other.end = null;
    other.size = 0;
  }
  }
}
