package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class CheckNumbers {

    private BigInteger requestNum;
    private int targetNum;
    private String[] properties;


    public CheckNumbers(BigInteger requestNum, int targetNum, String[] properties) {
        this.requestNum = requestNum;
        this.targetNum = targetNum;
        this.properties = properties;
    }

    public CheckNumbers(BigInteger requestNum, int targetNum) {
        this.requestNum = requestNum;
        this.targetNum = targetNum;
    }

    public CheckNumbers(BigInteger requestNum) {
        this.requestNum = requestNum;
    }

    public boolean isEven(BigInteger input) {
        return input.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }

    public boolean isOdd(BigInteger input) {
        return !input.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }

    public boolean isBuzz(BigInteger input) {
        boolean isLastSeven = false;
        boolean isBuzz = false;
        String inputStr = String.valueOf(input);
        if (inputStr.endsWith("7")) isLastSeven = true;

        if (isLastSeven || input.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO)) isBuzz = true;

        return isBuzz;
    }

    public boolean isDuck(BigInteger input) {
        boolean isDuck = false;
        String inputStr = String.valueOf(input);

        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == '0') {
                isDuck = true;
                break;
            }
        }
        return isDuck;
    }

    public boolean isPalindromic(BigInteger input) {
        boolean isPalindromic = false;
        String inputStr = String.valueOf(input);

        String inputStrReversed = "";
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            inputStrReversed += inputStr.charAt(i);
        }
        if (inputStr.equals(inputStrReversed)) isPalindromic = true;

        return isPalindromic;
    }

    public boolean isGapful(BigInteger input) {
        boolean isGapful = false;
        String inputStr = String.valueOf(input);

        String[] inputNums = inputStr.split("");
        char[] firstAndLastChar = {inputStr.charAt(0), inputStr.charAt(inputStr.length() - 1)};
        String firstAndLast = String.valueOf(firstAndLastChar);
        int firstAndLastToInt = Integer.parseInt(firstAndLast);
        if (inputNums.length >= 3 && input.mod(BigInteger.valueOf(firstAndLastToInt)).equals(BigInteger.ZERO))
            isGapful = true;
        return isGapful;
    }

    public boolean isSpy(BigInteger input) {
        boolean isSpy = false;
        String inputStr = String.valueOf(input);
        String[] inputNums = inputStr.split("");
        int[] nums = new int[inputNums.length];
        for (int i = 0; i < inputNums.length; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }
        int counter = 0;
        int multiplication = 1;
        for (int i : nums) {
            counter += i;
        }
        for (int i : nums) {
            multiplication *= i;
        }
        if (counter == multiplication) isSpy = true;

        return isSpy;
    }

    public boolean isSquare(BigInteger input) {
        boolean isSquare = false;
        BigInteger[] sqrt = input.sqrtAndRemainder();
        if (sqrt[1].equals(BigInteger.ZERO)) {
            isSquare = true;
        }
        return isSquare;
    }

    public boolean isSunny(BigInteger input) {
        boolean isSunny = false;
        input = input.add(BigInteger.ONE);
        BigInteger[] sqrt = input.sqrtAndRemainder();
        if (sqrt[1].equals(BigInteger.ZERO) && !input.equals(BigInteger.ONE)) {
            isSunny = true;
        }
        return isSunny;
    }

    public boolean isJumping(BigInteger input) {
        boolean isJumping = false;
        if (input.compareTo(BigInteger.TEN) == 1){
            String inputToString = input.toString();
            int[] numbers = new int[inputToString.length()];
            for (int i = 0; i < numbers.length; i++) {
                int newNum = Integer.parseInt(String.valueOf(inputToString.charAt(i)));
                numbers[i] = newNum;
            }
            int counter = 1;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (Math.abs(numbers[i] - numbers[i + 1]) == 1 && Math.abs(numbers[numbers.length - 1] - numbers[numbers.length - 2]) == 1) {
                    counter++;
                }
            }
            if (counter == numbers.length) isJumping = true;
        } else {
            return true;
        }
        return isJumping;
    }

    public String happyLogic(String inputStr) {
        List<Integer> numArr = new ArrayList<>();
        List<Integer> squared = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            numArr.add(Integer.parseInt(String.valueOf(inputStr.charAt(i))));
        }
        //System.out.println(numArr);
        for (int i = 0; i < numArr.size(); i++) {
            squared.add((int)(Math.pow(numArr.get(i), 2)));
        }
        //System.out.println(squared);
        int sum = 0;
        for (int i : squared) {
            sum += i;
        }
        //System.out.println(sum);
        return String.valueOf(sum);
    }

    public boolean isHappy(BigInteger input) {
        boolean isHappy = false;
        String inputStr = input + "";
        String inputCopy = this.happyLogic(inputStr);
        while (!inputCopy.equals("1")) {
            //System.out.println("inside while happy");
            inputCopy = this.happyLogic(inputCopy);
            if (inputCopy.equals(inputStr) || inputCopy.equals("4")) break;
        }
        if (inputCopy.equals("1")) {
            isHappy = true;
        }
        return isHappy;
    }

    public boolean isSad(BigInteger input) {
        boolean isSad = false;
        String inputStr = input + "";
        String inputCopy = this.happyLogic(inputStr);
        while (!inputCopy.equals(inputStr)) {
            //System.out.println("inside while sad");
            inputCopy = this.happyLogic(inputCopy);
            if (inputCopy.equals("1") || inputCopy.equals("4")) break;
        }
        if (inputCopy.equals("1")) {
            isSad = false;
        } else if (inputCopy.equals(inputStr) || inputCopy.equals("4")) {
            isSad = true;
        }
        return isSad;
    }

    public void checkOneNumber(BigInteger input) {
        System.out.printf("Properties of %d\n" +
                        "buzz: %b\n" +
                        "duck: %b\n" +
                        "palindromic: %b\n" +
                        "gapful: %b\n" +
                        "spy: %b\n" +
                        "square: %b\n" +
                        "sunny: %b\n" +
                        "jumping: %b\n" +
                        "happy: %b\n" +
                        "sad: %b\n" +
                        "even: %b\n" +
                        "odd: %b\n", input, this.isBuzz(input), this.isDuck(input), this.isPalindromic(input), this.isGapful(input),
                this.isSpy(input), this.isSquare(input), this.isSunny(input), this.isJumping(input), this.isHappy(input), this.isSad(input), this.isEven(input), this.isOdd(input));
    }

    public void checkRangeOfNumbers(BigInteger input, int targetNum) {
        for (int i = 0; i < targetNum; i++) {
            //System.out.println("inside for");
            StringBuilder attached = new StringBuilder();

            if (this.isBuzz(input.add(BigInteger.valueOf(i)))) attached.append(" buzz,");
            if (this.isDuck(input.add(BigInteger.valueOf(i)))) attached.append(" duck,");
            if (this.isPalindromic(input.add(BigInteger.valueOf(i)))) attached.append(" palindromic,");
            if (this.isGapful(input.add(BigInteger.valueOf(i)))) attached.append(" gapful,");
            if (this.isSpy(input.add(BigInteger.valueOf(i)))) attached.append(" spy,");
            if (this.isSquare(input.add(BigInteger.valueOf(i)))) attached.append(" square,");
            if (this.isSunny(input.add(BigInteger.valueOf(i)))) attached.append(" sunny,");
            if (this.isJumping(input.add(BigInteger.valueOf(i)))) attached.append(" jumping,");
            if (this.isHappy(input.add(BigInteger.valueOf(i)))) attached.append(" happy,");
            if (this.isSad(input.add(BigInteger.valueOf(i)))) attached.append(" sad,");
            if (this.isEven(input.add(BigInteger.valueOf(i)))) attached.append(" even,");
            if (this.isOdd(input.add(BigInteger.valueOf(i)))) attached.append(" odd,");
            //System.out.println("inside for");

            System.out.println(input.add(BigInteger.valueOf(i)) + " is" + attached.deleteCharAt(attached.length() - 1));
        }
    }

    public void checkForPropertyMethod(BigInteger input) {

        StringBuilder attached = new StringBuilder();
        if (this.isBuzz(input)) attached.append(" buzz,");
        if (this.isDuck(input)) attached.append(" duck,");
        if (this.isPalindromic(input)) attached.append(" palindromic,");
        if (this.isGapful(input)) attached.append(" gapful,");
        if (this.isSpy(input)) attached.append(" spy,");
        if (this.isSquare(input)) attached.append(" square,");
        if (this.isSunny(input)) attached.append(" sunny,");
        if (this.isJumping(input)) attached.append(" jumping,");
        if (this.isHappy(input)) attached.append(" happy,");
        if (this.isSad(input)) attached.append(" sad,");
        if (this.isEven(input)) attached.append(" even,");
        if (this.isOdd(input)) attached.append(" odd,");
        System.out.println(input + " is" + attached.deleteCharAt(attached.length() - 1));
    }

    public boolean switchCheckNumber(String userInput, BigInteger input) {
        return switch (userInput) {
            case "BUZZ" -> this.isBuzz(input);
            case "DUCK" -> this.isDuck(input);
            case "PALINDROMIC" -> this.isPalindromic(input);
            case "GAPFUL" -> this.isGapful(input);
            case "SPY" -> this.isSpy(input);
            case "SQUARE" -> this.isSquare(input);
            case "SUNNY" -> this.isSunny(input);
            case "JUMPING" -> this.isJumping(input);
            case "HAPPY" -> this.isHappy(input);
            case "SAD" -> this.isSad(input);
            case "EVEN" -> this.isEven(input);
            case "ODD" -> this.isOdd(input);
            default -> false;
        };
    }

    public void checkAllProperties(BigInteger input, int secondNum, String[] properties) {
        int foundNumbers = 0;
        while (foundNumbers < secondNum) {
            //System.out.println("inside while");
            int counter = 0;
            for (String s : properties) {
                //System.out.println("inside for");
                String minusLess = s.substring(1);
                if (s.charAt(0) != '-' && this.switchCheckNumber(s, input)) {
                    counter++;
                } else if (s.charAt(0) == '-' && this.switchCheckNumber(minusLess, input)) {
                    break;
                } else if (s.charAt(0) == '-' && !this.switchCheckNumber(minusLess, input)) {
                    counter++;
                }
            }
            //System.out.println("after for");
            if (counter == properties.length) {
                //System.out.println("inside if");
                this.checkForPropertyMethod(input);
                foundNumbers++;
            }
            //System.out.println("after if");
            input = input.add(BigInteger.ONE);
        }
    }
}
