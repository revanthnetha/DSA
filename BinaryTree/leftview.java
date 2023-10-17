class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> a= new ArrayList<>();
      f(root,a,0);
      return a;
    }
    
    public void f(Node root,ArrayList<Integer> a,int d){
        if(root==null)
            return;
        if(a.size()==d)
            a.add(root.data);
        f(root.left,a,d+1);
        f(root.right,a,d+1);
    }
}

// class Tree
// {
//     //Function to return list containing elements of left view of binary tree.
//     ArrayList<Integer> leftView(Node root)
//     {
//       ArrayList<Integer> a = new ArrayList<>();
//       if(root == null)
//         return a;
//       Queue<Node> q = new LinkedList<>();
//       q.add(root);
//       a.add(root.data);
//       q.add(null);
//       while(!q.isEmpty()){
//           Node curr = q.remove();
//           if(curr == null){
//           if(q.isEmpty()){
//               break;
//           }else{
//             Node temp = q.peek();
//             a.add(temp.data);
//             q.add(null);
            
//           }
//           }
//           else{
//               if(curr.left!=null)
//                     q.add(curr.left);
//               if(curr.right!=null)
//                     q.add(curr.right);
//           }
//       }
//       return a;
     
//     }
// }