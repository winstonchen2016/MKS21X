import java.util.*;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
	size = 0;
	data = new String[10];
    }

    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new String[initialCapacity];
    }

    public int size(){
	return size;
    }

    public boolean add(String n){
	size += 1;
	if (data.length < size){
	    grow();
	}
	data[size-1] = n;
	return true;
    }

   public void add(int index, String element){
       if(index < 0 || index > size){
	   throw new IndexOutOfBoundsException();
       }
       size += 1;
       if (data.length < size){
	   grow();
       }
       for(int i = size - 1; i > index; i--){
	   data[i] = data[i-1];
       }
       data[index] = element;
    }
    
    private void grow(){
	String[] temp = new String[data.length*2];
	for(int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    public void trimToSize(){
	data = toArray();
    }

    public String get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String ans =  "";
	ans += "[ ";
	ans += data[0];
	for(int i = 1; i < size; i++){
	    ans = ans + ", " + data[i];
	}
	ans += "]";
	return ans;
    }

    public String toStringDebug(){
	if (size == 0){
	    return "[]";
	}
	String ans =  "";
	ans += "[ ";
	ans += data[0];
	for(int i = 1; i < data.length; i++){
	    if (i < size){
		ans = ans + ", " + data[i];
	    }
	    else{
		ans = ans + ", _";
	    }
	}
	ans += "]";
	return ans;
    }

    public void clear(){
	size = 0;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public String set(int index, String element){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	data[index] = element;
	return old;
    }

    public String remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
        String old = data[index];
        size -= 1;
        for(int i = index; i < size; i++){
	    data[i] = data[i+1];
        }
        return old;
    }

    public String[] toArray(){
	String[] ans = new String[size];
	for(int i = 0; i < size; i++){
	    ans[i] = data[i];
	}
	return ans;
    }

    public String toArrayString(String[] a){
	String ans =  "";
	ans += "[ ";
	ans += a[0];
	for(int i = 1; i < size; i++){
	    ans = ans + " " + a[i];
	}
	ans += "]";
	return ans;
    }

    public int indexOf(String i){
	for (int a = 0; a < size; a++){
	    if (data[a].equals(i)){
		return a;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String i){
	for (int a = size - 1; a >= 0; a--){
	    if (data[a].equals(i)){
		return a;
	    }
	}
	return -1;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
    
    public static void main(String[]args){
	SuperArray a = new SuperArray();
	System.out.println(a.size()); //should be 0
	a.add("A");
	System.out.println(a.size()); //should be 1
	a.add("AB");
	System.out.println(a.isEmpty()); //should be false
	a.clear();
	System.out.println(a.isEmpty()); //should be true
	a.add("A");
	a.add("B");
	a.add("C");
	System.out.println(a.add("D")); //should be true
	System.out.println(a.size()); //should be 4
	a.add("E");
	a.add("F");
	System.out.println(a.get(5)); //should be "F"
	//System.out.println(a.get(10)); //should throw IndexOutOfBounds
	a.add("F#");
	a.add("G");
	a.add("A");
	System.out.println(a.toString());
	System.out.println(a.toStringDebug());
	a.add("bflat");
	System.out.println(a.toString());
	System.out.println(a.toStringDebug());
	a.add("c"); //11th element, should trigger grow() and make array larger
	System.out.println(a.toString());
	System.out.println(a.toStringDebug()); //should have _'s
	//a.add(-1,"flat"); //should throw IndexOutOfBounds
	System.out.println(a.size()); //should be 11
	System.out.println(a.set(9,"accidentals")); //should be "bflat"
	System.out.println(a.set(9,"bflat")); //should be "accidentals"
	//System.out.println(a.set(-1,"scale")); //should throw IndexOutOfBounds
	for (int i = 0; i <= a.size(); i++){
	    a.add(i,"TILT");
	    System.out.println(a.toString());
	    a.remove(i);
	    System.out.println(a.toString());
	}
	System.out.println(a.toArray()); //should return memory address of new array
	System.out.println(a.toArrayString(a.toArray())); //toArray returns the address of the array, so I created toArrayString to make it readable to humans
	for (int i = 0; i < a.size(); i++){
	    String n = a.get(i);
	    a.remove(i);
	    System.out.println(a.toString());
	    a.add(i,n);
	    System.out.println(a.toString());
	}
	//System.out.println(a.remove(-1)); //should throw IndexOutOfBounds
	System.out.println(a.indexOf("A")); //should be 0
	System.out.println(a.indexOf("c")); //should be 10
	System.out.println(a.indexOf("fhiqpef")); //should be -1
	System.out.println(a.size()); //should be 11	
	System.out.println(a.lastIndexOf("A")); //should be 8
	System.out.println(a.lastIndexOf("c")); //should be 10
	System.out.println(a.lastIndexOf("geipqg")); //should be -1
	System.out.println(a.toStringDebug());
	a.trimToSize();
	System.out.println(a.toStringDebug());
	//superArray b = new superArray(-1); //should throw IllegalArgument
    }
    
}
