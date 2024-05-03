public class LinkedList {
  public static void main(String[] args) {
    LList nums = new LList();
    nums.dequeue();
    System.out.println(nums);
  }


}

class LList{
  LNode head;
  LNode tail;


  public LList(){
    head = null;
    tail = null;
  }
  



  public void reverse() {
    LNode pt = head;
    LNode temp = null;

    while (pt != null) {
        temp = pt.prev;
        pt.prev = pt.next;
        pt.next = temp;

        pt = pt.prev;
    }

    if (temp != null) {
        head = temp.prev;
    }
  }

    

  public LList clone(){
    
    LList cloned = new LList();
    LNode pt = head;

    while (pt != null) {
      cloned.enqueue(pt.val);
      pt = pt.next;
    }

    return cloned;

  }



  public void push(int v){
    LNode tmp = new LNode(null, v, head);
    if(tail == null){
      tail = tmp;
    }
    head = tmp;
    
  }

  public void pop(){
    if (head != null)
    head = head.next;
  }
  //You can never point to a variable, only point to objects, when you try to point to a variable, it will lead to the object its pointing to
  //However, you can have a variable point to objects, not viceversa
  public LNode enqueue(int v){
    LNode tmp = new LNode(tail, v, null);
    if (head == null) head = tmp;
    else tail.next = tmp;
    tail = tmp;
    return tmp;
  }
  
  public void sortedInsert(int v){
    LNode pt = head;

    if (pt == null) {push(1); return;}

    //if (pt.val < v){push(v);}
    
    while (pt.next != null && pt.next.val > v) {
      pt = pt.next;
    }
  
    if (pt.next != null){
      LNode tmp = new LNode(pt, v, pt.next);
      pt.next.prev = tmp;
      pt.next = tmp;
    }
    else{enqueue(v);}

  }

  public void removeDuplicates(){

    LNode pt = head;
    LNode smth = pt.next;
    int num = pt.val;

    while (pt.next != null){
      while (smth.next != null){
        if(pt.val == smth.val) delete(smth);
        System.out.println(smth.val);
        smth = smth.next;
      }
      if (smth.next == null && pt.val == smth.val){
        tail = smth.prev;
        tail.next = null;
      }

      pt = pt.next;
      smth = pt.next;
      num = pt.val;
    }

  }
  public void delete(LNode node){
    if (node.prev == null && node.next == null){dequeue(); tail = null;}
    else if (node.prev == null) {head = node.next; head.prev = null;}
    else if (node.next == null) {tail = node.prev; tail.next = null;}
    else if (node.next != null && node.prev != null) node.prev.next = node.next;
  }

  public void delete(int v){
    LNode pt = head;

    while(pt.val != v){
      if (pt.next!= null) pt = pt.next;
      else return;
    }

    delete(pt);
  }


  public void deleteAt(int index){
    LNode pt = head;
   for (int counter = 0; counter <= 0; counter++){
      if (counter == index){this.delete(pt);}
      if (pt.next!= null) pt = pt.next;
   }
  }

  public void dequeue(){
    if(head != null)
      head = head.next;
  }

  @Override
  public String toString(){
    String ans = "[";
    LNode tmp = head;

    while(tmp != null){
      ans += tmp.val + ", ";
      tmp = tmp.next;
    }
    if(ans != "["){
      ans = ans.substring(0, ans.length()-2);
    }
    return ans + "]";
  } 
  
}

class LNode{
  int val;
  LNode next;
  LNode prev;

  public LNode(LNode p, int v, LNode n){
    val = v;
    next = n;
    prev = p;
  }
  
}