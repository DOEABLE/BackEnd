package trythis;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsEx {
		public static final String[] MOVIES = {"Transformer", "StarWars", "Matrix", "Terminator", "Avatar"};

		public static void main(String[] args) {
				List<String> list = new LinkedList<>(Arrays.asList(MOVIES));
				//todo asList :
				for (String movie : MOVIES) {
						list.add(movie);//add로 하면 string[] 잡힘. 근데 addAll은 안잡힘.
				}
				System.out.println(list);

				Collections.reverse(list);
				System.out.println(list);

				Collections.sort(list);
				System.out.println(list);

				System.out.println(Collections.min(list));
				System.out.println(Collections.max(list));
		}
}
