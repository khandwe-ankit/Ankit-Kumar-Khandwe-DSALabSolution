package BalancingBrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketSolution {
	public static void main(String[] args) {
//		String str = "{[(())]}";
//		String str = "([[{}]]))";

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		boolean balanced = true;

		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				st.push(c);
			} else {
				if (st.isEmpty()) {
					balanced = false;
					break;
				} else if (doesBracketComplement(st.pop(), c))
					continue;
				else {
					balanced = false;
					break;
				}
			}
		}
		if (balanced)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

	public static boolean doesBracketComplement(char a, char b) {
		switch (a) {
		case '(':
			if (b == ')')
				return true;
			break;
		case '[':
			if (b == ']')
				return true;
			break;
		case '{':
			if (b == '}')
				return true;
			break;
		}
//
//		if (a == '[' && b == ']')
//			return true;
//		else if (a == '{' && b == '}')
//			return true;
//		else if (a == '(' && b == ')')
//			return true;
//		else
//			return false;
		return false;

	}
}
