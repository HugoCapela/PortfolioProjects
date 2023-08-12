package org.academiadecodigo.nanderthals;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {

    private Clip clip;

    // Create our music
    public Music() {


        try {
            /*File file = new File("/Users/codecadet/Documents/Slack-Jack/resources/music.wav");
            AudioInputStream ais;
            ais = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);*/

            URL audioURL = getClass().getResource("/music.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioURL);
            clip = AudioSystem.getClip();

            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Play our music in a loop
    public void play() {
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Stop the music in the Initial Screen
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}