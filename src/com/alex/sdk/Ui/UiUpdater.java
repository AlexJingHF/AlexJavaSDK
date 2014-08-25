package com.alex.sdk.Ui;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * 当多个页面需要同时刷新UI时候调用，集中注册并刷新
 * Created by alex on 14-8-16.
 */
public class UiUpdater {

    public static final int UI_UPDATE = 0;
    private static List<Handler> clients = new ArrayList<Handler>();
    public static void registClient(Handler client) {
        if (!clients.contains(client)){
            clients.add(client);
        }
    }

    public static void unregistClient(Handler client){
        while (clients.contains(client)){
            clients.remove(client);
        }
    }

    public static void updateClient(){
        for (Handler client:clients){
            client.sendEmptyMessage(UI_UPDATE);
        }
    }
}
