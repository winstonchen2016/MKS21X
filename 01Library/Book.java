public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
    }

    public Book(String a, String t, String num){
	author = a;
	title = t;
	ISBN = num;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String str){
	author = str;
    }

    public void  setTitle(String str){
	title = str;
    }

    public void setISBN(String str){
	ISBN = str;
    }

    public String toString(){
	return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN;
    }

    public static void main(String[]args){
	Book b = new Book();
	System.out.println(b .toString());
	Book b1 = new Book("A","B","123");
	System.out.println(b1.toString());
	
	System.out.println(b.getAuthor());
	System.out.println(b.getTitle());
	System.out.println(b.getISBN());
		
	b.setAuthor("Z");
	b.setTitle("X");
	b.setISBN("1234567890");
	
	System.out.println(b.getAuthor());
	System.out.println(b.getTitle());
	System.out.println(b.getISBN());
		
	System.out.println(b.toString());

    }
}
