//Sort a Linked List of 0s, 1s and 2s
//
// Approach
//
// - Create three dummy lists:
//      zero, one and two.
// - Traverse the original list.
// - Append each node to its corresponding list.
// - Connect the three lists.
// - Return the new head.
//
// Time Complexity: O(N)
//
// Space Complexity: O(1)






class Solution {
    public Node segregate(Node head) {
        Node zeroD=new Node(0);
        Node oneD=new Node(0);
        Node twoD=new Node(0);
        Node zero=zeroD;
        Node one=oneD;
        Node two=twoD;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=oneD.next!=null?oneD.next:twoD.next;
        one.next=twoD.next;
        two.next=null;
        return zeroD.next;
            }
            }
            
        
        
