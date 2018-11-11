package com.example.navarrocantero.youtubelist;

/**
 * Created by navarrocantero on 10/11/2018.
 */

import android.util.Log;

import com.example.navarrocantero.youtubelist.model.Video;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class VideoAdapter {
    private static final String TAG = "ParseVideos";

    private String xmlData;
    public ArrayList<Video> videos;

    public VideoAdapter(String xmlData) {
        this.xmlData = xmlData;
        videos = new ArrayList<>();
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public boolean process() {
        boolean status = true;
        Video currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagName = xpp.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        if (tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new Video();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            System.out.println(currentRecord.toString());
                            if (tagName.equalsIgnoreCase("entry")) {
                                videos.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("title")) {
                                currentRecord.setTitulo(textValue);
                            } else if (tagName.equalsIgnoreCase("videoId")) {
                                currentRecord.setId(textValue);
                            } else if (tagName.equalsIgnoreCase("name")) {
                                currentRecord.setUsuario(textValue);
                            } else if (tagName.equalsIgnoreCase("thumbnail")) {
                                String url = xpp.getAttributeValue(null, "url");
                                currentRecord.setImage(url);
                            } else if (tagName.equalsIgnoreCase("description")) {
                                currentRecord.setViews(textValue);
                            }
                        }
                        break;
                    default:
                }

                eventType = xpp.next();
            }
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public Video getVideos(int i) {
        return videos.get(i);
    }
}
