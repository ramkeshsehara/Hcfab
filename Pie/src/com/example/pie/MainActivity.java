package com.example.pie;

import android.app.Activity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        final EditText  data1  = (EditText) findViewById(R.id.editText1);
        final EditText  data2  = (EditText)findViewById(R.id.editText2);
        final EditText  data3  = (EditText)findViewById(R.id.editText3);
        final EditText  data4  = (EditText)findViewById(R.id.editText4);
        final EditText  data5  = (EditText)findViewById(R.id.editText5);
        Button btnValidate = (Button)findViewById(R.id.button1);
        btnValidate.setOnClickListener(new OnClickListener()
           {
                public void onClick(View arg0)
                {
                     String d1  = data1.getText().toString();
                     String d2  = data2.getText().toString();
                     String d3  = data3.getText().toString();
                     String d4  = data4.getText().toString();
                     String d5  = data5.getText().toString();
                     
                    
                         Intent intent = new Intent(getBaseContext(),Second.class);
                         intent.putExtra("d1",data1.getText().toString());
                         intent.putExtra("d2",data2.getText().toString());
                         intent.putExtra("d3",data3.getText().toString());
                         intent.putExtra("d4",data4.getText().toString());
                         intent.putExtra("d5",data5.getText().toString());
                         startActivity(intent);
                     
    }
           }
    );}
}

   
    
