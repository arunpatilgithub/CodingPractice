package com.ap;

import java.util.Stack;

// Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

// In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

// The canonical path should have the following format:

// - The path starts with a single slash '/'.
// - Any two directories are separated by a single slash '/'.
// - The path does not end with a trailing '/'.
// - The output path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')

// Return the simplified canonical path.

// /a/b/c/d -> /a/b/c/d
// /a///////b///c//////d -> /a/b/c/d

// /a/. -> /a

// /a/b/.. -> /a

// /a/b/c/... ->  /a/b/c/...

public class Upstart {

    public static void main(String[] args) {

        //String input = "/a/b///////c/...//";
        String input = "/a/b/c/...";

        String[] inputArr = input.split("/");

        Stack<String> stack = new Stack<>();

        for (String i : inputArr) {

            if (i != null && !i.equals("") && isChar(i.charAt(0))) {
                stack.push(i);
            } else if (i.equals("..")) {
                stack.pop();
            } else if (i != null && !i.equals("")) {
                stack.push(i);
            }

        }

        StringBuilder output = new StringBuilder("");

        for (String stackElement : stack) {
            output.append("/").append(stackElement);
        }

        System.out.println(output.toString());

    }

    private static boolean isChar(char c) {
        return c >= 97 && c <=122;
    }
}
