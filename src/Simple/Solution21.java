package Simple;



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 //合并链表，创建一个头节点，更舒服
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode l3,p;
        if(l1.val>l2.val){
            l3=l1;
            l1=l2;
            l2=l3;
        }
        l3=l1;
        p=l1;
        l1=l1.next;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1==null){
            p.next=l2;
        }
        else{
            p.next=l1;
        }
        return l3;
    }
}