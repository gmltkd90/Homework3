package com.cpsc411.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.util.Log;
import android.widget.ListView;

import com.cpsc411.homework_2.adapter.SummaryListAdapter;
import com.cpsc411.homework_2.model.Student;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> mStudents = new ArrayList<Student>();
    SummaryListAdapter mSummaryAdapter;
    boolean completed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_screen);

        RemoteAsyncTask remoteAsyncTask = new RemoteAsyncTask(this);
        remoteAsyncTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Custom Menu inflation
        //getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        //menu.findItem(R.id.action_add).setVisible(true);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.summary_screen_menu, menu);
        return true;
    }

    public void refreshScreen() {
        ListView lv = findViewById(R.id.summary_id);
        mSummaryAdapter = new SummaryListAdapter(mStudents);
        lv.setAdapter(mSummaryAdapter);
    }

    public void testWebService_add() {
        String request = "http://cs101i.fullerton.edu:400/students";
        try {
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            //
            Student sObj = new Student();
            sObj.setFirstName("George");
            sObj.setLastName("Sampson");
            sObj.setCwid("6478889900");
            JSONObject jsonObject = sObj.toJsonObject();
            //
            conn.connect();
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            writer.write(jsonObject.toString());
            Log.d("Remote Application", "Input JSON Object " + jsonObject.toString());
            writer.flush();
            writer.close();
            //
            InputStream in = conn.getInputStream();

        } catch (Exception e) {
            Log.d("Remote Application", e.getMessage());
        }
    }

    public void testWebService() {
        String request = "http://cs101i.fullerton.edu:400/students";
        try {
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Send the request to server
            InputStream in = conn.getInputStream();

            // Process the response
            String connType = conn.getHeaderField("Content-Type");
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.d("Remote Application", "Something wrong with you request.");
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer,0, bytesRead);
            }

            String respString = new String(out.toByteArray());
            Log.d("Remote Application", respString);

            JSONObject respObj = new JSONObject(respString);
            JSONArray objList = respObj.getJSONArray("Result Set");
            // Convert the response string into a list of Student objects
            mStudents = new ArrayList<Student>();
            for (int i=0; i<objList.length(); i++) {
                JSONObject obj = objList.getJSONObject(i);
                Student sObj = new Student();
                sObj.fromJsonObj(obj);
                mStudents.add(sObj);
            }

            // Display the student summary info

        } catch (Exception e) {
            Log.d("Remote Application", e.getMessage());

        }
    }
}
