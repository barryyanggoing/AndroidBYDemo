package com.barryyang.designmode.adapter;

public class VlcMediaPlayer implements AbstractMediaPlayer{

    @Override
    public void playVlc(String audioPath) {
        System.out.println("播放Vlc文件");
    }

    @Override
    public void playMp4(String audioPath) {

    }
}
