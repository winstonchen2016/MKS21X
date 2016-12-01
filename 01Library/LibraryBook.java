public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String a, String t, String num, String c){
	super(a, t, num);
	callNumber = c;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String str){
	callNumber = str;
    }

    abstract void checkout(String patron, String due);
    
    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook x){
	return callNumber.compareTo(x.callNumber);
    }

    public String toString(){
	return "Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nISBN: " + getISBN() + "\nCall Number: " + getCallNumber() + "\nCirculation Status: " + circulationStatus();
    }

}
