package itosoftware.com.inderandroid.Api.News;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import itosoftware.com.inderandroid.Activities.MainActivity;
import itosoftware.com.inderandroid.Api.ApiConnection;
import itosoftware.com.inderandroid.Fragments.NewsFragment;
import itosoftware.com.inderandroid.R;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;


public class ApiNews {

    NewsFragment newsFragment;

    private ApiConnection apiConnection;
    protected RequestQueue fRequestQueue;

    Context context;


    public ApiNews(NewsFragment newsFragment){
        this.newsFragment = newsFragment;
        this.context = newsFragment.getActivity().getApplicationContext();
    }

    public void getNews (Object[] parameters){

        Integer page = (Integer)parameters[0];
        Integer limit = (Integer)parameters[1];

        String url = this.newsFragment.getString(R.string.url);
        String news_list = this.newsFragment.getString(R.string.news_list);

        url = url.concat(news_list);
        url = url.concat(new String("?pagina="));
        url = url.concat(page.toString());
        url = url.concat(new String("&elementos_por_pagina="));
        url = url.concat(limit.toString());

        //Create a request queue
        apiConnection = apiConnection.getInstance(context);

        //Get the request queue
        fRequestQueue = apiConnection.getRequestQueue();


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                
                Log.i("Response => ",response.toString());

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Response => ",error.toString());

            }
        });

        //Add request to queue
        fRequestQueue.add(jsObjRequest);

        Log.d("Url Final", "Pasa por aqui");
        Log.d("Url Final", "Pasa por aqui otra vez");

    }




}






