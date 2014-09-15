package com.alex.sdk.DesignPatterns.Principle.InterfaceSegregationPrinciple;

/**
 * Created by Administrator on 2014/9/15.
 */
public abstract class AbstractSearcher
{
    protected IGoodBodyGirl goodBodyGirl;
    protected IGreateTemperamentGirl greateTemperamentGirl;

    protected AbstractSearcher(IGoodBodyGirl goodBodyGirl)
    {
        this.goodBodyGirl = goodBodyGirl;
    }

    protected AbstractSearcher(IGreateTemperamentGirl greateTemperamentGirl)
    {
        this.greateTemperamentGirl = greateTemperamentGirl;
    }

    public abstract void show();
}
