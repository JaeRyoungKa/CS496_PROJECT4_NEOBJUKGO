package com.example.q.neobjukgo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by q on 2016-07-05.
 */
public class StreamHelper {

    public static String readIt(InputStream stream) throws IOException {
        String ret = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String text;
        while ((text = reader.readLine()) != null) {
            ret += text;
        }
        return ret;
    }

    public static int readInt(InputStream stream) throws IOException {
        String ret = "";
        BufferedInputStream bis = new BufferedInputStream(stream);
        return bis.read();
    }

}
