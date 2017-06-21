package com.zahid.anirban.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zahid.anirban.R;

public class Collection extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        fillTable();
    }

    private static final String[] firstNames = { "Tom", "Brad", "Jim", "Marlon", "Keanu", "John", "Bruce" };
    private static final String[] lastNames = { "Hanks", "Pit", "Carrey", "Brando", "Reeves", "Malkovic", "Willis" };

    public void fillTable() {
        int rowCount = firstNames.length;
        Log.d("Fill Table", "rowCount = " + rowCount);
        TableLayout table = (TableLayout) this.findViewById(R.id.tablelayout);
        for (int i = 0; i < rowCount; i++) {
            // Below you can choose wich way you want to create your table
            // Comment on the corresponding part of the code to choose:

            // Create the table from the source code without xml:

//			 TableRow row = new TableRow(this);
//			 row.setBackgroundColor(Color.BLACK); table.addView(row);
//			 fillRow(row, i);


            // Create table from xml layout file using layout inflater:
            fillRow2(table, i);
        }
    }

//    public void fillRow(TableRow row, int noRow) {
//        // number of rows
//        TextView nr = new TextView(this);
//        nr.setBackgroundColor(Color.WHITE);
//        nr.setTextColor(Color.BLUE);
//        nr.setText(String.valueOf(noRow + 1));
//        row.addView(nr);
//        LinearLayout.LayoutParams llp = (LinearLayout.LayoutParams) nr.getLayoutParams();
//        llp.setMargins(0, 0, 0, 1);
//        nr.setLayoutParams(llp);
//        nr.setPadding(10, 10, 40, 3);
//
//        // first name
//        TextView firstN = new TextView(this);
//        firstN.setBackgroundColor(Color.WHITE);
//        firstN.setTextColor(Color.BLUE);
//        firstN.setText(firstNames[noRow]);
//        row.addView(firstN);
//        llp = (LinearLayout.LayoutParams) firstN.getLayoutParams();
//        llp.setMargins(0, 0, 0, 1);
//        firstN.setLayoutParams(llp);
//        firstN.setPadding(10, 10, 20, 3);
//
//        // last name
//        TextView lastN = new TextView(this);
//        lastN.setBackgroundColor(Color.WHITE);
//        lastN.setTextColor(Color.BLUE);
//        lastN.setText(lastNames[noRow]);
//        row.addView(lastN);
//        llp = (LinearLayout.LayoutParams) lastN.getLayoutParams();
//        llp.setMargins(0, 0, 0, 1);
//        lastN.setLayoutParams(llp);
//        lastN.setPadding(10, 10, 20, 3);
//
//        EditText lN = new EditText(this);
//        lN.setBackgroundColor(Color.WHITE);
//        lN.setTextColor(Color.BLUE);
//        lN.setText(lastNames[noRow]);
//        row.addView(lN);
//        llp = (LinearLayout.LayoutParams) lN.getLayoutParams();
//        llp.setMargins(0, 0, 0, 1);
//        lN.setLayoutParams(llp);
//        lN.setPadding(10, 10, 20, 3);
//
//        ///
//
//        CheckBox checkBox = new CheckBox(this);
//        row.addView(checkBox);
//        checkBox.setBackgroundColor(Color.WHITE);
//        llp = (LinearLayout.LayoutParams) checkBox.getLayoutParams();
//        llp.setMargins(0, 0, 0, 1);
//        checkBox.setLayoutParams(llp);
//        checkBox.setPadding(10, 10, 20, 3);
//    }

    public void fillRow2(TableLayout table, int noRow) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fullRow = inflater.inflate(R.layout.rows, null, false);
        TextView nr = (TextView) fullRow.findViewById(R.id.nr);
        nr.setText(String.valueOf(noRow + 1));
        TextView fName = (TextView) fullRow.findViewById(R.id.fName);
        fName.setText(firstNames[noRow]);
        fName.setId(noRow + 1);
        TextView lName = (TextView) fullRow.findViewById(R.id.lName);
        lName.setText(lastNames[noRow]);
        //table.addView(fullRow);


        EditText editText=(EditText) fullRow.findViewById(R.id.lName1);
        editText.setText(lastNames[noRow]);

        CheckBox check= (CheckBox) fullRow.findViewById(R.id.b);
        //check.setText(lastNames[noRow]);
        table.addView(fullRow);
    }
}
