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
   if ((n<0)||(n >= this.size)) {
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
  // else if (index == this.size-1) {
  //   this.end.setNext(newnode);
  //   newnode.setPrev(this.end);
  //   this.end = newnode;
  //   this.size ++;
  // }
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
   String output = "";
   while (current != null) {
     output += current.getData();
     current = current.getNext();
     if (current != null) {
       output += ", ";
     }
   }
   return output;
 }
}
