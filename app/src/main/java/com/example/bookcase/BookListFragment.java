package com.example.bookcase;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends Fragment {
    bookSelectedInterface parentBL;
    ArrayList<String> allBooks;
    View v;
    ListView myListView;

    public BookListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parentBL = (bookSelectedInterface) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            this.allBooks = bundle.getStringArrayList("allBooks");
        }
        else{
            this.allBooks.add("Error in bundle");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        v= inflater.inflate(R.layout.fragment_book_list, container, false);
        myListView = v.findViewById(R.id.libraryBooks);
        ArrayAdapter myListViewAdapter = new ArrayAdapter((Context) parentBL, android.R.layout.simple_list_item_1, this.allBooks);
        myListView.setAdapter(myListViewAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentBL.bookSelection(position);

            }
        });


        return v;
    }

    interface bookSelectedInterface{
        void bookSelection(int currentBook);
    }

}
