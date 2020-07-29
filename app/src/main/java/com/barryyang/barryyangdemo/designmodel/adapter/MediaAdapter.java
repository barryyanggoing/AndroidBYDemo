package com.barryyang.barryyangdemo.designmodel.adapter;

public class MediaAdapter implements MediaPlayer {

    private AbstractMediaPlayer abstractMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            abstractMediaPlayer = new Mp4MediaPlayer();
        } else if (audioType.equalsIgnoreCase("vlc")) {
            abstractMediaPlayer = new VlcMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String audioPath) {
        if (audioType.equalsIgnoreCase("mp4")) {
            abstractMediaPlayer.playMp4(audioPath);
        } else if (audioPath.equalsIgnoreCase("vlc")) {
            abstractMediaPlayer.playVlc(audioPath);
        }
    }
}
