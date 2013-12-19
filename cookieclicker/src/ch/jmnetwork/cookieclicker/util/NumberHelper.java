package ch.jmnetwork.cookieclicker.util;

public class NumberHelper {
    public String addApostropheToNumber(Long number) {
        String returnValue = "";
        String number_string = number + "";
        int times = 0;

        for (int i = 0; i < number_string.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                int from = number_string.length() - i;
                String split = number_string.substring(from, from + 3);
                returnValue = "'" + split + returnValue;
                times++;
            }
        }
        if (returnValue.length() != number_string.length() + times) {
            returnValue = number_string.substring(0, number_string.length() + times - returnValue.length()) + returnValue;
        }

        return returnValue;
    }
}
