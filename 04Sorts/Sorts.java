public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "06.Chen.Winston"; 
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	boolean hasChanged = false;
	for(int i = 0; i < data.length; i++){
	    int lowest = data[i];
	    int lowestPos = -1;
	    for(int a = i; a < data.length; a++){
		
		if(data[a] < lowest){
		    lowest = data[a];
		    lowestPos = a;
		    hasChanged = true;
		}
	    }
	    if(hasChanged){
		//System.out.println("lowest = " + lowest);
		//System.out.println("a = " + lowestPos);
		//System.out.println("i = " + data[i]);
		data[lowestPos] = data[i];
		data[i] = lowest;
		hasChanged = false;
		//System.out.println(toString(data));
	    }
	}
    }

    public static String toString(int[]data){
	String ans = "[";
	for(int i = 0; i < data.length - 1; i++){
	    ans += data[i];
	    ans += ", ";
	}
	ans = ans + data[data.length - 1] + "]";
	return ans;
    }

    public static void main(String[]args){
	System.out.println(name());
	int[]data = {10, 32, 10, 18, 1};
	System.out.println(toString(data));
	selectionSort(data);
	System.out.println(toString(data));
    }
}
