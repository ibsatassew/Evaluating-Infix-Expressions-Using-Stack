/** 
    Modified from a code example in "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.io.*;

public class StackTest
{
   public static void main(String[] args) {
      Stack<Integer> S1 = new LStack<Integer>();
      Stack<Integer> S2 = new LStack<Integer>(15);

      S2.push(10);
      S2.push(20);
      S2.push(15);
      System.out.println(S2);
      while(S2.length() > 0) // repeat until the stack becomes empty
         S1.push(S2.pop());
      System.out.println(S1);
      System.out.println(S2);
   }
}
