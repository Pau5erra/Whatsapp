package edu.upc.adapterviews;

import edu.upc.adapters.MyAdapter_whatsapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pau y Dani
 */

public class Activity_chat extends Activity{
    private ListView conversation;
    private MyAdapter_whatsapp adapter;
    private ArrayList<String> messages;
    private EditText input_text;
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = new Intent(this, Main.class);

        conversation = (ListView) findViewById(R.id.conversation);
        messages = new ArrayList<String>();
        adapter = new MyAdapter_whatsapp(this, messages);
        conversation.setAdapter(adapter);
        input_text = (EditText) findViewById(R.id.input);
        title = (TextView) findViewById(R.id.title);

        Bundle extras= getIntent().getExtras();
        String server = extras.getString("Server");
        String port = extras.getString("Port");
        String nick = extras.getString("Nick");

        title.setText(nick + "@" + server + ":" + port);

    }

    public void addText(final View view) {

        Bundle extras= getIntent().getExtras();
        String nick = extras.getString("Nick");

        if(input_text.getEditableText().toString().equals("")) return;

        //...
        messages.add(nick + " :" +input_text.getEditableText().toString());
        input_text.setText("");

        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });

        messages.add("Server Message");
        input_text.setText("");

        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });

        messages.add("Fecha");
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
