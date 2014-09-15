package com.alex.sdk.DesignPatterns.Principle.InterfaceSegregationPrinciple;

/**
 * Created by Administrator on 2014/9/15.
 */
public class Searcher extends AbstractSearcher
{
    public Searcher(IGoodBodyGirl goodBodyGirl)
    {
        super(goodBodyGirl);
    }

    public Searcher(IGreateTemperamentGirl greateTemperamentGirl)
    {
        super(greateTemperamentGirl);
    }

    @Override
    public void show()
    {

    }
}
