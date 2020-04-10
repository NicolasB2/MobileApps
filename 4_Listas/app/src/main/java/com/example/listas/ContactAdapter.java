package com.example.listas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;

    public ContactAdapter() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact){
            contacts.add(contact);
            notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View  row = inflater.inflate(R.layout.contact_row,null,false);
        TextView nameRowField = row.findViewById(R.id.nameRowField);
        TextView phoneRowField = row.findViewById(R.id.phoneRowField);
        TextView callButton = row.findViewById(R.id.callButton);

        nameRowField.setText(contacts.get(position).getName());
        phoneRowField.setText(contacts.get(position).getPhone());

        return row;
    }
}
