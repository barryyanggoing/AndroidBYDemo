package com.barryyang.barryyangdemo.designmodel.adapter;

public class Mp4MediaPlayer implements AbstractMediaPlayer {

    @Override
    public void playVlc(String audioPath) {

    }

    @Override
    public void playMp4(String audioPath) {
        System.out.println("播放mp4文件");
    }
}
