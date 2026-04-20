package com.ll;

import java.util.*;

public class Calc {
    public static int run(String value) {

        List<String> valueList = new ArrayList<>();

        value = calcBracket(value);
        inputList(valueList, value);


        for (int i = 0; i < valueList.size(); i++) {

            if (valueList.get(i).equals("*")) {
                int left = Integer.parseInt(valueList.get(i - 1));
                int right = Integer.parseInt(valueList.get(i + 1));

                valueList.remove(i - 1);
                valueList.remove(i - 1);
                valueList.remove(i - 1);
                valueList.add(i - 1, String.valueOf(left * right));
                i--;
            }
        }

        int result = Integer.parseInt(valueList.getFirst());
        for (int j = 1; j < valueList.size(); j += 2) {
            String op = valueList.get(j);
            int next = Integer.parseInt(valueList.get(j + 1));
            if (op.equals("+")) result += next;
            else if (op.equals("-")) result -= next;
        }

        return result;


    }

    public static String calcBracket(String value) {
        while(value.contains("(")) {
            int openIndex = value.lastIndexOf("(");
            int closeIndex = value.indexOf(")", openIndex);

            String inner = value.substring(openIndex + 1, closeIndex);
            int result = run(inner);

            value = value.substring(0, openIndex) + result + value.substring(closeIndex + 1);
        }
        return value;
    }


    public static void inputList(List<String> valueList, String value) {
        String[] bits = value.split(" ");

        valueList.addAll(Arrays.asList(bits));

    }


}
