
public class Reverse {
	/*
	 * put the values back in the original array
	 * No additional storage (i.e. array, arraylist, etc.) should be used as buffer
	 * Primitive type variables can be used
	 */
	public static void apply(String[] days) {
		int i = 0;
		String buffer;
		while(i < days.length /2) {
			buffer = days[i];
			days[i] = days[days.length - i - 1];
			days[days.length - i - 1] = buffer;
			i++;
		}
	}
	
	public static void main(String[] args) {
		String[] days = {"SUN", "SAT", "FRI", "THU", "WED", "TUE", "MON"};
		int i=0;
		apply(days);
		while (i<days.length) {
			System.out.print(days[i] + "\t");
			i++;
		}
	}

}
