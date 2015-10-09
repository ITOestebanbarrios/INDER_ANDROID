package itosoftware.com.inderandroid.Api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Custom implementation of Volley Request Queue
 */
public class ApiConnection {

    private static ApiConnection apiConnection = null;
    //this object is the queue that uses the application
    private RequestQueue mRequestQueue;

    private ApiConnection(Context context) {
        //Create a new request queue
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static ApiConnection getInstance(Context context) {
        if (apiConnection == null) {
            apiConnection = new ApiConnection(context);
        }
        return apiConnection;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

}