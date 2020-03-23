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

public class BurundiGraphs extends AppCompatActivity {
    static String TAG = "Graphs Burundi Activity - Page";
    ListView mListView;
    int[] images1 = {
            R.drawable.lusenda,
            R.drawable.lusenda_rel,
            R.drawable.mahama,
            R.drawable.mahama_rel,
            R.drawable.nakivale,
            R.drawable.nakivale_1_rel,
            R.drawable.nakivale_rel,
            R.drawable.nduta,
            R.drawable.nduta_rel,
            R.drawable.nyarugusu,
            R.drawable.nyarugusu_rel,
            R.drawable.errorburundi,
            R.drawable.numagentsburundi
    };

    String[] names1 = {
            "Lusenda",
            "Lusenda-rel",
            "Mahama",
            "Mahama-rel",
            "Nakivale",
            "Nakivale-1-rel",
            "NAkivale-rel",
            "Nduta",
            "Nduta-rel",
            "Nyarugusu",
            "Nyarugusu-rel",
            "Error",
            "Number of Agents Burundi"
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
        Intent myIntent = new Intent(getApplicationContext(), NavBurundi.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
    @Override
    public void onBackPressed(){

    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images1.length;
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

            mImageView.setImageResource(images1[position]);
            mTextView.setText(names1[position]);

            return view1;
        }
    }
}
