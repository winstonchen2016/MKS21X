import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    public int index;
    public SuperArray SA;

    public SuperArrayIterator(SuperArray SuperArray){
	index = 0;
	SA = SuperArray;
    }

    public boolean hasNext(){
	return !(index == SA.size());
    }

    public String next(){
	if (hasNext()){
	    return SA.get(index++);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
