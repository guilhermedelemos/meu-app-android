package com.estadodaarte.meuapp.view;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.estadodaarte.meuapp.R;
import com.estadodaarte.octopet.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        Device device = new Device(this);

        ListView lista = (ListView) findViewById(R.id.list_view_dados);
        List dados = new ArrayList();
        dados.add(getResources().getString(R.string.manufacturer) + ": " + device.getDeviceBrand());
        dados.add(getResources().getString(R.string.model) + ": " + device.getDeviceModel());
        dados.add(getResources().getString(R.string.country) + ": " + device.getNetworkCountryIso());
        dados.add(getResources().getString(R.string.sim_operator) + ": " + device.getSimOperatorName());
        dados.add(getResources().getString(R.string.sim_serial) + ": " + device.getSimSerialNumber());
        dados.add(getResources().getString(R.string.operating_system) + ": " + device.getOsName());
        dados.add(getResources().getString(R.string.version) + ": " + device.getDeviceAndroidRelease());
        dados.add(getResources().getString(R.string.device_imei) + ": " + device.getImei());
        dados.add(getResources().getString(R.string.serial) + ": " + device.getDeviceSerial());
        dados.add(getResources().getString(R.string.device_fingerprint) + ": " + device.getDeviceFingerprint());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);
    }
}
