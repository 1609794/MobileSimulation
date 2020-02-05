package com.example.simulationresults;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Graphview2 extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
   ListView mListView;
int[] images = {
        R.drawable.adjumani4rescaled,
        R.drawable.error,
        R.drawable.errorcomparison,
        R.drawable.jewi_4,
        R.drawable.jewi_4_rescaled,
        R.drawable.kakuma_4,
        R.drawable.kakuma_4_rescaled,
        R.drawable.khartoum_4,
        R.drawable.khartoum_4_rescaled,
        R.drawable.kiryandongo_4,
        R.drawable.kiryandongo_4_rescaled,
        R.drawable.kule_4,
        R.drawable.kule_4_rescaled,
        R.drawable.pugnido_4,
        R.drawable.pugnido_4_rescaled,
        R.drawable.rhino_4,
        R.drawable.rhino_4_rescaled,
        R.drawable.tierkidi_4,
        R.drawable.tierkidi_4_rescaled,
        R.drawable.west_kordofan_4,
        R.drawable.west_kordofan_4_rescaled,
        R.drawable.numagents
};
String[] names = {
        "Adjumani",
        "Error",
        "Error Comparison",
        "Jewi-4",
        "Jewi-4-Rescaled",
        "Kakuma-4",
        "Kakuma-4-Rescaled",
        "Khartoum-4",
        "Khartoum-4-Rescaled",
        "Kiryandongo-4",
        "Kiryandongo-4-Rescaled",
        "Kule-4",
        "Kule-4-Rescaled",
        "Pugnido-4",
        "Pugnido-4-Rescaled",
        "Rhino-4",
        "Rhino-4-Rescaled",
        "Tierkidi-4",
        "Tierkidi-4-Rescaled",
        "West Kordofan-4",
        "West Kordofan-4-Rescaled",
        "NumAgents"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i(TAG, "Graph view Started");
        mListView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        mListView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
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

            mImageView.setImageResource(images[position]);
            mTextView.setText(names[position]);

            return view1;
        }
    }

}
