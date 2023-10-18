class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>(); // Create an adjacency list representation of the course prerequisites graph.
        int[] inDegree = new int[n + 1]; // Array to store in-degrees for each course.
        int[] maxTime = new int[n + 1]; // Array to store the maximum time needed for each course.

        // Initialize the adjacency list representation.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and calculate in-degrees.
        for (int[] relation : relations) {
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            graph.get(prevCourse).add(nextCourse); // Add the next course as a prerequisite for the current course.
            inDegree[nextCourse]++; // Increment the in-degree of the next course.
        }

        Queue<Integer> queue = new LinkedList(); // Create a queue for topological sorting.

        // Find the courses with no prerequisites (in-degree of 0) and add them to the queue.
        for (int course = 1; course <= n; course++) {
            if (inDegree[course] == 0) {
                queue.offer(course);
                maxTime[course] = time[course - 1]; // Initialize the maxTime for these courses.
            }
        }

        int minTotalTime = 0;

        // Perform topological sorting to determine the order to take courses.
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll(); // Dequeue the current course.

            for (int nextCourse : graph.get(currentCourse)) {
                inDegree[nextCourse]--; // Decrement the in-degree of the next course.
                maxTime[nextCourse] = Math.max(maxTime[nextCourse], maxTime[currentCourse] + time[nextCourse - 1]);

                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // If in-degree becomes 0, add the next course to the queue.
                }
            }
        }

        for (int course = 1; course <= n; course++) {
            minTotalTime = Math.max(minTotalTime, maxTime[course]); // Find the maximum time needed to complete all courses.
        }

        return minTotalTime;
    }
}

// https://leetcode.com/problems/parallel-courses-iii/submissions/1078132278/?envType=daily-question&envId=2023-10-18