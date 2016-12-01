public class ReferenceBook extends LibraryBook{
    private String collection;
    
    public ReferenceBook(String a, String t, String num, String c, String col){
	super(a, t, num, c);
	collection = col;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String str){
	collection = str;
    }

    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + "\nCollection: " + getCollection();
    }
}
