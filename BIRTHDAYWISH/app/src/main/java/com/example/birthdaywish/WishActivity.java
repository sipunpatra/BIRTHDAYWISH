package com.example.birthdaywish;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WishActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    EditText editTextName;
    Button btnClickHere;
    TextView textName;

    private static final int PICK_IMAGE=100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                opengallery();

            }
        });


    }
    private void opengallery() {
       Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
       startActivityForResult(intent,PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK  && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            imageView.setImageURI(imageUri);
        }


        editTextName = (EditText) findViewById(R.id.editTextName);
        
        btnClickHere = (Button) findViewById(R.id.btnClickHere);
        textName = (TextView) findViewById(R.id.textName);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                textName.setText("Many Many Happy Returns of The Day Happy Birth Day To You Dear   ," +name);

            }
        });

    }
}

