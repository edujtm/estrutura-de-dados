
public class DutchFlag {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void dutch_flag(int[] a) {
		int b = 0, i = 0;
		int r = a.length;
		while (i < r) {
			if (a[i] == 0) {
				swap(a, b, i);
				b++;
			}  else if (a[i] == 2) {
				swap(a, r-1, i);
				r--;
				i--;
			}
			i++;
		}

	}

}