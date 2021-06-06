package Final_Project;

public class UserInfo {
	public static String username;
	public static String category;
	
	public static int genre;
	public static int current_level=0;
	public static int[] score = new int[10];  // User's level score
	public static int sum=0;  // User's total score
	
	public static void initialize() {
		// Initialize user's information
		current_level=0;
		sum=0;
		for (int i=0; i<10; i++)
			score[i]=0;
	}

}
