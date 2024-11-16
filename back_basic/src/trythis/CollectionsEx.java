package trythis;

import java.util.*;

public class CollectionsEx {
    public static final String[] MOVIES = {"Transformer", "StarWars", "Matrix", "Terminator", "Avatar"};

    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList(MOVIES));
        Queue<String> queue = new PriorityQueue<>(5); //초기용량 5 PriorityQueue -> 기본적으로 사전순으로 정렬
        queue.offer("ABC");    // 문자열 추가 (용량 제한이 있는 queue에서 안전하게 사용가능)
        queue.poll();            // 큐의 헤드(가장 우선순위가 높은 요소)를 제거하고 반환
        //todo asList :
        System.out.println(list);
        for (String movie : MOVIES) {
            list.add(movie);//add로 하면 string[] 잡힘. 근데 addAll은 안잡힘.
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list); //list의 요소들을 오름차순 정렬
        Collections.sort(list, Collections.reverseOrder()); //내림차순 정렬.
        System.out.println(list);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
    }
}
