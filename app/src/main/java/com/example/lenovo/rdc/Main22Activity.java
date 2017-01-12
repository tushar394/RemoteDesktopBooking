package com.example.lenovo.rdc;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main22Activity extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static String [] prgmImages={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
   // private static final String url= "http://www.rdc.2fh.co/text.php";
   // public static final String KEY_USERNAME = "username";
    //public static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        context=this;

        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cars);
        //ListView listView = (ListView) findViewById(R.id.list);
        //listView.setAdapter(adapter);

      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(Main22Activity.this);

                alert.setTitle("Enter Name");
                //alert.setMessage("Message");

                // Set an EditText view to get user input
                final EditText input = new EditText(Main22Activity.this);
                alert.setView(input);


                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        if (input.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "EmPTY", Toast.LENGTH_SHORT).show();
                            return;
                        } else
                        {
                            final String name = input.getText().toString();
                            Toast.makeText(getApplicationContext(), name , Toast.LENGTH_SHORT).show();
                            register(name,position);
                    }}
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();

            }
        });*/



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
         //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          //              .setAction("Action", null).show();
          //  }
       // });
    }
/*public  void register(final String name,int position)
{
    final String pos = String.valueOf(position);
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

        }
    }, new Response.ErrorListener(){

        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }
        ){
        @Override
        protected Map<String,String>getParams(){
            Map<String,String> params = new HashMap<String, String>();
            params.put(KEY_USERNAME,name);
            params.put(KEY_PASSWORD,pos);
            return params;
        }
    };
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
}*/
}
