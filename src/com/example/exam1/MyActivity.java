package com.example.exam1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyActivity extends Activity {
    public static ClientItem selectedItem = null;
    public static int numberBox = 0;
    public static ArrayList<ClientItem> clientItems = new ArrayList<ClientItem>();
    public static MyArrayAdapter myArrayAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /*ContentValues cv = new ContentValues();
        cv.put(DbWash.LOGIN,loginEditText.getText().toString());
        cv.put(DbWash.PASSW,passEditText.getText().toString());
        db.insert(DbWash.TABLE_NAME,null,cv);
        */
        TextView namewash = (TextView) findViewById(R.id.namewashview);
        ListView listClient = (ListView) findViewById(R.id.listclient);
        myArrayAdapter = new MyArrayAdapter(this, clientItems);
        listClient.setAdapter(myArrayAdapter);
        Button addClient = (Button) findViewById(R.id.addclient);

        DbWash dbWash = new DbWash(MyActivity.this);
        SQLiteDatabase db = dbWash.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DbWash.TABLE_NAME,null);
        if (cursor.getCount() == 0){
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),FirstRun.class);
            startActivity(intent);
        } else {
            cursor.moveToFirst();
            namewash.setText(cursor.getString(cursor.getColumnIndex(DbWash.NAMEWASH)));
            numberBox =  cursor.getInt(cursor.getColumnIndex(DbWash.NUMBERBOX));
        }
        cursor.close();
        db.close();

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),AddClient.class);
                startActivity(intent);
            }
        });

        DbClient dbClient = new DbClient(MyActivity.this);
        SQLiteDatabase dbClient1 = dbClient.getReadableDatabase();
        Cursor cursorClient = dbClient1.rawQuery("SELECT * FROM " + DbClient.TABLE_NAME + " ORDER BY " + DbClient.TIME + " DESC",null);
        cursorClient.moveToFirst();
        myArrayAdapter.notifyDataSetChanged();
        clientItems.clear();
        clientItems.add(new ClientItem("Car","","","","Time","Box"));
        for (int i=0;i<cursorClient.getCount();i++){
            clientItems.add(new ClientItem(cursorClient.getString(cursorClient.getColumnIndex(DbClient.MARK)),
                    cursorClient.getString(cursorClient.getColumnIndex(DbClient.COLOR)),
                    cursorClient.getString(cursorClient.getColumnIndex(DbClient.SIGN)),
                    cursorClient.getString(cursorClient.getColumnIndex(DbClient.TELEPHONE)),
                    cursorClient.getString(cursorClient.getColumnIndex(DbClient.TIME)),
                    cursorClient.getString(cursorClient.getColumnIndex(DbClient.BOX))));
            cursorClient.moveToNext();
        }
        cursorClient.close();
        dbClient1.close();

        listClient.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View view, int index,long arg3) {
                if (index > 0){
                    selectedItem = clientItems.get(index);
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),ItemDisplayer.class);
                    startActivity(intent);
                }

            }
        });
    }
}
