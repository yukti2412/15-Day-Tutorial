package com.example.androidtaskday10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class video extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView=findViewById(R.id.videoview);

        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.movie);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(video.this, "Thank You!!!", Toast.LENGTH_SHORT).show();
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(video.this, "Error", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}