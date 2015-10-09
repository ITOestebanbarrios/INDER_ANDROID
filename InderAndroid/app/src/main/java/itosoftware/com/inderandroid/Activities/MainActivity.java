package itosoftware.com.inderandroid.Activities;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import itosoftware.com.inderandroid.Fragments.AttentionUserFragment;
import itosoftware.com.inderandroid.Fragments.NewsFragment;
import itosoftware.com.inderandroid.Fragments.RecommendedFragment;
import itosoftware.com.inderandroid.Fragments.ReservationFragment;
import itosoftware.com.inderandroid.Fragments.VenuesFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);  //se saca porque sino se solapan

        ActionBar actionBar = getSupportActionBar();

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Inder");

        /**MODO TABS EN ACTIONBAR**/
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /**CREAR TABS**/
        ActionBar.Tab tab = actionBar.newTab()
                .setText("Escenarios")
                .setTabListener(new TabsListener(
                        this, "escenarios", VenuesFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Noticias")
                .setTabListener(new TabsListener(
                        this, "noticias", NewsFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Recomendados")
                .setTabListener(new TabsListener(
                        this, "recomendados", RecommendedFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Reservas")
                .setTabListener(new TabsListener(
                        this, "reservas", ReservationFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Atención Al Usuario")
                .setTabListener(new TabsListener(
                        this, "atencion al usuario", AttentionUserFragment.class));
        actionBar.addTab(tab);


    }

    public class TabsListener  implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(android.R.id.content, fragment, tag);
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    }
}