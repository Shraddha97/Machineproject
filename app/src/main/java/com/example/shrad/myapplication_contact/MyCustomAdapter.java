package com.example.shrad.myapplication_contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shrad on 7/21/2020.
 */

class MyCustomAdapter extends ArrayAdapter {
    private List contactsInfoList;

    private Context context;

    public MyCustomAdapter(MainActivity mainActivity, Object p1, List<ContactsInfo> contactsInfoList) {
        super(mainActivity, (Integer) p1,contactsInfoList);

        this.contactsInfoList = contactsInfoList;
        this.context = mainActivity;
    }

    private class ViewHolder {
        TextView displayName;
        TextView phoneNumber;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;


        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.contact_info, null);

            holder = new ViewHolder();
            holder.displayName = (TextView) convertView.findViewById(R.id.displayName);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ContactsInfo contactsInfo = (ContactsInfo) contactsInfoList.get(position);
        holder.displayName.setText(contactsInfo.getDisplayName());
        holder.phoneNumber.setText(contactsInfo.getPhoneNumber());

        return convertView;
    }
    }

