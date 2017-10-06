package com.example.ekasilabalexcdtb.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eKasiLab Alex CDTB on 2017/06/27.
 */


public class WordAdapter extends ArrayAdapter<word> {

    /**Resource ID FOR the color for this list of words*/
    private int mcolorResourceId;

    public WordAdapter(Activity context, ArrayList<word> words,int colorResourceId){
        super(context, 0, words);
        mcolorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing  view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                  R.layout.list_item, parent, false);
        }

        // Get the {@link word} object located at this position in the list
        word currentWord = getItem(position);

        // Find the TextView in the list_item.xlm layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwork_text_view);
        // Get miwok translation from the currentword object and set this text on the miwok TextView.
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xlm layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get miwok translation from the currentword object and set this text on the miwok TextView.
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        // Find the imageView in the list_item.xnl layout with ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the ImageView to the image resource specified in the current word

        if (currentWord.hasImage()){
            // Set the ImageView to the image resource specified in the current word
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        // set the theme color for the list item color
        View textContainer = listItemView.findViewById(R.id.text_container);
        // find the color that the resource ID maps to.
        int color = ContextCompat.getColor(getContext(), mcolorResourceId);
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return listItemView;

    }
}
