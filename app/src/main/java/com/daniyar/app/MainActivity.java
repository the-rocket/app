package com.daniyar.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    public final static String EXTRA_PHOTO = "EXTRA_PHOTO";
    private final static int REQUEST_CODE = 1010;

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) View actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start picker
                Intent intent = new Intent(MainActivity.this, PickerActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && requestCode == RESULT_OK) {

        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
