package edu.upc.adapterviews;

import edu.upc.adapters.MyAdapter_whatsapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Pau
 */

public class Activity_chat extends Activity {
    private ListView conversation;
    private MyAdapter_whatsapp adapter;
    private ArrayList<String> messages;
    private EditText input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        conversation = (ListView) findViewById(R.id.conversation);
        messages = new ArrayList<String>();
        adapter = new MyAdapter_whatsapp(this, messages);
        conversation.setAdapter(adapter);
        input_text = (EditText) findViewById(R.id.input);

        for(int i=0; i<100; i++)
            messages.add("content of message nº"+i);

    }

    public void addText(final View view) {

        if(input_text.getEditableText().toString().equals("")) return;

        //...
        messages.add(input_text.getEditableText().toString());
        input_text.setText("");

        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });

        adapter.notifyDataSetChanged();
    }
}
