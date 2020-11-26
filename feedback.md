# Questions Feedback

## Chapter 4

# 4.9 isNumberPalindromic

Initial attempt - O(n) space, O(n) time <br>
Optimal solution - O(1) space - use the string representation directly by extracting the digits from the input

Tips: number of digits in a number is n = log10(x) + 1 <br>
Least significant digit (LSD)  = x mod 10 <br>
MSB = x/10<sup>n-1</sup>

``` 
final int numDigits = (int)(Math.floor(Math.log10(x))) + 1;
int msdMask = (int)Math.pow(10, numDigits - 1);
for (int i = 0; i < (numDigits / 2); ++i) {
 if (x / msdMask != x % 10) { // check next digit on the input
   return false;
 }
 x %= msdMask; // Remove the most significant digit of x.
 x /= 10;      // Remove the least significant digit of x.
 msdMask /= 100;
}
return true;
```

