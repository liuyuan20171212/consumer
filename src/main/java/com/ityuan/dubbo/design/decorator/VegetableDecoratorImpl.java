package com.ityuan.dubbo.design.decorator;

/**
 * 素菜烹饪装饰器
 *
 * @Author ityuan
 * @Date 2019-06-27 14:17
 */
public class VegetableDecoratorImpl extends CookDecorator {

    public VegetableDecoratorImpl(CookService cookService) {
        super(cookService);
    }

    @Override
    public void cook() {
        System.out.println("烹饪素菜，不加料酒");
        super.cook();
    }
}
