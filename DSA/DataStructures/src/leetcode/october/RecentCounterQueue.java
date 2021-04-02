package leetcode.october;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounterQueue {
	
	Queue<Integer> q = new LinkedList<Integer>();

    public RecentCounterQueue() {
    }
    
    public int ping(int t) {
        q.add(t);
        while(!q.isEmpty() && q.peek() < t - 3000){
            q.remove();
        }
        return q.size();
    }
}
