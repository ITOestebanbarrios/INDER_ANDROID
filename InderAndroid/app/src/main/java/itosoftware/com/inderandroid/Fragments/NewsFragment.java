package itosoftware.com.inderandroid.Fragments;

import itosoftware.com.inderandroid.Api.News.ApiNews;
import itosoftware.com.inderandroid.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.List;

public class NewsFragment extends ListFragment {

    // Array de String que contiene nuestros queridos Sistemas Operativos
    private String[] sistemas = { "Android", "Ubuntu", "Mac OSX", "Windows",
            "Solaris", "Windows 8", "Ubuntu 12.04", "Windows Phone",
            "Windows 7", "Kubuntu", "Ubuntu 12.10" };

    Integer page = new Integer(1);
    Integer limit = new Integer(10);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Object[] parameters = new Object[2];

        parameters[0] = page;
        parameters[1] = limit;

        ApiNews apiNews = new ApiNews(this);
        apiNews.getNews(parameters);


        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

         // Establecemos el Adapter a la Lista del Fragment
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, sistemas));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        Log.d("Aqui","onListItemClick");
        // Mostramos un mensaje con el elemento pulsado
        Toast.makeText(getActivity(), "Ha pulsado " + sistemas[position],
                Toast.LENGTH_SHORT).show();
    }



}