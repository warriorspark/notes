/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
  public Node cloneGraph(Node node) {
    return helper(node, new HashMap<Integer, Node>());
  }
    
  public Node helper(Node node, Map<Integer, Node> s) {
    Node newNode = new Node(node.val, new LinkedList<Node>());
    s.put(node.val, newNode);
    for (Node n : node.neighbors) {
        if (s.containsKey(n.val)) {        
            newNode.neighbors.add(s.get(n.val));
        } else {
            newNode.neighbors.add(helper(n, s)); 
        }  
    }
      return newNode;
  }
}
