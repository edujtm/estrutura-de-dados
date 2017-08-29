
public class QuickSort {

	static void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	static int partition(int[] a, int l, int r) {
		if (l == r) return l;

		int pivot = l;
		l++;
		while (l < r) {
			while (l < r && a[pivot] > a[l]) {
				l++;
			}
			while (r > l && a[pivot] <= a[r]) {
				r--;
			}
			if (l < r) swap(a, l, r);
		}
		if (l == pivot+1 && a[pivot] <= a[l]) return pivot;
		if (a[pivot] > a[l]) {
			swap(a, pivot, l);
			return l;
		} else {
			swap(a, pivot, l-1);
			return l-1;
		}
	}

	static void quickrec(int[] a, int l, int r) {
		if (l > r) return;
		
		int m = partition(a, l, r);
		if (m-1 >= 0) quickrec(a, l, m-1);
		if (m+1 < a.length) quickrec(a, m+1, r);			
	}

	public static void quicksort(int[] a) {
		if (a.length == 0 || a.length == 1) return;
		quickrec(a, 0, a.length-1);
	}
	
}
