package com.github.unithon.unithon.util;

import static com.amazonaws.services.polly.model.VoiceId.Seoyeon;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyPresigningClient;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechPresignRequest;
import com.amazonaws.services.polly.model.Voice;
import com.amazonaws.services.polly.model.VoiceId;
import com.github.unithon.unithon.UnithonApplication;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PollyHelper {

    private static final String TAG = PollyHelper.class.getName();

    private static final PollyHelper ourInstance = new PollyHelper();

    private static final String COGNITO_POOL_ID = "ap-northeast-2:3e83174d-7119-41c5-8242-325eb8df383e";

    private final Regions MY_REGION = Regions.AP_NORTHEAST_2;

    private final CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
            UnithonApplication.getGlobalApplication().getApplicationContext(),
            COGNITO_POOL_ID,
            MY_REGION
    );

    private final AmazonPollyPresigningClient client = new AmazonPollyPresigningClient(credentialsProvider);

    private final MediaPlayer mediaPlayer = new MediaPlayer();

    public static PollyHelper getInstance() {
        return ourInstance;
    }

    private PollyHelper() {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(MediaPlayer::start);
        mediaPlayer.setOnCompletionListener(MediaPlayer::release);
    }

    public void playPolly(String message) {
        new PollyAsyncTask(message).execute();
    }

    private class PollyAsyncTask extends AsyncTask<Void, Void, Void> {

        private final String message;

        PollyAsyncTask(String message) {
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            final SynthesizeSpeechPresignRequest synthesizeSpeechPresignRequest = new SynthesizeSpeechPresignRequest()
                    .withText(message)
                    .withVoiceId(VoiceId.Seoyeon)
                    .withOutputFormat(OutputFormat.Mp3);

            final URL presignedSynthesizeSpeechUrl = client.getPresignedSynthesizeSpeechUrl(synthesizeSpeechPresignRequest);

            try {
                mediaPlayer.setDataSource(presignedSynthesizeSpeechUrl.toString());
                mediaPlayer.prepareAsync();
            } catch(IOException e) {
                Log.e(TAG, "Unable to set data source for the media player! " + e.getMessage());
            }

            return null;
        }
    }

}
