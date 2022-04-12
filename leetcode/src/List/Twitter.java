package List;
import java.util.*;



class Twitter {
    class News implements Comparable<News>{
            int userId;
            int newsId;
            int idx;

            public News(int userId,int newsId, int idx) {
                this.userId=userId;
                this.newsId = newsId;
                this.idx = idx;
            }

            @Override
            public int compareTo(News news) {
                return news.idx-idx;
            }


        }
    List<Integer> userlist;
    Map<Integer,List<Integer>>user2user;
    List<News> newslist;
    Map<Integer,List<News>>use2news;
    int news_cnt;
    public Twitter() {
        userlist =new ArrayList<>();
        user2user=new HashMap<>();
        newslist =new ArrayList();
        use2news=new HashMap<>();
        news_cnt=0;
    }
    private void init(int userId){
        userlist.add(userId);
        use2news.put(userId,new ArrayList<>());
        user2user.put(userId,new ArrayList<>());
    }
    public void postTweet(int userId, int tweetId) {
        if(!userlist.contains(userId)){
            init(userId);
        }
        News news=new News(userId,tweetId,++news_cnt);
        newslist.add(news);

        List follower_news=use2news.get(userId);
        follower_news.add(news);

        for(int follower: userlist){
            if(user2user.get(follower).contains(userId)){
                update_news(follower,userId,true);
            }
        }
        Collections.sort(follower_news);
    }
    public List<Integer> getNewsFeed(int userId) {
        if(!userlist.contains(userId)){
            init(userId);
        }
        int count=0;
        List<Integer>res=new ArrayList<>();
        List<News>list=use2news.get(userId);
        for(News news:list){
            res.add(news.newsId);
            count++;
            if(count==10)
                break;
        }
        return res;

    }
    public void follow(int followerId, int followeeId) {
        if(!userlist.contains(followeeId)){
            init(followeeId);
        }

        if(!userlist.contains(followerId)){
            init(followerId);
        }
        if(user2user.get(followerId).contains(followeeId))
            return;
        user2user.get(followerId).add(followeeId);
        update_news(followerId,followeeId,true);
    }
    public void unfollow(int followerId, int followeeId) {
        List<Integer>followees=user2user.get(followerId);
        if(!followees.contains(followeeId))
            return;
        followees.remove(followees.indexOf(followeeId));
        update_news(followerId,followeeId,false);
    }
    private void update_news(int followerId, int followeeId,boolean isFollow){
        List<News> follower_news=use2news.get(followerId);
        List<News> followee_news=use2news.get(followeeId);
        if(isFollow==true){
            for(News news:followee_news){
                if(news.userId==followeeId&&(!follower_news.contains(news)))
                    follower_news.add(news);
            }
            Collections.sort(follower_news);
        }else{
            for(News news:followee_news) {
                if(news.userId==followeeId)
                    follower_news.remove(news);
            }
        }

    }

    public static void main(String[] args) {

        Twitter twitter=new Twitter();
        twitter.follow(2,1);
        for(int i=0;i<20;i++)
            twitter.postTweet(1,i);
//        twitter.unfollow(2,1);

        System.out.println(twitter.getNewsFeed(2));


//        List<News>list=new ArrayList();
//        for(int i=0;i<8;i+=2){
//            list.add(new News(1,i,i));
//        }
//        list.add(new News(1,5,5));
//        for(News news:list)
//            System.out.print(news.idx+" ");
//        System.out.println();
//        Collections.sort(list);
//        for(News news:list)
//            System.out.print(news.idx+" ");

//        twitter.unfollow(1,2);



    }

}