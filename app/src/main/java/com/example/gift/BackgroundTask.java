package com.example.gift;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundTask extends AsyncTask<String, detail, String> {

    private Context ctx;
    private Activity activity;
    private ListviewAdapter listviewAdapter;
    private ListView list;
    private android.widget.SearchView searchView;

    BackgroundTask(Context context) {
        this.ctx = context;
        activity = (Activity) ctx;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        GiftDb giftDb = new GiftDb(ctx);
        if (method.equals("add_info")) {
            String f_name = params[1];
            String name = params[2];
            String city = params[3];
            String present = params[4];
            SQLiteDatabase database = giftDb.getWritableDatabase();
            giftDb.addContacts(f_name, name, city, present, database);
            giftDb.close();
            return "row_inserted";
        } else if (method.equals("update_info")) {
            String id = params[1];
            String f_name = params[2];
            String name = params[3];
            String city = params[4];
            String present = params[5];
            SQLiteDatabase database = giftDb.getWritableDatabase();
            giftDb.updateContacts(Integer.parseInt(id), f_name, name, city, present, database);
            giftDb.close();
            return "row_updated";
        } else if (method.equals("delete_info")) {
            String id = params[1];
            SQLiteDatabase database = giftDb.getWritableDatabase();
            giftDb.deleteContacts(Integer.parseInt(id), database);
            giftDb.close();
            return "row_deleted";
        } else if (method.equals("get_info")) {
            searchView=activity.findViewById(R.id.search);
            list = activity.findViewById(R.id.listView);
            SQLiteDatabase database = giftDb.getReadableDatabase();
            Cursor cursor = giftDb.readContacts(database);
            listviewAdapter = new ListviewAdapter(ctx, R.layout.detail_list);
            String name, fam, city, pre;
            int id;
            while ((cursor.moveToNext())) {
                id = cursor.getInt(cursor.getColumnIndex(DbContract.giftCon.ID));
                name = cursor.getString(cursor.getColumnIndex(DbContract.giftCon.NAME));
                fam = cursor.getString(cursor.getColumnIndex(DbContract.giftCon.FAM_NAME));
                city = cursor.getString(cursor.getColumnIndex(DbContract.giftCon.CITY));
                pre = cursor.getString(cursor.getColumnIndex(DbContract.giftCon.PRESENTS));
                detail det = new detail("Name  :" + name, "Family :" + fam, "City      :" + city, "Gift       :" + pre, id);
                publishProgress(det);
            }
            return "get_Info";

        }

        return null;
    }

    @Override
    protected void onPostExecute(String ret) {

        if (ret.equals("row_inserted")) {
            Toast.makeText(ctx, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        } else if (ret.equals("row_updated")) {
            Toast.makeText(ctx, "Updated Successfully", Toast.LENGTH_SHORT).show();
        } else if (ret.equals("row_deleted")) {
            Toast.makeText(ctx, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        } else if (ret.equals("get_Info")) {
            list.setAdapter(listviewAdapter);
        }
    }

    @Override
    protected void onProgressUpdate(detail... values) {
        listviewAdapter.add(values[0]);
    }

}
