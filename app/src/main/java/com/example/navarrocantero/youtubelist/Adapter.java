package com.example.navarrocantero.youtubelist;

/**
 * Created by navarrocantero on 10/11/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navarrocantero.youtubelist.model.Video;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;




public class Adapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Video> videosList;

    public Adapter(Activity activity, ArrayList<Video> newsList) {
        this.activity = activity;
        this.videosList = newsList;
    }

    @Override
    public int getCount() {
        return videosList.size();
    }

    @Override
    public Object getItem(int position) {
        return videosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.videos_item, null);
        }

        Video video = videosList.get(position);

        TextView title = view.findViewById(R.id.textViewTitle);
        title.setText(video.getTitulo());


        TextView content = view.findViewById(R.id.textViewContent);
        content.setText(video.getVisitas());

        TextView author = view.findViewById(R.id.textViewAuthor);
        author.setText(video.getUsuario());

        ImageView imageView = view.findViewById(R.id.imageVideoPic);

        Picasso.with(view.getContext()).load(video.getImage()).into(imageView);

        return view;
    }
}
