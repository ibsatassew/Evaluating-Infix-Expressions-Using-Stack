/**
*  Evaluates infix expressions by converting infix to postfix and evaluate postfix
*  expressions using stacks.

*  @author Ibsa Tassew Geleta 

*  Compile and run with:
*     $ javac InfixEvalTest.java 
*     $ java InfixEvalTest < input_file_name
*/

import java.util.Scanner;

public class InfixEvalTest {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);

      while (sc.hasNext()) {
         String infix = sc.nextLine();
         System.out.println(infix);
         String postfix = infixToPostfix(infix);
         System.out.println(postfix);
         int value = evalPostfix(postfix);
         System.out.println(value);
      }
   }

   private static String infixToPostfix(String infix) {
      // declare a stack of operators
      Stack<Character> oprStack = new LStack<Character>();
	String postfix = "";
      // tokenize infix string
      String[] token = infix.split(" ");

      for (int i = 0; i < token.length; i++) {
         if (isInt(token[i])) { // Is this a numeric string? Then it must be an operand.
            postfix = postfix + token[i] + " ";
         }
         else {
           char op = token[i].charAt(0);  // extract operator
            if(oprStack.length() == 0) {
            	oprStack.push(op);
            	continue;
            }
           int value = prec(op, oprStack.topValue()); //order of precedence 
            if(value == 0 || value == -1){
            	if(op == '('|| oprStack.topValue() == '('){
            		oprStack.push(op);
            	}
            	else {
            	if(op != '('){
            	postfix = postfix + oprStack.pop() + " ";  
            	oprStack.push(op);  
            	}
            	}   
            
            }
            else if(op == ')'){
            	if(op != '('){
            	while(oprStack.topValue() != '('){
            	    postfix = postfix + oprStack.pop() + " " ;
            }
            	oprStack.pop();
            }
            }
            
            else {
            	oprStack.push(op);
            }
          }
      }
    	int value = oprStack.length();
      	for (int i = 0; i < value; i++){
      		postfix = postfix + oprStack.pop() + " "; 
      	}
     
      return postfix; // need to return a real postfix string
   }
   

   private static int evalPostfix(String postfix) {
      // declare a stack of operands
      Stack<Integer> opnStack = new LStack<Integer>();

      // tokenize postfix string
      String[] token = postfix.split(" ");
      for (int i = 0; i < token.length; i++) {
         if (isInt(token[i])) { // Is this a numeric string? Then it must be an operand.
             	int opn = Integer.parseInt(token[i]);
             	opnStack.push(opn);
         }
         else {
            char op = token[i].charAt(0);  // extract operator
            int opn2 = opnStack.pop();
            int opn1 = opnStack.pop();
            int result = 0;
            if(op == '+'){
            	result = opn1 + opn2;
            }
            else if (op == '-'){
            	result = opn1 - opn2;
            }
            else if (op == '*'){
            	result = opn1*opn2;
            }
            else {
            	result = opn1/opn2;
            }
            opnStack.push(result);
         }
      }   
      return opnStack.pop(); // need to return a real value
   }

   /**
   * @return true if the string s is a numeric string; false otherwise
   */
   private static boolean isInt(String s) {
      return s.matches("-?[1-9][0-9]*|0"); // regular expression for integers
   }

   /**
   * @return 0  if both operators have the same precedence
   *         -1 if opr2 has higher precedence
   *         1  if opr1 has higher precedence
   */
   private static int prec(char opr1, char opr2) {
      int value = 0;
      switch(opr1) {
         case '+': 
         case '-':
            if (opr2 == '+' || opr2 == '-')
               value = 0; // equal precedence
            else 
               value =  -1; // opr2 has higher precedence
            break;
         case '*':
         case '/':
            if (opr2 == '+' || opr2 == '-')
               value = 1; // opr1 has higher precedence
            else if (opr2 == ')' || opr2 == '(')
               value = -1;
            else
               value = 0;
            break;
         case ')':
         case '(':
            if (opr2 == '+' || opr2 == '-' || opr2 == '*' || opr2 == '/')
               value = 1; // opr1 has higher precedence
            else
               value = 0;
            break;
      }
      return value; // won't get here
   }
}
/** Link to GitHUb repository  */
