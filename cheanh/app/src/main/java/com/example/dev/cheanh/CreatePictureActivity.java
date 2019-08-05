package com.example.dev.cheanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dev.model.ItemRecycler;

public class CreatePictureActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ImageView imgviewpicture;
    SeekBar sbred, sbgreen, sbblue;
    TextView txttop, txtbottom;
    EditText edttop, edtbottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_picture);
        AddControls();
        int id = (int) getIntent().getSerializableExtra("picture");
        Glide.with(getApplicationContext()).
                load("file:///android_asset/" + "picture/" + "h" + id + ".jpeg")
                .into(imgviewpicture);
        AddEvents();
    }

    private void AddEvents() {
        sbred.setOnSeekBarChangeListener(this);
        sbgreen.setOnSeekBarChangeListener(this);
        sbblue.setOnSeekBarChangeListener(this);
    }

    private void AddControls() {
        imgviewpicture = findViewById(R.id.imgViewpicture);
        sbblue = findViewById(R.id.sbblue);
        sbred = findViewById(R.id.sbred);
        sbgreen = findViewById(R.id.sbgreen);
        txttop = findViewById(R.id.txttop);
        txtbottom = findViewById(R.id.txtbottom);
        edttop = findViewById(R.id.edttexttop);
        edtbottom = findViewById(R.id.edttextbottom);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
