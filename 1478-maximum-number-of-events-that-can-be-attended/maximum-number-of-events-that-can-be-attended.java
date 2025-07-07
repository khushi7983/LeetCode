import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // sort by start time

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap for end times
        int day = events[0][0];
        int i = 0;
        int count = 0;
        int n = events.length;

        while (i < n || !pq.isEmpty()) {

            // Add all events that start today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove all events whose end day is before today
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event with the earliest end day (if any)
            if (!pq.isEmpty()) {
                pq.poll();  // attend one event
                count++;
            }

            day++; // move to next day
        }

        return count;
    }
}
