class Solution {

    static class Basket {
        int capacity;
        int originalIndex;

        Basket(int capacity, int originalIndex) {
            this.capacity = capacity;
            this.originalIndex = originalIndex;
        }
    }

    private int[] segmentTree;
    private final int INF = Integer.MAX_VALUE;

    private void build(int node, int start, int end, int[] indices) {
        if (start == end) {
            segmentTree[node] = indices[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, indices);
        build(2 * node + 1, mid + 1, end, indices);
        segmentTree[node] = Math.min(segmentTree[2 * node], segmentTree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int updateIdx) {
        if (start == end) {
            segmentTree[node] = INF;
            return;
        }
        int mid = start + (end - start) / 2;
        if (start <= updateIdx && updateIdx <= mid) {
            update(2 * node, start, mid, updateIdx);
        } else {
            update(2 * node + 1, mid + 1, end, updateIdx);
        }
        segmentTree[node] = Math.min(segmentTree[2 * node], segmentTree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l || l > r) {
            return INF;
        }
        if (l <= start && end <= r) {
            return segmentTree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return Math.min(p1, p2);
    }
    
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        Basket[] sortedBaskets = new Basket[n];
        for (int i = 0; i < n; i++) {
            sortedBaskets[i] = new Basket(baskets[i], i);
        }
        
        Arrays.sort(sortedBaskets, Comparator.comparingInt(b -> b.capacity));
        int[] originalIndices = new int[n];
        int[] posInSorted = new int[n];     
        for (int i = 0; i < n; i++) {
            originalIndices[i] = sortedBaskets[i].originalIndex;
            posInSorted[sortedBaskets[i].originalIndex] = i;
        }

        this.segmentTree = new int[4 * n];
        build(1, 0, n - 1, originalIndices);

        int unplacedCount = 0;
        for (int fruit : fruits) {
            int startIdx = binarySearch(sortedBaskets, fruit);

            if (startIdx == -1) {
                unplacedCount++;
                continue;
            }
            int bestBasketIndex = query(1, 0, n - 1, startIdx, n - 1);

            if (bestBasketIndex == INF) { 
                unplacedCount++;
            } else {
                int updatePos = posInSorted[bestBasketIndex];
                update(1, 0, n - 1, updatePos);
            }
        }

        return unplacedCount;
    }
    private int binarySearch(Basket[] sortedBaskets, int fruitCapacity) {
        int left = 0, right = sortedBaskets.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedBaskets[mid].capacity >= fruitCapacity) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}