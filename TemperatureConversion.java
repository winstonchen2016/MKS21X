public class TemperatureConversion{
    public static double CtoF (double t) {
        return 9.0 / 5.0 * t + 32.0;
    }
    public static double FtoC (double t) {
        return 5.0 / 9.0 * (t - 32.0);
    }
    public static void main (String[]args){
	System.out.println(CtoF(0)); //should be 32.0
	System.out.println(CtoF(100)); //should be 212.0
	System.out.println(CtoF(-40.0)); //should be -40.0
	System.out.println(FtoC(32)); //should be 0.0
	System.out.println(FtoC(212)); //should be 100.0
	System.out.println(FtoC(-40.0)); //should be -40.0
    }
}
