class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        if (numCourses==0) {
            return true;
        }
        int[] degress = new int[numCourses];
        List<List<Integer>> adjaceny = new ArrayList<List<Integer>>(numCourses);
        for (int i=0; i<numCourses;i++ ){
            adjaceny.add(i, new ArrayList<Integer>());
        }
        for (int i=0;i<p.length;i++) {
            int start = p[i][0];
            int end = p[i][1];
            degress[end]++;
            List<Integer> l = adjaceny.get(start);  
            l.add(end);
            adjaceny.set(start, l);

        }
        int count =0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i< numCourses;i++) {
            if (degress[i]==0) {
                queue.add(i);
                count++;
            }
        }
        while(!queue.isEmpty()) {
            Integer node= queue.remove(0);
            List<Integer> l = adjaceny.get(node);
            for (Integer i: l) {
                degress[i]--;
                if (degress[i]==0) {
                    queue.add(i);
                    count++;
                }
            }

        }
        if (count<numCourses) {
            return false;
        }
            return true;
        }
        
    
}
