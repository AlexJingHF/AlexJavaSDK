package com.alex.sdk.DesignPatterns.Principle.SingleResponsibilityPrinciple;

/**
 * 单一职责原则
 * 应该有且只有一个原因引起类的变化
 * 连接与数据传输时候，Phone的状态（当前协议）已经变化
 * 可将其拆分为独立的接口，以预防之后协议变化时（如连接协议从模拟改为数字，数据传送方式变化等），只需修改接口的实现
 *
 * Created by alex on 14-9-14.
 */
public class Phone implements IConnectManager ,IDataTransfer{

    public Phone() {
    }

    @Override
    public void dial(String phoneNumber) {

    }

    @Override
    public void hangUp() {

    }

    @Override
    public void DataTransfer(IConnectManager connectManager) {

    }
}
