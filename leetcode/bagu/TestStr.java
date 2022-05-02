package bagu;

import java.util.stream.Stream;

public class TestStr {
    public static int x;
    public static void main(String[] args) {
        Stream.of("jd","jd.com","www.jd.com","www.jd.id")
                .mapToInt(String::length)
//                .filter(len->len>3)
                .peek(System.out::println);
//                .limit(2);
    }
}
