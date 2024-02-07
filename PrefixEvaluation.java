import java.util.Stack;

public class PrefixEvaluation{

	static int evaluatePrefix(String str){
		Stack<Integer> s=new Stack();
		for(int i=str.length()-1;i>=0;i--){
			if(check(str.charAt(i))){
				s.push((str.charAt(i)-'0'));
			}
			else{
				int op1=s.pop();
				int op2=s.pop();
				switch(str.charAt(i)){
					case '+':
						s.push(op1+op2);
						break;
					case '-':
						s.push(op1-op2);
						break;
					case '*':
						s.push(op1*op2);
						break;
					case '/':
						s.push(op1/op2);
						break;
					default:
						System.out.println("Invalid operation");
						break;
				}
			}
		}
		return s.peek();
	}


	static boolean check(char c){
		if(c>=48 && c<=57)
			return true;
		else
			return false;
	}
	public static void main(String args[]){
		String str="+5*4698";
		System.out.println(evaluatePrefix(str));
	}
}