package metadto;

public class Utils {
	public static int generate(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
}
