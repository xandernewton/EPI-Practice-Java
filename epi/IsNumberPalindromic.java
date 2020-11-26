package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsNumberPalindromic {
  @EpiTest(testDataFile = "is_number_palindromic.tsv")
  public static boolean isPalindromeNumber(int x) {

    int number = x;

    if(number < 0){
      return false;
    }

    List<Integer> digitList= new ArrayList<>();
    while (number > 0) {
      Integer digit = number % 10;
      digitList.add(digit);
      number = number / 10;
    }

    //System.out.println(Arrays.toString(digitList.toArray()));
    //int i = 0; i < digitList.size() / 2; i++
    for (int i = 0; i < digitList.size() / 2; i++) {

     if(!digitList.get(i).equals(digitList.get(digitList.size() - i - 1))){
       return false;
     }

    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsNumberPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
