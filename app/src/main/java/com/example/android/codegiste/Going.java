package com.example.android.codegiste;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by user on 16/07/2018.
 */

public class Going extends Fragment {

    //Define a view
    View view ;

    //Set the values that will appear in the list view
    String[] nameHelper ={"Name1","Name2","Name3","Name4","Name5"};
    String[] user ={"User1","User2","User3","User4","User5"};
    String[] location ={"Location1","Location2","Location3","Location4","Location5"};

    //Define the required textViews that will show in the list view
    private TextView nameHelperTextView ;
    private TextView userTextView ;
    private TextView locationTextView ;

    //Define the listView
    private ListView listView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Setup the view to use the activity_complete.xml file
        view = inflater.inflate(R.layout.activity_going , container , false);

        //Select the list view from activity_complete.xml file
        listView = (ListView) view.findViewById(R.id.going_list_view);

        //Make a new object from the class CustomAdapter
        CustomAdapter adapter = new CustomAdapter();

        //Add the custom adapter to the list view
        listView.setAdapter(adapter);

        return view;
    }

    /**
     * That class is the custom adapter for the listView
     */
    class CustomAdapter extends BaseAdapter {

        /**
         * To get the number of items
         * @return
         */
        @Override
        public int getCount() {
            return nameHelper.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * Here what will show in that custom adapter
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Select the required xml file (activity_complete_list_item.xml)
            convertView = getActivity().getLayoutInflater().inflate(R.layout.activity_going_list_item , null);

            //Select the required textViews from activity_complete_list_item.xml file
            nameHelperTextView = (TextView) convertView.findViewById(R.id.name_helper);
            userTextView = (TextView) convertView.findViewById(R.id.user);
            locationTextView = (TextView) convertView.findViewById(R.id.location);

            //Connect the textViews with the string arrays
            nameHelperTextView.setText(nameHelper[position]);
            userTextView.setText(user[position]);
            locationTextView.setText(location[position]);

            return convertView;
        }
    }



}
