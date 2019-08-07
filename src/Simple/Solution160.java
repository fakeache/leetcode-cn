package Simple;

//相交链表
public class Solution160 {
    //分别计算长度后，长链表先走差值步
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        int l1 = 0;
        int l2 = 0;
        while(p!=null){
            p = p.next;
            l1++;
        }
        while(q!=null){
            q = q.next;
            l2++;
        }
        p=headA;
        q=headB;
        if(l1>l2){
            int x = l1-l2;
            for(int i=0;i<x;i++){
                p=p.next;
            }
        }
        else if(l2>l1){
            int x = l2-l1;
            for(int i=0;i<x;i++){
                q=q.next;
            }
        }
        while(p!=null){
            if(p==q){
                return p;
            }
            p=p.next;
            q=q.next;
        }
        return null;
    }
    //写的太屎了
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        boolean pflag = false;
        boolean qflag = false;
        while(p!=q){
            if(p==null){
                if(pflag==false){
                    pflag=true;
                    p=headB;
                    if(p==q){
                        return p;
                    }
                }
                else{
                    return null;
                }
            }
            if(q==null){
                if(qflag==false){
                    qflag=true;
                    q=headA;
                    if(p==q){
                        return p;
                    }
                }
                else{
                    return null;
                }
            }
            p=p.next;
            q=q.next;
        }
        return p;
    }
}