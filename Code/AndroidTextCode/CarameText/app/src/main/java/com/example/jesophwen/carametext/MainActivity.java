package com.example.jesophwen.carametext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Uri imageUri;
    ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** 承载相册的imgView */
        picture = (ImageView)findViewById(R.id.carame_image_view);
        /** 打开相机按钮 */
        Button takePhoto = (Button)findViewById(R.id.carame_button);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 创建File对象 用来大打开摄像头 */
                File outputImage = new File(Environment.getExternalStorageDirectory(), "trmp.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();;
                }
                /** 获取打开摄像头的Uri */
                imageUri = Uri.fromFile(outputImage);
                /** 创建intent */
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                /** 添加Intent的属性 */
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                /** 开始界面跳转,打开摄像头 */
                startActivityForResult(intent, 1);
            }
        });

        Button openAblum = (Button)findViewById(R.id.open_album_button);
        openAblum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建File对象,用于存储选择的照片
                File outputImage = new File(Environment.
                        getExternalStorageDirectory(), "image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageUri = Uri.fromFile(outputImage);
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                intent.putExtra("crop", true);
                intent.putExtra("scale", true);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, 2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    /** 对拍照过后的图像进行裁剪 */
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 2);
                }
                break;

            }
            case 2: {
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

            default: break;

        }
    }


}
