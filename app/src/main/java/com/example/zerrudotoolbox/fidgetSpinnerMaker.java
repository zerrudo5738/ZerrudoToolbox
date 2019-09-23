package com.example.zerrudotoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

// radiogroup source https://www.youtube.com/watch?v=i-q3Pc8BdOI
// spinne source https://www.youtube.com/watch?v=on_OrrX7Nw4

public class fidgetSpinnerMaker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RadioGroup radioGroupPhoto;
    private ImageView glitterPhoto, cheesePhoto, stickerPhoto, cooked, imageViewPhoto, jetPhoto;
    private Switch jetSwitch;
    private Integer []photos = {R.drawable.fidgetspinner, R.drawable.fidgetspinnergreen, R.drawable.fidgetspinnerblue};
    private Integer []cookphotos = {R.drawable.rare, R.drawable.mediumrare, R.drawable.medium, R.drawable.mediumwell, R.drawable.welldone};
    private CheckBox glitterBox, cheeseBox, stickerBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fidget_spinner_maker);
        this.imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        this.cooked = (ImageView) findViewById(R.id.cooked);
        this.radioGroupPhoto = (RadioGroup) findViewById(R.id.radioGroup);
        this.glitterPhoto = (ImageView) findViewById(R.id.glitterPic);
        this.cheesePhoto = (ImageView) findViewById(R.id.cheesePic);
        this.stickerPhoto = (ImageView) findViewById(R.id.stickerPic);
        this.jetPhoto = (ImageView) findViewById(R.id.jetPic);
        glitterBox = (CheckBox) findViewById(R.id.glitterBox);
        cheeseBox = (CheckBox) findViewById(R.id.cheeseBox);
        stickerBox = (CheckBox) findViewById(R.id.stickerBox);
        jetSwitch = (Switch) findViewById(R.id.jetSwitch);

        this.radioGroupPhoto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                imageViewPhoto.setImageResource(photos[index]);
            }
        });

        // switch
        jetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    jetPhoto.setImageResource(R.drawable.jet);
                } else {
                    jetPhoto.setImageResource(R.drawable.empty);
                }
            }
        });

        Context context = this;

        Spinner spinner = findViewById(R.id.cookSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.CookSpin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    // check boxes
    public void glitterCheck(View v){
        if(glitterBox.isChecked()){
            glitterPhoto.setImageResource(R.drawable.glitter);
        }
        else{
            glitterPhoto.setImageResource(R.drawable.empty);
        }
    }

    public void cheeseCheck(View v){
        if(cheeseBox.isChecked()){
            cheesePhoto.setImageResource(R.drawable.parmesan);
        }
        else{
            cheesePhoto.setImageResource(R.drawable.empty);
        }
    }

    public void stickerCheck(View v){
        if(stickerBox.isChecked()){
            stickerPhoto.setImageResource(R.drawable.stickers);
        }
        else{
            stickerPhoto.setImageResource(R.drawable.empty);
        }
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT);
        cooked.setImageResource(cookphotos[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}

