package com.example.myapplication.utils;

import android.util.Log;
import android.util.Xml;

import com.example.myapplication.model.FaceBin;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class XmlUtil {
    public static FaceBin pull2xml(InputStream is) {
        FaceBin faceBin = new FaceBin();
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(is, "utf-8");
            int type = parser.getEventType();
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    //开始标签
                    case XmlPullParser.START_TAG:
                        if ("to".equals(parser.getName())) {
                            faceBin.setTo(parser.nextText());
                        } else if ("from".equals(parser.getName())) {
                            faceBin.setFrom(parser.nextText());
                        } else {
                            Log.d("XmlUtil", parser.getName());
                        }

                        //结束标签
                    case XmlPullParser.END_TAG:
                        break;
                }

                //继续往下读取标签类型
                type = parser.next();
            }
        } catch (IOException e) {

        } catch (XmlPullParserException e) {

        }
        return faceBin;
    }
}
