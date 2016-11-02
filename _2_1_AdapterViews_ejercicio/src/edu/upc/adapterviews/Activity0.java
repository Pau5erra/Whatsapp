package edu.upc.adapterviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity0 extends Activity implements View.OnClickListener {

  @Override
  public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ((Button) findViewById(R.id.mainButton5)).setOnClickListener(this);
  }

  public void onClick(View arg0) {


    if (arg0 == findViewById(R.id.mainButton5)) {
      Intent intent = new Intent(this, Activity5.class);
      startActivity(intent);
    }

  }

}
