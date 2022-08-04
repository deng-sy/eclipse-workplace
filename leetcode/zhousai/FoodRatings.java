package zhousai;
import java.util.*;
class FoodRatings {
    int n;
    Map<String,PriorityQueue<Integer>> cuisine2food;
    String[]foods;
    String[]cuisines;
    int[]ratings;
    Map<Integer,String>food2cuisine;
    Map<String,Integer>food2idx;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        n= foods.length;
        this.foods=foods;
        this.cuisines=cuisines;
        this.ratings=ratings;
        cuisine2food = new HashMap<>();
        food2idx=new HashMap<>();
        food2cuisine=new HashMap<>();
        for(int i=0;i<n;i++){
            String cuisine=cuisines[i];
            String food=foods[i];
            if(cuisine2food.get(cuisine)==null){
                cuisine2food.put(cuisine,new PriorityQueue<>((o1, o2) -> {
                    if(ratings[o1]!=ratings[o2])
                        return ratings[o2]-ratings[o1];
                    return foods[o1].compareTo(foods[o2]);
                }));
            }
            cuisine2food.get(cuisine).offer(i);
            food2idx.put(food,i);
            food2cuisine.put(i,cuisine);
        }
    }

    public void changeRating(String food, int newRating) {
        int idx=food2idx.get(food);
        ratings[idx]=newRating;
        String cuisine=food2cuisine.get(idx);
        PriorityQueue<Integer>pq=cuisine2food.get(cuisine);
        pq.remove(idx);
        pq.offer(idx);
    }

    public String highestRated(String cuisine) {
        int idx=cuisine2food.get(cuisine).peek();
        return foods[idx];
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(Arrays.toString(foodRatings.ratings));
        System.out.println(foodRatings.cuisine2food.get("japanese"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);

        System.out.println(Arrays.toString(foodRatings.ratings));
        System.out.println(foodRatings.cuisine2food.get("japanese"));

        System.out.println(foodRatings.highestRated("japanese"));

        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));

    }
}

