/******************************************************************************
Multiplication table from M to N

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    multiplicationTable(3,5);
	} 
	
	public static void multiplicationTable(int m, int n){
	    for (int x = 1; x <=m; x++) {
	        for(int y = 1; y <= n; y++) {
	            System.out.println(x  + " * " + y + " = " + (x*y));
	        } 
	        System.out.println(' ');
	    }
	}
}