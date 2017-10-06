package com.example.ekasilabalexcdtb.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){

                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){

                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        // The AUDIOFOCUS_LOSS case means we`ve lost audio focus and stop playback and clean up resource.
                        releaseMediaPlayer();

                    }
                }


            };


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

      final   ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?", "tinnǝ oyaase`nǝ",R.raw.phrase_what_is_your_name));
        words.add(new word("My name is.... ", "oyaaset",R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling", "michǝksǝs",R.raw.phrase_how_are_you_feeling));
        words.add(new word("I`m feeling good ", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "ǝǝnǝs`aa",R.raw.phrase_are_you_coming));
        words.add(new word("yes, I`m coming", "hǝǝ`ǝǝnǝm",R.raw.phrase_yes_im_coming));
        words.add(new word("I`m coming.", "eenem",R.raw.phrase_im_coming));
        words.add(new word("Let`s go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new word("Come here", "ǝnni`nem",R.raw.phrase_come_here));


        // Create an {@link ArrayAdapter}, whose data sourse is a list of strings.the adapter knows how to create layouts for each item in the lis
        // Using the simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView};which the adapter will set thr display a single com.example.ekasilabalexcdtb.miwok.word
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the the {@link activity}
        // There should be a {@link ListView} with the ID called list, which is declared in activity_number.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);

                // Release the media player if it currently exists because we are about to play different sound file.
                releaseMediaPlayer();

                // Request audio focus playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // use music stream
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // we have audio focus now

                    // create and setup the {@link media player} for the audio resource associate with the current word
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());


                    // Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release thr
                    // media player once the sound has finished playing
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


    }
    @Override
    protected void onStop(){
        super.onStop();
        // When the activity is stopped, release the media player resource because we wont be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * clean up the media player by releasing its resource
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of of the current state of the media player, release its resource because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null .for out code we`ve decided that
            // setting the media player to null is an easy wat to tell that the media player is not configured to play an audio file at the moment
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AUDIOFOCUSCHANGELISTENER so we do not get anymore callbacks
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}




