package com.estadodaarte.octopet;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public abstract class BaseController extends BaseClass {

    public void StartActivity(Activity activity, View view) {
        Intent intent = new Intent(activity, null);
        activity.startActivity(intent);
    }

}
