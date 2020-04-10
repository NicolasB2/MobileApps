package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView contactsTable;
    private ContactAdapter adapter;
    private Button addButton;
    private EditText nameRowfield;
    private EditText phoneRowfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsTable = findViewById(R.id.contactsTable);
        adapter = new ContactAdapter();
        contactsTable.setAdapter(adapter);

        adapter.addContact(new Contact("Nicolas","6546546616"));
        adapter.addContact(new Contact("Sara","231356546"));
        adapter.addContact(new Contact("David","64646846846"));

        addButton = findViewById(R.id.addButton);
        nameRowfield = findViewById(R.id.nameRowField);
        phoneRowfield = findViewById(R.id.phoneRowField);

        addButton.setOnClickListener(

                (v)->{
                    Contact c = new Contact(nameRowfield.getText().toString(),phoneRowfield.getText().toString());
                    adapter.addContact(c);
                }

        );
    }
}
