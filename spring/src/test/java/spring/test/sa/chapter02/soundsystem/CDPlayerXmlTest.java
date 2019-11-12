package spring.test.sa.chapter02.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xialei on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:sa/chapter02/soundsystem/spring.xml")
public class CDPlayerXmlTest {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void compactDiscPlay() {
        compactDisc.play();
    }

}
