public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	try{
	    int a = Integer.parseInt(zip);
	}catch(NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	_zip = zip;
	_checkDigit = checkSum();
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	return new Barcode(_zip);
    }

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++){
	    sum += Integer.parseInt(_zip.substring(i, i+1));
	}
	return sum % 10;
    }
    
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit + " |" + codeSwap(_zip + _checkDigit) + "| ";
    } 

    private String codeSwap(String str){
	String ret = "";
	String[]codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::",};
	for (int i = 0; i < str.length(); i++){
	    ret += codes[Integer.parseInt(str.substring(i, i+1))];
	}
	return ret;
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	int myNum = getZip();
	int otherNum = other.getZip();
	if (myNum > otherNum){
	    return 1;
	}else if (myNum < otherNum){
	    return -1;
	}
	else{
	    return 0;
	}
    }

    private int getZip(){
	return Integer.parseInt(_zip + _checkDigit);
    }

    public static void main(String[]args){
	System.out.println(Integer.parseInt("08451"));
	Barcode a = new Barcode("08451");
	System.out.println(a.toString()); //should be "084518  |||:::|::|::|::|:|:|::::|||::|:|"
	//Barcode b = new Barcode("0wvbe"); //should throw IllegalArgementException
	//Barcode c = new Barcode("0845111"); //should throw IllegalArgementException
	//Barcode d = new Barcode("084"); //should throw IllegalArgementException
	Barcode b = new Barcode("00001");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("08451");
	System.out.println(c.compareTo(b)); //should be 1
	System.out.println(b.compareTo(c)); //should be -1
	System.out.println(a.compareTo(d)); //should be -1
    }
}
