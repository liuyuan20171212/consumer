package com.ityuan.dubbo.design.decorator;

/**
 * 抽象烹饪装饰器
 *
 * 网上很多版本这里都会继承CookService，但是这样会有很强的耦合性，故这里不继承
 *
 * @Author ityuan
 * @Date 2019-06-27 14:13
 */
public abstract class CookDecorator {

    private CookService cookService;

    public CookDecorator(CookService cookService) {
        this.cookService = cookService;
    }

    public void cook() {
        if (cookService != null) {
            cookService.cook();
        }
    }
}
