package com.agilefamily.rest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class RestClient extends AsyncTask<String, Void, String> {
    private static final String TAG = "RestClient";

    protected String doInBackground(String... params) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://192.168.0.103:9000/tasks");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("PUT");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            String body = "{\"name\":\"" + params[0] + " Date: " + new Date() + "\"}";
            OutputStream output = new BufferedOutputStream(conn.getOutputStream());
            output.write(body.getBytes());
            output.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                Log.d(TAG, line);
            }
            output.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Exception" + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
}