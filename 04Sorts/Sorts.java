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
	int temp = 0;
	for(int i = 0; i < data.length; i++){
	    for(int a = i; a < data.length; a++){
		if(data[a] < data[i]){
		    temp = data[a];
		    hasChanged = true;
		}
		if(hasChanged){
		    System.out.println("temp = " + temp);
		    System.out.println("a = " + data[a]);
		    System.out.println("i = " + data[i]);
		    data[a] = data[i];
		    data[i] = temp;
		    hasChanged = false;
		    System.out.println(toString(data));
		}
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
