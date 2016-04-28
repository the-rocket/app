package com.daniyar.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;

/**
 * Created by alashov on 28/04/16.
 */
public class PickerActivity extends BaseActivity {

    private final static int REQUEST_PHOTO = 100101;

    private Photo mPhoto = new Photo();

    @Bind(R.id.title) EditText titleView;
    @Bind(R.id.add) Button addView;
    @Bind(R.id.preview) ImageView previewView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void onBackPressed() {
        mPhoto.setTitle(titleView.getText().toString());

        Intent data = new Intent();
        data.putExtra(MainActivity.EXTRA_PHOTO, mPhoto);

        setResult(RESULT_OK, data);
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PHOTO && resultCode == RESULT_OK) {
            mPhoto.setUri(data.getData());
            Glide.with(this).load(mPhoto.getUri()).into(previewView);
        }
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, REQUEST_PHOTO);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_picker;
    }
}
