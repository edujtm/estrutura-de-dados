import java.util.LinkedList;
import java.util.ListIterator;

public class MergeSort {

	public static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
		ListIterator<Integer> it = l.listIterator(0);
		while (it.hasNext()) {
			if (it.nextIndex() < l.size()/2 ) {
				l1.add(it.next());
			} else {
				l2.add(it.next());
			}
		}
	} 

	public static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> result = new LinkedList<>();
		int j = 0;
		for (int i = 0; i<l1.size(); ++i) {
			while (j<l2.size() && l1.get(i) > l2.get(j)) {
				result.add(l2.get(j));
				++j;
			}
			result.add(l1.get(i));
		}

		while (j < l2.size()) {
			result.add(l2.get(j));
			++j;
		}

		return result;
	}

	public static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
		if (l.size() <= 1) {
			return l;
		}
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		split(l, l1, l2);
		//System.out.println(l);
		//System.out.println(l1);
		//System.out.println(l2);
		l1 = mergesort(l1);
		l2 = mergesort(l2);
		return merge(l1, l2);		
	}
}
