package Simple;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null){
            if(p.val==q.val){
                q=q.next;
                p.next = q;
            }
            else{
                p=q;
                q=q.next;
            }
        }
        return head;
    }
}