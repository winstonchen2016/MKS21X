public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private static final String[]codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::",};
    
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new IllegalArgumentException("The zip code has an invalid length.");
	}
	try{
	    int a = Integer.parseInt(zip);
	}catch(NumberFormatException e){
	    throw new IllegalArgumentException("The zip code is not a number.");
	}
	_zip = zip;
	_checkDigit = checkSum(_zip);
    }

    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String str){
	int sum = 0;
	for (int i = 0; i < str.length(); i++){
	    sum += Integer.parseInt(str.substring(i, i+1));
	}
	return sum % 10;
    }
    
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + checkSum(_zip) + " " + toCode(_zip);
    } 

    public static String toCode(String str){
	str += checkSum(str);
	String ret = "|";
	for (int i = 0; i < str.length(); i++){
	    ret += codes[Integer.parseInt(str.substring(i, i+1))];
	}
	ret += "|";
	return ret;
    }

    public static String toZip(String code){
	String ans = "";
	if(code.length() != 32){
	    throw new IllegalArgumentException("The barcode is not the right length.");
	}
	if(!(code.substring(0,1).equals("|") && code.substring(31,32).equals("|"))){
	    throw new IllegalArgumentException("The barcode does not begin and/or end with |'s.");
	}
	String actual = code.substring(1,31);
	for (int i = 0; i <= 25; i+=5){
	    for (int a = 0; a < codes.length; a++){
		if (actual.substring(i, i+5).equals(codes[a])){
		    ans += a;
		}
	    }
	    if (ans.length() != i/5 + 1){
	    	throw new IllegalArgumentException("Barcode pattern mismatch.");
	    }
	}
	if (Integer.parseInt(ans.substring(5)) != checkSum(ans.substring(0,5))){
		throw new IllegalArgumentException("Checksum failed.");
	}
	return ans.substring(0,5);
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
	System.out.println(Integer.parseInt("08451")); //should be 8451
	Barcode a = new Barcode("08451");
	System.out.println(Barcode.toCode("08451")); //should be "|||:::|::|::|::|:|:|::::|||::|:|"
	System.out.println(a.toString()); //should be "084518  |||:::|::|::|::|:|:|::::|||::|:|"
	//Barcode z = new Barcode("0wvbe"); //should throw IllegalArgementException (not #)
	//Barcode y = new Barcode("0845111"); //should throw IllegalArgementException (wrong length)
	//Barcode x = new Barcode("084"); //should throw IllegalArgementException (wrong length)
	Barcode b = new Barcode("00001");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("08451");
	System.out.println(c.compareTo(b)); //should be 1
	System.out.println(b.compareTo(c)); //should be -1
	System.out.println(a.compareTo(d)); //should be 0
	System.out.println(Barcode.toCode("")); //should be "|||:::|" (checkDigit is 0)
	//System.out.println(Barcode.toZip("")); //should throw IAE (wrong length)
	//System.out.println(Barcode.toZip("egoruvbisebgeigbaeipbgaegb")); //should throw IAE (wrong length)
	//System.out.println(Barcode.toZip("egoruvbiebgeigbaeipbjqopaegjsowb")); //should throw IAE (missing |'s)
	//System.out.println(Barcode.toZip("|goruvbiebgeigbaeipbjqopaegjsow|")); //should throw IAE (pattern mismatch)
	//System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::||:::|||")); //should throw IAE (checksum fail)
	System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|")); //should return 08451
    }
}
