package com.example.bookcase;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {
    TextView bookTitleView;
    View root;
    String bookTitleString;
    Layout details;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            bookTitleString = bundle.getString("bookTitle");
        }
        else
            bookTitleString = "Something Different";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_book_details, container, false);

        return root;
    }

    public void changeText (String title){

        bookTitleView = (TextView) getView().findViewById(R.id.bookTitleBox);
        bookTitleView.setText(title);

    }
}
