package oy.interact.tira.student;

import java.util.EmptyStackException;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   /**
    * TODO: Student: Implement this method which checks if the given string has matching opening and closing
    * parentheses. It should check for matching parentheses:

    *   Lorem ipsum ( dolor sit {  amet, [ consectetur adipiscing ] elit, sed } do eiusmod tempor ) incididunt ut...,
    * 
    * that can be found for example in Java source code and JSON structures.
    * 
    * If the string has issues with parentheses, you should throw a {@code ParenthesisException} with a
    * descriptive message and error code. Error codes are already defined for you in the ParenthesesException
    * class to be used.
    * 
    * NOTE: If the string contains quotation marks ("like this"), the text between quotation marks 
    * MUST be ignored. Why? In structured text, the rule of the parentheses applies only to the structured
    * text but not the text in quotation marks. It is totally valid to have JSON:
    * 
    * {
    *    "somekey": "Some value [ with that opening bracket only" 
    * }
    *
    * and that is perfectly ok and acceptable, also in source code like Java.
    *
    * Note that the exception thrown must include correct line and column numbers of the
    * place where it became obvious that there are incorrect parenthesis in the input text.
    *
    * What is to be tested about the incoming string:
    *
    * - If a quotation mark was found, all characters until the next quotation mark must be ignored.
    *   And obviously, before and after, all charactes must be checked if they are parenthesis chars.
    * - When an opening parenthesis is found in the string, it is successfully pushed to the stack (push may fail).
    * - When a closing parenthesis is found in the string, chech that a matching opening parenthesis is popped from the stack.
    * - If the stack was empty, this indicates an error, too many opening parentheses (or too few closing ones).
    *   Note that you can check if the stack is empty before calling pop() and throw an exception.
    * - When the string has been handled, and if the stack still has parentheses, there are too few closing parentheses.
    * 
    * @param stack The stack object used in checking the parentheses from the string.
    * @param fromString A string containing parentheses to check if it is valid.
    * @return Returns the number of parentheses found from the input in total (both opening and closing).
    * @throws ParenthesesException if the parentheses did not match as intended.
    * @throws StackAllocationException If the stack cannot be allocated or reallocated if necessary.
    */

    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {

      int lineNumber = 1;
      int columnNumber = 1;
      int parenthesesCount = 0;
      boolean insideQuotes = false;

      for (int i = 0; i < fromString.length(); i++) {
         char c = fromString.charAt(i);
      
         if (c == '"') {
             insideQuotes = !insideQuotes;
         }

         if (insideQuotes) {
            if (c == '\n') {
               lineNumber++;
               columnNumber = 1;
            }
            else {
               columnNumber++;
            }
         }
         else {
            if (c == '(' || c == '[' || c == '{') {
               parenthesesCount++;
               try {
                  stack.push(c);
               } catch (OutOfMemoryError O) {
                  throw new ParenthesesException("Couldn't add the starting parenthesis to the stack", lineNumber, columnNumber, ParenthesesException.STACK_FAILURE);
               }
            }
            else if (c == ')' || c == ']' || c == '}') {
               parenthesesCount++;
               if (stack.isEmpty()) {
                  throw new ParenthesesException("There are too many closing parentheses", lineNumber, columnNumber, ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
               }
               char opening = stack.pop();
               if ((c == ')' && opening != '(') || (c == ']' && opening != '[') || (c == '}' && opening != '{')) {
                  throw new ParenthesesException("Opening and closing parentheses did not match", lineNumber, columnNumber, ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
               }
            }
         }
             if (c == '\n') {
                 lineNumber++;
                 columnNumber = 1;
             }
             else {
               columnNumber++;
             }
         }

     if (!stack.isEmpty()) {
      throw new ParenthesesException("There are too many opening parentheses", lineNumber, columnNumber, ParenthesesException.TOO_MANY_OPENING_PARENTHESES);
     }

     return parenthesesCount;
   }
}
