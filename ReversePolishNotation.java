import java.util.Scanner;

class StackNode {
	public StackNode(double data, StackNode underneath) {
		this.data = data;
		this.setUnderneath(underneath);
	}
	public double getData() {
		return data;
	}
	public StackNode getUnderneath() {
		return underneath;
	}
	public void setUnderneath(StackNode underneath) {
		this.underneath = underneath;
	}
	private StackNode underneath;
	private final double data;
}


class ReversePolishNotation {
	public void into(double newData) {
		StackNode newNode = new StackNode(newData, top);
		top = newNode;
}

	
public double outOf( ) {
	double topData = top.getData();
	top = top.getUnderneath();
	return topData;
}

public char iChar(int i) {
	return command.charAt(i);
}


public ReversePolishNotation(String command) {
	top = null;
	this.command = command;
}

public double get( ) {
	double a ;
	double b ;
	int j;
	double number;
	
	for(int i = 0; i < command.length( ); i++) {
		// if it's a digit
		if(Character.isDigit(iChar(i))) {
			// get a string of the number
			StringBuilder temp = new StringBuilder();
			for(j = 0; j < 100; j++, i++ ) {
				if(!Character.isDigit(iChar(i)) && (iChar(i) != '.')) {
					break;
				}
				temp.append(iChar(i));
			}
			String tempString = temp.toString();
			// convert to double and add to the stack
			number = Double.parseDouble(tempString);
			into(number);
			} else if(iChar(i) == '+') {
				b = outOf( );
				a = outOf( );
				into(a + b);
			} else if(iChar(i) == '-') {
				b = outOf( );
				a = outOf( );
				into(a - b);
			} else if(iChar(i) == '*') {
				b = outOf( );
				a = outOf( );
				into(a * b);
			} else if(iChar(i) == '/') {
				b = outOf( );
				a = outOf( );
				into(a / b);
			} else if(iChar(i) == '^') {
				b = outOf( );
				a = outOf( );
				into(Math.pow(a, b));
				
			} else if(iChar(i) != ' ') {
				throw new IllegalArgumentException( );
		}
	}
	double value = outOf( );
	if(top != null) {
		throw new IllegalArgumentException( );
	}
	return value;
}

private String command;
private StackNode top;

/* main method */
public static void main(String args[]) {
	while(true) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter RPN expression or \"quit\".");
		String line = in.nextLine( );
		if(line.equals("quit")) {
			break;
		} else {
			ReversePolishNotation calc = new ReversePolishNotation(line);
			System.out.printf("Answer is %f%n", calc.get( ));
			}
		} 
	}
}