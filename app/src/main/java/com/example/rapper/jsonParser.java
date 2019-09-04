package com.example.rapper;

//import statements
import android.os.*;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.Buffer;
import android.widget.*;

//a parser meant for reading the JSON file and transferring the data to artist objects
public class jsonParser extends AsyncTask<Void,Void,Void> {

    //variable declarations
    int id;
    String name;
    String description;
    String url;
    Rapper testArtist;
    Rapper returnedRapper;

    //Using doInBackground to fetch the URL and build each artist with the given data
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //fetching the JSON file with the given URL and then creating readers to gather data
            URL rapperSource = new URL("http://assets.aloompa.com.s3.amazonaws.com/rappers/rappers.json");
            HttpURLConnection aloompaSource = (HttpURLConnection) rapperSource.openConnection();
            InputStream rapperStream = aloompaSource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(rapperStream));

            //previous attempt at reading throgh the data
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(rapperStream));
//            while((line = bufferedReader1.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//
//            JSONObject rapList = new JSONObject();
//            Rapper rapper2 = new Rapper(rapList.getString("")


            //Test code to fetch the data from the JSON file
            JSONObject rapperSource_JSONObject = new JSONObject(bufferedReader.readLine());
            JSONArray rapperSource_JSONArray=rapperSource_JSONObject.getJSONArray("artists");
            JSONObject firstRapper = rapperSource_JSONArray.getJSONObject(0);

            //previous attempt at instantiating a rapper with info from th JSON object
            //JSONArray firstRapper = rapperSource_JSONObject.getJSONArray("artists");
            //Rapper testArtist = new Rapper(rapperSource_JSONArray.getJSONObject(0).getInt("id"), rapperSource_JSONArray.getJSONObject(0).getString("name"),rapperSource_JSONArray.getJSONObject(0).getString("description"), rapperSource_JSONArray.getJSONObject(0).getString("url"));

            //Filling variables and using them to make an artist
            id = firstRapper.getInt("id");
            name = firstRapper.getString("name");
            description = firstRapper.getString("description");
            url = firstRapper.getString("url");
            testArtist = new Rapper(id, name, description, url);
            storeRapper(testArtist);
            this.setName();

            //first attempt at filling objects
//            while(true) {
//                Rapper rapper1;
//                rapper1 = new Rapper(bufferedReader.read(),bufferedReader.readLine(),bufferedReader.readLine(),bufferedReader.readLine());
//            }

            //catches for different exceptions
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Rapper getRapper() {
        return returnedRapper;
    }

    //Attempt at using a method to fill a rapper with data
//    public Rapper fillRapper() {
//        try {
//            JSONObject rapperSource_JSONObject = new JSONObject();
//            JSONArray rapperSource_JSONArray = rapperSource_JSONObject.getJSONArray("artists");
//            Rapper testArtist = new Rapper(rapperSource_JSONObject.getInt("id"), rapperSource_JSONArray.getJSONObject(0).getString("name"), rapperSource_JSONArray.getJSONObject(0).getString("description"), rapperSource_JSONArray.getJSONObject(0).getString("url"));
//            storeRapper(testArtist);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return returnedRapper;
//    }

    public void storeRapper(Rapper temp) {
        returnedRapper = temp;
    }

    public void setName() {
        MainActivity.r1.setText(this.name);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
