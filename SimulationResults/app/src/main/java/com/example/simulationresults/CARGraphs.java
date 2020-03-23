package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CARGraphs extends AppCompatActivity {
    static String TAG = "Graphs CAR Activity - Page";
    ListView mListView;
    int[] images3 = {
            R.drawable.adamaoua,
            R.drawable.adamaoua_rel,
            R.drawable.belom,
            R.drawable.belom_rel,
            R.drawable.betou,
            R.drawable.betou_rel,
            R.drawable.brazaville,
            R.drawable.brazaville_rel,
            R.drawable.dosseye,
            R.drawable.dosseye_rel,
            R.drawable.east,
            R.drawable.east_rel,
            R.drawable.inke,
            R.drawable.inke_rel,
            R.drawable.mole,
            R.drawable.mole_rel,
            R.drawable.errorcar,
            R.drawable.numagentscar
    };

    String[] names3 = {
            "Adamaoua",
            "Adamaoua_rel",
            "Belom",
            "Belom-rel",
            "Betou",
            "Betou-rel",
            "Brazaville",
            "Brazaville-rel",
            "Dosseye",
            "Dosseye-rel",
            "East",
            "East-rel",
            "Inke",
            "Inke-rel",
            "Mole",
            "Mole-rel",
            "Error CAR",
            "Number of agents CAR"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.i(TAG, "Graph view Started");
        mListView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), NavCAR.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
    @Override
    public void onBackPressed(){

    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images3.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_item, null);
            ImageView mImageView = view1.findViewById(R.id.imageView);
            TextView mTextView = view1.findViewById(R.id.textView);

            mImageView.setImageResource(images3[position]);
            mTextView.setText(names3[position]);

            return view1;
        }
    }
}
