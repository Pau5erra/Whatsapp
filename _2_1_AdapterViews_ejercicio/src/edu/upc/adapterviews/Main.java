package edu.upc.adapterviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity implements View.OnClickListener {

  private EditText server_label;
  private String server_string;

  private EditText port_label;
  private String port_string;

  private EditText nick_label;
  private String nick_string;

  @Override
  public void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ((Button) findViewById(R.id.button_chat)).setOnClickListener(this);
  }

  public void onClick(View arg0) {

    if (arg0 == findViewById(R.id.button_chat)) {
      Intent intent = new Intent(this, Activity_chat.class);

      server_label = (EditText) findViewById(R.id.server);
      server_string = server_label.getText().toString();

      port_label = (EditText) findViewById(R.id.port);
      port_string = port_label.getText().toString();

      nick_label = (EditText) findViewById(R.id.nick);
      nick_string = nick_label.getText().toString();

      if(server_string.isEmpty()){
        server_label.setText("LocalHost");
        server_string = server_label.getText().toString();
      }

      if(port_string.isEmpty()){
        port_label.setText("DefaultPort");
        port_string = port_label.getText().toString();
      }

      if(nick_string.isEmpty()){
        nick_label.setText("User");
        nick_string = nick_label.getText().toString();
      }

      intent.putExtra("Server", server_string);
      intent.putExtra("Port", port_string);
      intent.putExtra("Nick", nick_string);

      startActivity(intent);
    }
  }

}

