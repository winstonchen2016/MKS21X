public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String num, String c){
	super(a, t, num, c);
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String str){
	currentHolder = str;
    }

    public void setDueDate(String str){
	dueDate = str;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	try{
	    boolean test = (currentHolder.equals(null) && dueDate.equals(null));
	    return "\nCurrent Holder: " + getCurrentHolder() + "\nDue Date: " + getDueDate();
	}catch(NullPointerException e){
	    return "book available on shelves";
	}
    }

    public String toString(){
	return super.toString();
    }

}
