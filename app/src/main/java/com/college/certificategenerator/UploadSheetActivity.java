package com.college.certificategenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class UploadSheetActivity extends AppCompatActivity {

    private MaterialButton selectFileButton, uploadFileButton;
    private TextView uploadProgress, uploadFileName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_sheet);

        uploadProgress = findViewById(R.id.uploadProgressText);
        uploadFileName = findViewById(R.id.uploadFileNameTV);

        selectFileButton = findViewById(R.id.uploadSelectFile);
        uploadFileButton = findViewById(R.id.uploadFileButton);

        selectFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFile();
            }
        });
    }

    private void selectFile() {
        AlertDialog fileType = new MaterialAlertDialogBuilder(this)
                .setTitle("Select your file extension")
                .setMessage("Which file type are you looking for?")
                .setPositiveButton("CSV Files", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("text/csv");
                        startActivityForResult(intent, 1);
                    }
                }).setNegativeButton("Excel Files", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("application/vnd.ms-excel");
                        startActivityForResult(intent, 2);
                    }
                }).create();

        fileType.show();
        fileType.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();

                }
        }
    }
}
