package com.example.aungsithumoe.connectionspeed;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import static com.food2u.dialogstyleaar.Utils.InFormationDialog;
import static com.food2u.dialogstyleaar.Utils.shortToast;
import static com.food2u.dialogstyleaar.Utils.longToast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
ListView listView;
    List<MultipleData> list;
    MultipleAdapter multipleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        String address = info.getMacAddress();
        listView=(ListView)findViewById(R.id.fragment_multiple_list_view);
        MultipleData windows7 = new MultipleData(address, false);
        MultipleData max = new MultipleData("Max OS X", false);
        MultipleData linux = new MultipleData("Linux", false);
        list=new ArrayList<>();
        list.add(windows7);
        list.add(max);
        list.add(linux);
        multipleAdapter=new MultipleAdapter(MainActivity.this,list);
        listView.setAdapter(multipleAdapter);
        listView.setOnItemClickListener(this);
//        ConnectivityManager connMgr=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo=connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        boolean isWifiConn=networkInfo.isConnected();
//        networkInfo=connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isMobileConn=networkInfo.isConnected();
//        Toast.makeText(getApplicationContext(),"Wifi connected: "+ isWifiConn,Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(),"Mobile connected: "+ isMobileConn,Toast.LENGTH_LONG).show();
    }
    public boolean isOnline()
    {
        ConnectivityManager connMgr=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connMgr.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        multipleAdapter.setSelectedIndex(position);
        multipleAdapter.notifyDataSetChanged();
        shortToast(MainActivity.this,"postion::"+position);
        longToast(MainActivity.this,"postion::"+position);
        InFormationDialog(MainActivity.this,"Warning!","ERROR",R.color.colorAccent);
    }

}
