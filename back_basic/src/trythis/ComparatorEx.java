package trythis;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda, collection Framework 계층 구조.
 */
public class ComparatorEx {
    public static void main(String[] args) {
        String[] strings = CollectionsEx.MOVIES;
        Arrays.sort(CollectionsEx.MOVIES, new Comparator<String>() {    //String 제너릭 무조건 줘야함.
            @Override
            public int compare(String first, String second) {
                return first.length() - second.length();    //오른쪽이 크면 음수, 왼쪽이 크면 양수 반환
            }
        });


        System.out.println("movie=" + Arrays.toString(strings));
        //lambda
        Comparator<String> descCompa = (first, second) ->
                second.length() - first.length();
        Arrays.sort(strings, descCompa);

        for (String s : strings) {
            System.out.println("movie=" + s);
        }

        System.out.println("---------------");
        List<String> list = Arrays.asList(strings);//stringArray를 list로 만드는 방법
        System.out.println(list.getClass().getName());

        list.stream()
                .map(String::length)
                .filter(len -> len > 7)
                .forEach(System.out::println);//정리함수 쓰고 난 후엔 stream 쓸 수 없음.
        //단어의 길이가 7보다 큰 것만 filtering.
        //stream을 만들고 string의 길이를 가져와서 7보다 큰애들만 forEach로 부름

        /**
         * interface Negative만들기
         *
         */
        Negative n = x -> -x;
        Add a = Integer::sum;//Integer내에 이미 sum이라는 함수가 있음.
        // = (a,b)->a+b;

    }

    interface Add {
        int add(int a, int b);
    }

    interface Negative {    //inner interface 생성
        int neg(int x);
    }
}


