package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartagrovet.ml.SugarcaneModel2;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

public class SugarcaneActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView txtViewPrediction;
    private Bitmap imgBitmap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugarcane);

        String[] label = {"Healthy", "Red Rot", "Red Rust"};

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets()
                    .open("labels.txt")));
            String line = bufferedReader.readLine();
            while(line != null){
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Permissions
        getPermission();

        imageView = findViewById(R.id.imgSugarcane);
        Button select = findViewById(R.id.btnSelect);
        Button btnCapture = findViewById(R.id.btnCapture);
        Button predict = findViewById(R.id.btnPredict);
        txtViewPrediction = findViewById(R.id.txtViewPrediction);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);
            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 12);
            }
        });

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBitmap = Bitmap.createScaledBitmap(imgBitmap, 256, 256, true);

                try {
                    SugarcaneModel2 model = SugarcaneModel2.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer
                            .createFixedSize(new int[]{1, 256, 256, 3}, DataType.FLOAT32);

                    TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                    tensorImage.load(imgBitmap);
                    ByteBuffer byteBuffer = tensorImage.getBuffer();
                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    SugarcaneModel2.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    float [] confidence = outputFeature0.getFloatArray();

                    // Releases model resources if no longer used.
                    model.close();

                    if (confidence[getMax(confidence)] < 70){
                        Toast.makeText(getApplicationContext(),
                                "Incorrect or unclear image!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        txtViewPrediction.setText(String.format("%s", label[getMax(confidence)]));
                    }
                } catch (IOException e) {
                    // TODO Handle the exception
                }
            }
        });
    }

    int getMax(float[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    void getPermission(){
        if (checkSelfPermission(android.Manifest.permission.CAMERA) != getPackageManager().PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(SugarcaneActivity.this, new String[]{android.Manifest.permission.CAMERA}, 11);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 11){
            if (grantResults.length > 0){
                if (grantResults[0] != getPackageManager().PERMISSION_GRANTED){
                    this.getPermission();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 11){
            imageView.setImageURI(data.getData());
            Uri uri = data.getData();
            try {
                imgBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (requestCode == 12){
            imgBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imgBitmap);
        }
    }
}