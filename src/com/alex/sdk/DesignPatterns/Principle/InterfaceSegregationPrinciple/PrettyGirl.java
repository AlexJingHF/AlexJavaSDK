package com.alex.sdk.DesignPatterns.Principle.InterfaceSegregationPrinciple;

/**
 * Created by Administrator on 2014/9/15.
 */
public class PrettyGirl implements IGoodBodyGirl,IGreateTemperamentGirl
{
    private String name = "";

    public PrettyGirl(String name)
    {
        this.name = name;
    }

    @Override
    public void goodLooking()
    {
        System.out.println("goodLooking");
    }

    @Override
    public void niceFigure()
    {
        System.out.println("niceFigure");
    }

    @Override
    public void greatTemperament()
    {
        System.out.println("greatTemperament");
    }
}
