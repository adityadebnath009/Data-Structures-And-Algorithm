package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 355
 * Problem Name: Design Twitter
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/design-twitter/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0355_DesignTwitter {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0355_DesignTwitter...");
    }

    // TODO: Write solution method here
}
class Twitter {

//
// 1. Each user owns a linked list of their tweets.
//    This models a one-to-many relationship:
//          User  ----->  Tweets
//
//    Every new tweet is inserted at the head, so the list is always ordered
//    from newest to oldest.
//
// 2. Each user also maintains the set of users they follow.
//    This models another one-to-many relationship:
//          User  ----->  Followees
//
// 3. The news feed is NOT stored.
//    Instead, it is generated on demand by merging the tweet lists of the
//    current user and all users they follow using a max-heap ordered by
//    timestamp.
//
// 4. A global timestamp is assigned to every tweet so tweets from different
//    users can be compared.



    //MaxHeap --> assuming tweetIds are provided in increasing order
    int gtime = 0;
    private final int  k = 10;

    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time)
        {
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }

    }
    Map<Integer, Tweet> posts;
    Map<Integer, Set<Integer>> followers;

    public Twitter() {
        posts = new HashMap<>();
        followers = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId,gtime++);

        if(posts.containsKey(userId))
        {
            Tweet head = posts.get(userId);
            newTweet.next = head;

        }
        posts.put(userId, newTweet);

    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));
        List<Integer> recentPosts = new ArrayList<>();


        Tweet userTweet = posts.get(userId);
        // Perhaps we are checking whether the user has any posts.
        if(userTweet!=null)
            maxHeap.add(userTweet);

        Set<Integer> followerSet = followers.get(userId);
        //We check whether the current user has any followers. If they do, we proceed.
        if(followerSet!=null)
        {

            for(int f: followerSet)
            {
                Tweet p = posts.get(f);
                //Here, first we check whether the user who follows another user has any posts.
                if(p!=null)
                    // We are adding the head of the tweets of  singly linked list that includes the user's tweets and the tweets of other users.
                    // The heap size is one plus the number of followers the user has.O(1 + no.of followers of the user)
                    maxHeap.add(p);
            }
        }

        while(!maxHeap.isEmpty() && recentPosts.size() < 10)
        {
            Tweet t = maxHeap.poll();
            recentPosts.add(t.tweetId);

            if(t.next!=null)
            {
                maxHeap.add(t.next);
                t = null;
            }


        }
        return recentPosts;




    }

    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followerSet = followers.get(followerId);

        //The current user might not have any followers, so we check this beforehand.

        if(followerSet!=null && followerSet.contains(followeeId))
        {
            followerSet.remove(followeeId);

        }



    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */