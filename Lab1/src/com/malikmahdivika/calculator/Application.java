/**
 * 
 */
package com.malikmahdivika.calculator;
import java.util.Scanner;
/**
 * 
 */
public class Application {

	/**
	 * @param args optional command-line arguments can be passed to pre-input the calculator
	 */
	public static void main(String[] args) {
		System.out.println("This is a simple Java program which performs basic operations"
				+ " on the command-line interface.");
		if (args.length == 3 || args.length == 1) {
			// Parse CLI args based on assumption it is in the format "number" "operator" "number" 
			System.out.println("Argument(s) detected.");
			if (args.length == 3) {
				try {
					double num1 = Double.parseDouble(args[0]);
					double num2 = Double.parseDouble(args[2]);
					switch (args[1]) {
						case "+":
							System.out.println("Result: " + (num1 + num2));
							break;
						case "-":
							System.out.println("Result: " + (num1 - num2));
							break;
						case "*":
							System.out.println("Result: " + (num1 * num2));
							break;
						case "/":
							if (num2 != 0) {
								System.out.println("Result: " + (num1/num2));
								break;
							} else {
								throw new IllegalArgumentException("Can not divide by zero, try again.");
							}
						default:
							throw new IllegalArgumentException("argument 2 is not an accepted operator. Please try again.");
					}
				} catch(NumberFormatException e) {
					throw new IllegalArgumentException("arguments 1 or 3 are not numbers. Please try again."); //catches non-number arguments 0 and 1.
				}
			} else {
				if (args[0].indexOf('!') != -1) { //checks that the ! operation is specified.
					args[0] = args[0].replace("!", ""); //trims the ! from string (eg. in 5!, we only need the 5)
					int factorialnum = Integer.parseInt(args[0]); //converts the string to double for calculation.
					System.out.println("Result: " + factorial(factorialnum));
				} else {
					throw new IllegalArgumentException("Operator not specified. Did you mean " + args[0] + "! ? Try again.");
				}
				
			}
			
		} else {
			//In event of no CLI arguments, ask for user input.
			Scanner scan = new Scanner(System.in);
			System.out.println("No CLI arguments detected, or arguments do not match specifications.");
			while (true) {
				System.out.print("Enter operation to perform (i.e. add, subtract, multiply, divide, factorial, exponentiation, square root, natural logarithm, base-10 logarithm, sin, cos, tan) type exit to exit program: ");
				String operation = scan.next();
				
				if (operation.equalsIgnoreCase("exit")) {
					System.out.println("Closing Program...");
					break;
				}
				System.out.println("\nResult: " + handle(operation));
				
			}
			scan.close();
			
		}
		
		
	}
	
	public static double handle(String operation) {
		Scanner scan = new Scanner(System.in);

		
		switch(operation.toLowerCase()) {
		case "add":
			System.out.print("Enter the first operand: ");
			double num1 = scan.nextDouble();
			
			System.out.print("Enter the second operand: ");
			double num2 = scan.nextDouble();
			
			return add(num1, num2);
		case "subtract":
			System.out.print("Enter the first operand: ");
			double sub1 = scan.nextDouble();
			
			System.out.print("Enter the second operand: ");
			double sub2 = scan.nextDouble();
			
			return subtract(sub1, sub2);
		case "multiply":
			System.out.print("Enter the first operand: ");
			double mult1 = scan.nextDouble();
			
			System.out.print("Enter the second operand: ");
			double mult2 = scan.nextDouble();
			
			return multiply(mult1, mult2);
		case "divide":
			System.out.print("Enter the first operand: ");
			double div1 = scan.nextDouble();
			
			System.out.print("Enter the second operand: ");
			double div2 = scan.nextDouble();
			
			if (div2 == 0) {
				throw new IllegalArgumentException("Can not divide by zero, use a different second operation.");
			} else {
				return divide(div1, div2);
			}
		case "factorial":
			//Factorial requires integer argument
			System.out.print("Enter number to calculate its factorial: ");
			double factorial = scan.nextDouble();
			
			return factorial((int)factorial);
		case "exponentiation":
			System.out.print("Enter base number: ");
			double base = scan.nextDouble();
			
			System.out.print("Enter exponent number");
			double exponent = scan.nextDouble();
			
			return power(base, exponent);
		case "square root":
			System.out.print("Enter number to calculate square root of: ");
			double root = scan.nextDouble();
			
			return sqrt(root);
		case "natural logarithm":
			System.out.print("Enter number to calculate its natural logarithm: ");
			double ln = scan.nextDouble();
			
			return ln(ln);
		case "base-10 logarithm":
			System.out.print("Enter number to find its base-10 logarithm: ");
			double log = scan.nextDouble();
			
			return log(log);
		case "sin":
			System.out.print("Enter angle to sin(): ");
			double angle = scan.nextDouble();
			System.out.print("Is the angle in radians or degrees?: ");
			String units = scan.next();
			
			if (units.equals("radians")) {
				return sin(angle);
			} else if (units.equals("degrees")) {
				double angleRad = Math.toRadians(angle);
				return sin(angleRad);
			} else {
				System.out.println(units);
				throw new IllegalArgumentException("units not properly specified.");
			}
		case "cos":
			System.out.print("Enter angle to cos(): ");
			double anglecos = scan.nextDouble();
			System.out.print("Is the angle in radians or degrees?: ");
			String unitscos = scan.next();
			
			if (unitscos.equals("radians")) {
				return cos(anglecos);
			} else if (unitscos.equals("degrees")) {
				double angleRad = Math.toRadians(anglecos);
				return cos(angleRad);
			} else {
				throw new IllegalArgumentException("units not properly specified.");
			}
		case "tan":
			System.out.print("Enter angle to tan(): ");
			double angletan = scan.nextDouble();
			System.out.print("Is the angle in radians or degrees?: ");
			String unitstan = scan.next();
			
			if (unitstan.equals("radians")) {
				return tan(angletan);
			} else if (unitstan.equals("degrees")) {
				double angleRad = Math.toRadians(angletan);
				return tan(angleRad);
			} else {
				throw new IllegalArgumentException("units not properly specified.");
			}
		default:
			scan.close();
			throw new IllegalArgumentException("Operator not accepted, try again."); //TODO message
		}
		
		
	}
	
	public static double add(double num1, double num2) {
		/**
		 * @param args accepts two double variables.
		 * 
		 * Adds two numbers together.
		 */
		return num1 + num2;
	}
	
	public static double subtract(double num1, double num2) {
		/**
		 * @param args accepts two double variables.
		 * 
		 * Subtracts two numbers together.
		 */
		return num1 - num2;
	}
	
	public static double multiply(double num1, double num2) {
		/**
		 * @param args accepts two double variables.
		 * 
		 * Multiplies two numbers together.
		 */
		return num1 * num2;
	}
	
	public static double divide(double num1, double num2) {
		/**
		 * @param args accepts two double variables.
		 * 
		 * Divides two numbers together assuming num2 != 0.
		 */
		return num1/num2;
	}
	
	public static long factorial(int n) {
		/**
		 * @param args accepts one double variable.
		 * 
		 * Recursively calculates the factorial of one number.
		 */
		System.out.print("\n");
		if (n < 0) {
			System.out.println("Factorial of negative number is undefined.");
			return 0;
		} else {
			return factorialHelper(n, n);
		}
	}
	
	private static long factorialHelper(int originalNum, int num) {
		/* Calculate progress and update progress bar 
		 * The progress bar never reaches 100% because (originalNum - 1) / originalNum is always less than .
		 * To ensure that the progress reaches 100% when num is 1, we need to modify the calculation for the case when num is 1.
		 */
		int progress = num == 1 ? 100 : (int)(((originalNum - num) / (double) originalNum) * 100);
		//When num is 1, progress is set to 100%
		System.out.print("\rCalculating factorial: " + progress + "%");
		
		if (num <= 1) {
			return 1; //base case *1
		}
		return num * factorialHelper(originalNum, num - 1); //TODO fix progress bar never showing 100% completion.
	}
	
	//Exponentiation
	public static double power(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	//Square root
	public static double sqrt(double num) {
			return Math.sqrt(num);
	}
	//Natural logarithm
	public static double ln(double num) {
		return Math.log(num);
	}
	//Base-10 logarithm
	public static double log(double num) {
		return Math.log10(num);
	}
	//Sine
	public static double sin(double angleRad) {
		return Math.sin(angleRad);
	}
	public static double cos(double angleRad) {
		return Math.cos(angleRad);
	}
	public static double tan(double angleRad) {
		return Math.tan(angleRad);
	}
	
}
