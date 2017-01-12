package com.example.lenovo.rdc;

/**
 * Created by lenovo on 11-04-2016.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Main22Activity m2=new Main22Activity();
    Context context;
    String [] imageId;
    private static final String url= "http://rdcs.byethost7.com/natu.php";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    private static LayoutInflater inflater=null;
    public CustomAdapter(Main22Activity mainActivity, String[] prgmNameList, String[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(TextView) rowView.findViewById(R.id.textView2);
        holder.tv.setText(result[position]);
        holder.img.setText(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();


                final AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setTitle("Enter Name");
                //alert.setMessage("Message");

                // Set an EditText view to get user input
                final EditText input = new EditText(context);
                alert.setView(input);


                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int whichButton) {

                        if (input.getText().toString().isEmpty()) {
                            Toast.makeText(context, "EmPTY", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            final String name = input.getText().toString();
                            Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                            register(name,result[position]);
                        }
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();


            }
        });
        return rowView;
    }

    public  void register(final String name, final String position)
    {
        //final String pos = String.valueOf(position);
        final String pos="position";
        final  String name1="tushar";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context,response,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,name1);
                params.put(KEY_PASSWORD,pos);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }




}

