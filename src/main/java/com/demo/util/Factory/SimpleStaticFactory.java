package com.demo.util.Factory;


/**
 * 这就是简单工厂类
 */
public   class SimpleStaticFactory{
    private static final int TYPE_1=1;
    private static final int TYPE_2=2;
    private static final int TYPE_3=3;

    public static BaseProduct createProduct(int type){
        switch (type){
            case TYPE_1:
                return new Product1();

            case TYPE_2:
                return new Product2();

            case TYPE_3:
                return new Product3();

            default:
                return new Product1();
        }
    }


    public static void main(String[] args) {
        BaseProduct b= SimpleStaticFactory.createProduct(1);
        b.desc();
    }

}




/**
 * 产品基类
 */
abstract class BaseProduct {

    public abstract void desc();

}

/**
 * 具体产品类
 */
class Product1 extends  BaseProduct{

    @Override
    public void desc() {
        System.out.println("this is Product1");
    }
}

class Product2 extends  BaseProduct{
    @Override
    public void desc() {
        System.out.println("this is product2");
    }
}

class Product3 extends  BaseProduct{
    @Override
    public void desc() {
        System.out.println("this is product3");
    }
}























