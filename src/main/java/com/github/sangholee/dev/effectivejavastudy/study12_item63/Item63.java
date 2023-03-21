package com.github.sangholee.dev.effectivejavastudy.study12_item63;

public class Item63 {

    public static void main(String[] args) {
        case1();
        case2();
        case3();
        case4();
    }

    private static void case1() {
        String str1 = "0" + "1" + "2";

        //컴파일 이 후, 디컴파일 한 소스파일
//        String str1 = "012";
    }

    private static void case2() {
        String str2 = "";
        str2 += 0;
        str2 += 1;
        str2 += 2;


        //컴파일 이 후, 디컴파일 한 소스파일
//        String str2 = "";
//        str2 = (new StringBuilder()).append(str2).append("0").toString();
//        str2 = (new StringBuilder()).append(str2).append("1").toString();
//        str2 = (new StringBuilder()).append(str2).append("2").toString();

    }

    private static void case3() {
        String str3 = "";
        for (int i = 0; i < 3; i++) {
            str3 += i;
        }


        //컴파일 이 후, 디컴파일 한 소스파일
//        String str3 = "";
//        for(int i = 0; i < 3; i++) {
//            str3 = (new StringBuilder()).append(s2).append(i).toString();
//        }
    }

    private static void case4() {
        String str4 = ""
                .concat("0")
                .concat("1")
                .concat("2");


        //컴파일 이 후, 디컴파일 한 소스파일
//        String str4 = "".concat("0").concat("1").concat("2");

    }

}
