// Намиране на най-голям общ делител на 2 числа

public class Main
{
	public static void main(String[] args) {
        int a = 12; 
        int b = 18; 
        int nod = NOD(a,b); 
         
        System.out.println("Най-голям общ делител на " + a + " и " + b + " e: " + nod);
	} 
	
	public static int NOD(int m, int n){
	    int nod = 0;
	    
	    for(int x = 1; x <= m; x++){
            if(m % x == 0 && n % x == 0){
                nod = x;
            }
        } 
        
        return nod;
	}	
}