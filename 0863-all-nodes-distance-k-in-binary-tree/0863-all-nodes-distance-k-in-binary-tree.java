
class Solution {

    HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        buildParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty()){

            if(distance == k) break;

            int size = queue.size();

            while(size-- > 0){

                TreeNode curr = queue.poll();

                if(curr.left != null && visited.add(curr.left))
                    queue.offer(curr.left);
                if(curr.right != null && visited.add(curr.right))
                    queue.offer(curr.right);
                if(parent.get(curr) != null && visited.add(parent.get(curr)))
                    queue.offer(parent.get(curr));
            }
            distance++;
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())
            ans.add(queue.poll().val);
        return ans;

    }

    private void buildParent(TreeNode root, TreeNode par){
        if(root == null) return;
        parent.put(root, par);
        buildParent(root.left, root);
        buildParent(root.right, root);
    }
}