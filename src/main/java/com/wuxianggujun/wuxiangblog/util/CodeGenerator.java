package com.wuxianggujun.wuxiangblog.util;

import java.util.Scanner;

public class CodeGenerator {

    private static String scanner(String line) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入"+line+": ");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String input = scanner.next();
//            if (StringUtils.isNotEmpty(input)){
//                return input;
//            }
        }
        throw new RuntimeException("请输入正确的"+line+"! ");
    }

    public static void main(String[] args) {
        // 代码生成器

    }

}
