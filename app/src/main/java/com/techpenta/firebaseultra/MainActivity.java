package com.techpenta.firebaseultra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.realtime.util.StringListReader;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> marraylist=new ArrayList<>();
    ArrayAdapter<String> adapter;

    ListView listView;


    TextView mtextfieldcondition;
    Button sunny;
    Button foggy;
    Firebase mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sample);
        mtextfieldcondition=(TextView)findViewById(R.id.textViewcontext);
        sunny=(Button)findViewById(R.id.buttonsunny);
        foggy=(Button)findViewById(R.id.button2foggy);
        listView=(ListView)findViewById(R.id.listView1);

    }


    @Override
    protected void onStart() {
        super.onStart();


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,marraylist);
        listView.setAdapter(adapter);





        mref=new Firebase("https://fir-ultra.firebaseio.com");
        Firebase msgref=mref.child("condition");
        msgref.addChildEventListener(new ChildEventListener() {
      @Override
      public void onChildAdded(DataSnapshot dataSnapshot, String s) {

          String msg=dataSnapshot.getValue(String.class);
          marraylist.add(msg);
          adapter.notifyDataSetChanged();

        // mtextfieldcondition.setText(msg);
      }

      @Override
      public void onChildChanged(DataSnapshot dataSnapshot, String s) {


          String msg=dataSnapshot.getValue(String.class);
      }

      @Override
      public void onChildRemoved(DataSnapshot dataSnapshot) {

      }

      @Override
      public void onChildMoved(DataSnapshot dataSnapshot, String s) {

      }

      @Override
      public void onCancelled(FirebaseError firebaseError) {

      }
  });


    }
}
