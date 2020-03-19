package com.example.simulationresults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter{
    private final View mWindow;
    private Context mcontext;

    public CustomInfoAdapter(Context context){
        mcontext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_window, null);
    }

    private void rendoringTextWindow(Marker marker, View view){
        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if(!title.equals("")){
            tvTitle.setText(title);
        }
    }
    @Override
    public View getInfoWindow(Marker marker) {
        rendoringTextWindow(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendoringTextWindow(marker, mWindow);
        return mWindow;
    }
}
