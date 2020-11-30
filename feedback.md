# Questions Feedback

## Chapter 4

### 4.9 isNumberPalindromic

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


### 5.3 IntAsArrayMultiply

Initial attempt - get total sum then convert back to a list, however the final number was too big
for the divide and modulo operator to work without precision errors <br>
Optimal solution - to solve this without dealing with large numbers, the key was to accumulate the results
to the correct digit position on each loop

The code below shows that i + j controls the digit position then numbers from num1 and num2
are multiplied and to the corresponding digit. However, if the resulting number > 10
then the carry needs to moved to the next column to the left.

Ppdating i + j with /10 extracts the LSD while updating i + j + 1 with %10 extracts the rest of the digits.
This has the effect of propagating the carry numbers every loop. 

``` 
List<Integer> result =
           new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
       for (int i = num1.size() - 1; i >= 0; --i) {
         for (int j = num2.size() - 1; j >= 0; --j) {
           result.set(i + j + 1,
                      result.get(i + j + 1) + num1.get(i) * num2.get(j));
           result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
           result.set(i + j + 1, result.get(i + j + 1) % 10);
         }
 }
```

Here is an example:

``` 
  4 5 x
1 2 3
```

| 0 | 1 | 2  | 3  | 4  |
|---|---|----|----|----|
|   |   |    |    | 15 |
|   |   |    | 1  | 5  |
|   |   |    | 13 | 5  |
|   |   | 1  | 3  | 5  |
|   |   | 1  | 13 | 5  |
|   |   | 2  | 3  | 5  |
|   |   | 10 | 3  | 5  |
|   | 1 | 0  | 3  | 5  |
|   | 1 | 5  | 3  | 5  |
|   | 5 | 5  | 3  | 5  |
