class Solution {
   public int[] findOrder(int numCourses, int[][] prerequisites) {
      if (numCourses == 0){
        return new int[0];
      }
      // initialize in-degree array
      int[] inDegree = new int[numCourses];
      Arrays.fill(inDegree,0);
      
      // Build Reverse Adjacency List
      List<Integer>[] adjacencyList = new List[numCourses];
      for (int i = 0; i< numCourses; i++) {
        adjacencyList[i] = new LinkedList<Integer>() ;
      }
      for (int i = 0; i < prerequisites.length; i++) {
        int out = prerequisites[i][0];
        int in = prerequisites[i][1];
        inDegree[out]++;
        adjacencyList[in].add(out);
      }
      
      int[] queue = new int[numCourses];
      int count = 0;
      
      for (int i =0; i< numCourses; i++) {
         if (inDegree[i] == 0) {
             queue[count] = i;
             count++;
         }
      }
      int pointer = 0;
      while (pointer < count) {
          int x = queue[pointer++];
          List<Integer> neighbour =  adjacencyList[x];
          for (int i=0;i<neighbour.size();i++) {
            int y= neighbour.get(i);
            inDegree[y]--; 
             if (inDegree[y] == 0) {
                queue[count] = y;
                count++;
            }
          }
      }
       
      if (count == numCourses) {
          return queue;
      } else {
         return new int[0];
      }

    }
}
