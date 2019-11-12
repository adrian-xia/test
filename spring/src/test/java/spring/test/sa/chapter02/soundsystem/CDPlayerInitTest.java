package spring.test.sa.chapter02.soundsystem;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xialei on 2017/3/9.
 */
public class CDPlayerInitTest {

    @Test
    public void compactDiscPlay() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:sa/chapter02/soundsystem/spring.xml");
        CompactDisc compactDisc = applicationContext.getBean(CompactDisc.class);
        compactDisc.play();
        applicationContext.close();
    }
}
