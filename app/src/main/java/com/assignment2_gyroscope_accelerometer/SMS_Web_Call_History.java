package com.assignment2_gyroscope_accelerometer;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.ubicomp.main.R;

public class SMS_Web_Call_History extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sms__web__call__history);
            getSMSDetails();

        }

    private void getSMSDetails() {
        Uri uri = Uri.parse("content://sms");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        int totalInbox = 0;
        int totalSent = 0;
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String type = cursor.getString(cursor.getColumnIndexOrThrow("type")).toString();
                switch (Integer.parseInt(type)) {
                    case 1:
                        totalInbox++;
                        break;

                    case 2:
                        totalSent++;
                        break;
                }
                cursor.moveToNext();
            }
        }
        cursor.close();
        TextView inboxTextView = (TextView) findViewById(R.id.inboxTextView);
        inboxTextView.setText(String.valueOf(totalInbox));
        TextView sentTextView = (TextView) findViewById(R.id.sentTextView);
        sentTextView.setText(String.valueOf(totalSent));
    }
}
