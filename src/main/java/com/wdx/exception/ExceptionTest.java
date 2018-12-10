package com.wdx.exception;

import java.util.Random;

public class ExceptionTest {


    public static void main(String[] args){

        ExceptionTest  exceptionTest = new ExceptionTest();
        BizException bizException = exceptionTest.createException();

        Random random = new Random();
        for(int i =0 ; i < 10 ; i++){
            int randomInt = random.nextInt(10);
            if(randomInt%2 == 0){
                throw bizException;
            }
        }

        System.out.println("结束");

    }

    /**
     * 异常日志都是打印new Exception的代码行
     * @return
     */
    public BizException createException(){
        BizException bizException = new BizException("自定义异常");
        return bizException;
    }
}
