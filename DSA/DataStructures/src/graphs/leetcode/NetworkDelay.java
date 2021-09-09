package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelay {

	static Map<Integer, Integer> dist;

	public static int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0]))
				graph.put(edge[0], new ArrayList<int[]>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}
		dist = new HashMap();
		for (int node = 1; node <= N; ++node)
			dist.put(node, Integer.MAX_VALUE);

		dist.put(K, 0);
		boolean[] seen = new boolean[N + 1];

		while (true) {
			int candNode = -1;
			int candDist = Integer.MAX_VALUE;
			for (int i = 1; i <= N; ++i) {
				if (!seen[i] && dist.get(i) < candDist) {
					candDist = dist.get(i);
					candNode = i;
				}
			}

			if (candNode < 0)
				break;
			seen[candNode] = true;
			if (graph.containsKey(candNode))
				for (int[] info : graph.get(candNode))
					dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
		}

		int ans = 0;
		for (int cand : dist.values()) {
			if (cand == Integer.MAX_VALUE)
				return -1;
			ans = Math.max(ans, cand);
		}
		return ans;
	}

	public static int networkDelayTimeUsingPQ(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] time : times) {
			map.putIfAbsent(time[0], new HashMap<>());
			map.get(time[0]).put(time[1], time[2]);
		}

		// distance, node into pq
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

		pq.add(new int[] { 0, K });

		boolean[] visited = new boolean[N + 1];
		int res = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.remove();
			int curNode = cur[1];
			int curDist = cur[0];
			if (visited[curNode])
				continue;
			visited[curNode] = true;
			res = curDist;
			N--;
			if (map.containsKey(curNode)) {
				for (int next : map.get(curNode).keySet()) {
					pq.add(new int[] { curDist + map.get(curNode).get(next), next });
				}
			}
		}
		return N == 0 ? res : -1;
	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int k = 2;
//		int out = networkDelayTime(times, 4, k);
		int out = networkDelayTimeUsingPQ(times, 4, k);
		System.out.println(out);
	}
}
