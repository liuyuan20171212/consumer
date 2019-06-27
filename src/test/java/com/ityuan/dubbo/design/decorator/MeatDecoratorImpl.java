package com.ityuan.dubbo.design.decorator;

/**
 * 荤菜肉类烹饪装饰器
 *
 * @Author ityuan
 * @Date 2019-06-27 14:24
 */
public class MeatDecoratorImpl extends CookDecorator {

    public MeatDecoratorImpl(CookService cookService) {
        super(cookService);
    }

    @Override
    public void cook() {
        System.out.println("烹饪荤菜，加料酒");
        super.cook();
    }
}
