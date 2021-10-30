package com.ap;

import java.util.ArrayList;
import java.util.List;

public class StringChildren {

    public static void main(String[] args) {

        getChildren("hit").forEach(System.out::println);
    }

    private static List<String> getChildren(String parent) {

        List<String> children = new ArrayList<>();

        char[] parentCharArray = parent.toCharArray();

        for (int i=0; i<parentCharArray.length; i++) {
            char temp = parentCharArray[i];
            for (char c = 'a' ; c <= 'z' ; c++) {
                if (temp != c) {
                    parentCharArray[i] = c;
                    children.add(new String(parentCharArray));
                }
            }
            parentCharArray[i] = temp;
        }
        return children;
    }

}
