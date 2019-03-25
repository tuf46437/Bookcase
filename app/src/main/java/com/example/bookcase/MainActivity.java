package com.example.bookcase;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.bookSelectedInterface{

    int currentBook = -1;
    ArrayList<String> bookTitles = new ArrayList<String>();
    BookDetailsFragment detailsFragment = new BookDetailsFragment();
    BookListFragment listFragment = new BookListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button prev = findViewById(R.id.prevButton);
        Button next = findViewById(R.id.nextButton);

        bookTitles.add("Verses for the Dead");
        bookTitles.add("Where the Crawdads Sing");
        bookTitles.add("Target: Alex Cross");
        bookTitles.add("Bird Box");
        bookTitles.add("A Delicate Touch");
        bookTitles.add("The Reckoning");
        bookTitles.add("Fire and Blood");
        bookTitles.add("Every Breath");
        bookTitles.add("The Point of It All");
        bookTitles.add("Bad Blood");

        Bundle listBundle = new Bundle();
        listBundle.putStringArrayList("allBooks", bookTitles);
        listFragment.setArguments(listBundle);


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.detailsPanel, detailsFragment).commit();
        fm.beginTransaction().add(R.id.ListPanel, listFragment).commit();


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentBook != -1){
                    currentBook--;
                    bookSelection(currentBook);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentBook != bookTitles.size()-1){
                    currentBook++;
                    bookSelection(currentBook);
                }
            }
        });

    }

    public void bookSelection(int currentBook){
        this.currentBook = currentBook;

        if (currentBook != -1) {
            detailsFragment.changeText(bookTitles.get(currentBook));
        }
        else
            detailsFragment.changeText("Welcome to the BookCase");
    }
}
