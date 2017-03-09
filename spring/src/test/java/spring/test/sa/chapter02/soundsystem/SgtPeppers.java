package spring.test.sa.chapter02.soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by xialei on 2017/3/9.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Peppers's Lonely Hearts Club Band";
    private String artist = "The beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
