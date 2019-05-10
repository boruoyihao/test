package com.xiaomi.adpter;

public class AudioPlayer implements MediaPlayer{

    private AdwancedMediaPlayer advance;
    @Override
    public void play(String type) {
        // TODO Auto-generated method stub
        if(type.equals("mp3")){
            System.out.println("MP3");
        }else if(type.equals("mp4")||type.equals("vl4")){
            if(type.equals("mp4")){
                advance=new Mp4Player();
                advance.palyMp4();
            }else{
                advance=new VL4Player();
                advance.playVLC();
            }
        }else{
            System.out.println("can't support this");
        }
    }

}
