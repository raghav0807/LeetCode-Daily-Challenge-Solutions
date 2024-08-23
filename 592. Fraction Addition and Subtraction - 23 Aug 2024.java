class Solution {
  public String fractionAddition(String expression) {
      if (expression.charAt(0) != '+' && expression.charAt(0) != '-') {
          expression = "+" + expression;
      }

      int numerator = 0, denominator = 1;
      int i = 0;

      while (i < expression.length()) {
          int sign = expression.charAt(i++) == '+' ? 1 : -1;

          int num = 0;
          while (i < expression.length() && expression.charAt(i) != '/') {
              num = num * 10 + (expression.charAt(i++) - '0');
          }
          i++; 

          int den = 0;
          while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
              den = den * 10 + (expression.charAt(i++) - '0');
          }

          numerator = numerator * den + sign * num * denominator;
          denominator *= den;

          int gcd = gcd(Math.abs(numerator), denominator);
          numerator /= gcd;
          denominator /= gcd;
      }

      return numerator + "/" + denominator;
  }

  private int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
  }
}


