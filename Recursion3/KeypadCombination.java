public class KeypadCombination {

  public static String[] keypadCombination(int number){

    if(number == 0 || number == 1){
      String[] output = new String[1];
      output[0] = "";
      return output;
    }

    String[] smallOutput = keypadCombination(number/10);
    int lastDigit = number%10;
    String str = getCombination(lastDigit);
    String[] output = new String[smallOutput.length * str.length()];
    int x = 0;
    for(String st : smallOutput){
       for(int j = 0; j < str.length(); j++){
          output[x] = st + str.charAt(j);
          x++;
       }
    }
    return output;

  }
  
  public static String getCombination(int number){
    String output = "";
    switch (number) {
      case 2:
        output = "abc";
        break;
      case 3:
        output = "def";
        break;
      case 4:
        output = "ghi";
        break;
      case 5:
        output = "jkl";
        break;
      case 6:
        output = "mno";
        break;
      case 7:
        output = "pqrs";
        break;
      case 8:
        output = "tuv";
        break;
      case 9:
        output = "wxyz";
        break;
      default:
        break;
    }
    return output;
  }

  public static void main(String[] args) {
    String[] output = keypadCombination(23);
    for(String s : output){
      System.out.print(s + " ");
    }
  }
}


