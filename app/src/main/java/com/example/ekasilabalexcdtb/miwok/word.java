package com.example.ekasilabalexcdtb.miwok;

/**
 * {@link word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a miwok translation for the word.
 */

public class word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;
    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;

    /**
     * Create a new word object
     *
     * @param defaultTranslation
     *
     * @param miwoktranslation
     *
     * @param audioResourceId
     */
    public word(String defaultTranslation, String miwoktranslation, int audioResourceId ) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwoktranslation;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Create a new word object
     *
     * @param defaultTranslation
     *
     * @param miwoktranslation
     *
     * @param imageResourceId  is the drawable resource ID for the image associate.
     */
    public word(String defaultTranslation, String miwoktranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwoktranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation nof the word.
     */
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public  boolean hasImage(){
        return  mImageResourceId != NO_IMAGE_PROVIDED;}

    /**
     * Return the audio ID of the word.
     * @return
     */
    public int getmAudioResourceId(){ return mAudioResourceId;}



}
