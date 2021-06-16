package com.example.options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String arr[] = {"Select","France","Germany","England","Portugal","Croatia","Italy","Belgium","Spain","Netherlands"};
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview1);
        registerForContextMenu(textView);

        final Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context;
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.item4) {
                            String url = "https://www.google.com/";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        if (id == R.id.item5) {
                            String url = "https://www.amazon.in/";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        if (id == R.id.item6) {
                            String url = "https://www.youtube.com/";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        //**************************Spinner************************************

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter arrayAdapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,arr);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity.this,"You have selected : " + arr[i], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //*******************************LISTVIEW********************************************

         autoCompleteTextView = findViewById(R.id.autoComplete);
         ListView listView = findViewById(R.id.listview);
         String arr1[]= {};
         arrayList = new ArrayList<>(Arrays.asList(arr1));
         adapter = new ArrayAdapter<String>(this,R.layout.activity_main,arrayList);
         listView.setAdapter(adapter);
         Button btn = findViewById(R.id.button2);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String newitem = autoCompleteTextView.getText().toString();
                 arrayList.add(newitem);
                 adapter.notifyDataSetChanged();
             }
         });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(MainActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item3) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.quit, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item7) {
            finish();
            System.exit(0);
        }

        return super.onContextItemSelected(item);
    }

    public void additem(){


    }
}
