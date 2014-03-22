import java.util.Hashtable;

public class Test {

	public static void main( String args[]) {
		
		int[] arr2 = new int[100];
		Hashtable<String, Object>[] arr = new Hashtable[10000];
		for( int i = 0; i < 10000; i++)
			arr[i] = new Hashtable<String, Object>();
		for( int i = 0; i < 10000; i++) {
			
			for( int j = 0; j < 100; j++) {
				
				arr[i].put( "j", j);
			}
		}
		
		System.out.println( int(2.2));
		System.out.println( (Integer)arr[999].get( "j") == 3 ? "true" : "false");
		System.out.println( (Integer)arr[999].get( "j2"));
	}
}
