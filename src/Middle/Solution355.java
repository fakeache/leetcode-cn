package Middle;

import java.util.*;

public class Solution355 {
    Map<Integer, Set<Integer>> followRelation = new HashMap<>();
    Map<Integer, Twe> userTweet = new HashMap<>();
    int count = 0;
    PriorityQueue<Twe> queue;
    int lastN = 10;

    /** Initialize your data structure here. */
    public Solution355() {
        queue = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userTweet.put(userId, new Twe(tweetId, ++count, userTweet.get(userId)));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        if (followRelation.get(userId) != null) {
            for (Integer followee : followRelation.get(userId)) {
                if (userTweet.get(followee) != null) {
                    queue.add(userTweet.get(followee));
                }
            }
        }
        if (userTweet.get(userId) != null) {
            queue.add(userTweet.get(userId));
        }
        List<Integer> rs = new ArrayList<>(10);
        int num = 0;
        while (!queue.isEmpty() && num < lastN) {
            Twe twe = queue.poll();
            rs.add(twe.tweId);
            num++;
            if (twe.next != null) {
                queue.add(twe.next);
            }
        }
        return rs;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (followRelation.get(followerId) == null) {
            followRelation.put(followerId, new HashSet<>());
        }
        Set<Integer> followees = followRelation.get(followerId);
        followees.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> set = followRelation.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    class Twe {
        int tweId;
        int time;
        Twe next;
        public Twe(int tweId, int time, Twe next) {
            this.tweId = tweId;
            this.time = time;
            this.next = next;
        }
    }
}
