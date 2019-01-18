package com.wdx.thread.communication;

public class ShareObject {

    private int num = 1;
    private char str = 'a';

    public void printNumber(){
        System.out.print(num);
        num++;
        System.out.print(num);
    }

    public void printChar(){
        System.out.print(str);
        str++;
    }

    public static void main(String[] args) {
        ShareObject shareObject = new ShareObject();
        shareObject.printChar();
        System.out.println("");
        System.out.println("end");
    }
}
