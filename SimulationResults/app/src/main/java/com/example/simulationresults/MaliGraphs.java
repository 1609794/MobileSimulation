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

public class MaliGraphs extends AppCompatActivity {
    static String TAG = "Graphs Mali Activity - Page";
    ListView mListView;
    int[] images2 = {
            R.drawable.abala,
            R.drawable.abala_rel,
            R.drawable.bobo_dioulasso,
            R.drawable.bobo_dioulasso_rel,
            R.drawable.mangaize,
            R.drawable.mangaize_rel,
            R.drawable.mbera,
            R.drawable.mbera_rel,
            R.drawable.mentao,
            R.drawable.mentao_rel,
            R.drawable.niamey,
            R.drawable.niamey_rel,
            R.drawable.tabareybarey,
            R.drawable.tabareybarey_rel,
            R.drawable.errormali,
            R.drawable.numagentsmali
    };

    String[] names2 = {
            "Abala",
            "Abala-rel",
            "Bobo-Dioulasso",
            "Bobo-Dioulasso-rel",
            "Mangaize",
            "Mangaize-rel",
            "Mbera",
            "Mbera-rel",
            "Mentao",
            "Mentao-rel",
            "Niamey",
            "Niamey-rel",
            "Tabareybarey",
            "Tabareybarey-rel",
            "Error Mali",
            "Number of agents Mali"
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
        Intent myIntent = new Intent(getApplicationContext(), NavMali.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
    @Override
    public void onBackPressed(){

    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images2.length;
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

            mImageView.setImageResource(images2[position]);
            mTextView.setText(names2[position]);

            return view1;
        }
    }
}
