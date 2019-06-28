package com.example.abdullahal_munzir.twoscomplement;

/**
 * Created by Abdullah Al-Munzir on 2/5/2018.
 */

public class Complement {

    public String complement(String digit){

        int len = digit.length();
        int i;
        String res;


        char[] arry;
        char[] arry1 = new char[len];
        char[] arry2 = new char[len];

        arry = digit.toCharArray();


        for (i = 0; i < len; i++) {
            if (arry[i] == '0') {
                arry1[i] = '1';
            } else {
                arry1[i] = '0';
            }
        }

        for (i = 0; i < len; i++) {
            arry2[i] = arry1[i];
        }


        for (i = len - 1; i >= 0; i--) {
            if (arry1[i] == '1') {
                arry2[i] = '0';
            } else {
                arry2[i] = '1';
                break;
            }
        }

        res = new String(arry2);
        return res;
    }

    public String BtoD(String digit) throws RuntimeException {
        int dec = Integer.parseInt(digit, 2);
        String res = Integer.toString(dec);
        return res;
    }

    public String BtoH(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit, 2);
        String hexa = Integer.toHexString(num).toUpperCase();
        return hexa;
    }

    public String BtoO(String digit)throws RuntimeException {
        int num;
        num = Integer.parseInt(digit, 2);
        String octal = Integer.toOctalString(num);
        return octal;
    }




    public String DtoB(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit);
        String res = Integer.toBinaryString(num);
        return res;
    }
    public String HtoB(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit, 16);
        String res = Integer.toBinaryString(num);
        return  res;
    }

    public String OtoB(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit, 8);
        String res = Integer.toBinaryString(num);
        return res;
    }


    public String DtoO(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit);
        String res = Integer.toOctalString(num);
        return res;
    }

    public String DtoH(String digit)throws RuntimeException {
        int num = Integer.parseInt(digit);
        String res = Integer.toHexString(num).toUpperCase();
        return res;
    }

    public boolean isNumeric(String str)
    {
        return str.matches("-?\\d+?");  //match a number with optional '-' and decimal.
    }

    public boolean isBinary(String str)
    {
        return str.matches("[0-1]+?");  //match a number with 0 or 1
    }

    public boolean isOctal(String str)
    {
        return str.matches("[0-7]+?");  //match a number with 0 to 7
    }

    public boolean isHexa(String str)
    {
        return str.matches("[0-9A-Fa-f]+?");  //match a number with hexa string.
    }


}
