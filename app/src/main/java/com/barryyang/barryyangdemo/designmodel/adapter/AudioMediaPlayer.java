package com.barryyang.barryyangdemo.designmodel.adapter;

public class AudioMediaPlayer implements MediaPlayer {

    @Override
    public void play(String audioType, String audioPath) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("mp3文件播放");
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, audioPath);
        } else {
            System.out.println("不能播放该类型的音频");
        }
    }
}
