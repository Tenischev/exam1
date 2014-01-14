package com.example.exam1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: kris13
 * Date: 14.01.14
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class ItemDisplayer extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_displayer);

        ClientItem selectedItem = MyActivity.selectedItem;
        MyActivity.myArrayAdapter.notifyDataSetChanged();
        TextView mark = (TextView) findViewById(R.id.markview);
        TextView color = (TextView) findViewById(R.id.colorview);
        TextView sign = (TextView) findViewById(R.id.signview);
        TextView telephone = (TextView) findViewById(R.id.telephoneview);
        TextView time = (TextView) findViewById(R.id.timeview);
        TextView box = (TextView) findViewById(R.id.boxview);

        mark.setText(selectedItem.mark);
        color.setText(selectedItem.color);
        sign.setText(selectedItem.sign);
        telephone.setText(selectedItem.telephone);
        time.setText(selectedItem.time);
        box.setText(selectedItem.box);
    }
}

