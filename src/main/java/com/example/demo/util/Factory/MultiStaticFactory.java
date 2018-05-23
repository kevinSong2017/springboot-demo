package com.example.demo.util.Factory;

public class MultiStaticFactory {

    public  static  Product1 getProduct1(){
        return new Product1();
    }

    public static Product2 getProduct2(){
        return  new Product2();
    }

    public static  Product3 getProduct3(){
        return new Product3();
    }

}
