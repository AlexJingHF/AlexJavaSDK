package com.alex.sdk.phone;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 14/11/3.
 */
public class GetNumber
{
    public static List<PhoneInfo> list = new ArrayList<PhoneInfo>();
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static final String getNumber(Context context)
    {
        Cursor c = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber;
        String phoneName;
        while (c.moveToNext())
        {
            phoneNumber = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            System.out.println(phoneNumber);
            phoneName = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            System.out.println(phoneName);
            list.add(new PhoneInfo(phoneName,phoneNumber));
        }
        return null;
    }
}
