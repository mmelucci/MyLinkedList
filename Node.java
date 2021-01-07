public class Node{
 public Node(String value){
   this.data = value;
   this.next = null;
   this.prev = null;
 }
 private String data;
 private Node next,prev;

 public String getData() {
   return this.data;
 }

 public Node getNext() {
   return this.next;
 }

 public Node getPrev() {
   return this.prev;
 }

 public void setData(String newvalue) {
   this.data = newvalue;
 }

 public void setNext(Node newnext) {
   this.next = newnext;
 }

 public void setPrev(Node newprev) {
   this.prev = newprev;
 }
}
