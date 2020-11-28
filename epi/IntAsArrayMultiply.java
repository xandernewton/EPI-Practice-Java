package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {

    //num1 = new ArrayList<>(Arrays.asList(-1, 2));
    //num2 = new ArrayList<>(Arrays.asList(1,2));
    List<Integer> minList;
    List<Integer> maxList;
    double finalSign = 1;

    if((num1.get(0) < 0 && num2.get(0) > 0) || (num1.get(0) > 0 && num2.get(0) < 0)){
      finalSign = -1;
    }

    num1.set(0, Math.abs(num1.get(0)));
    num2.set(0, Math.abs(num2.get(0)));

    if(num1.size() <= num2.size()){
      minList = num1;
      maxList = num2;
    }
    else{
      minList = num2;
      maxList = num1;
    }
    double number1;
    double currentNum = 0;
    double total = 0;

    List<Integer> productList = new ArrayList<>();

    for(int i=minList.size()-1; i >= 0; i--) {
      number1 = minList.get(i);
      currentNum = 0;
      for (int j = maxList.size()-1; j >= 0; j--) {

        //System.out.println((number1 * maxList.get(j)) * Math.pow(10, maxList.size() - j -1));
        currentNum += (number1 * maxList.get(j)) * Math.pow(10, maxList.size() - j -1);
      }
      total += currentNum * Math.pow(10,minList.size() - i -1);
    }
    //total = total * finalSign;

    List<Integer> digitList = new ArrayList<Integer>();

    final int numDigits = (int)(Math.floor(Math.log10(total))) + 1;
    Double digit;
    Double msdMask = Math.pow(10, numDigits - 1);
    for (int i = 0; i < numDigits; ++i) {
      digit = Math.floor(total/ msdMask);
      digitList.add(digit.intValue());
      total %= msdMask; // Remove the most significant digit of x.
      msdMask /= 10;
    }

    System.out.println(digitList);
    return digitList;
  }


  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
