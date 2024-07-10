public class Hello {
	public static void main(String[] args) {
		boolean state = true;
		char ch = 'A';
		byte by = -4;
		short sho = -3;
		int in = 71;
		long lo = 129;
		float flo = 12.9f;
		double dou = 143.29458;
		
		//short to long
		long short_to_long = sho;
		//double to byte
		byte double_to_byte = (byte)dou;
		
		System.out.println("Hello, World!");
		System.out.println("char is " + ch);
		System.out.println("byte is " + by);
		System.out.println("short is " + sho);
		System.out.println("int is" + in);
		System.out.println("long is " + lo);
		System.out.println("float is " + flo);
		System.out.println("double is " + dou);
		System.out.println("Automatic cast short to long " + short_to_long);
		System.out.println("Explicit cast double to byte " + double_to_byte);
	}
}