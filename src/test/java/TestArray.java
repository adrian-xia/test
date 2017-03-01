import org.junit.Test;

/**
 * Created by xialei on 2017/2/28.
 */
public class TestArray {

    @Test
    public void testAdd() {
        Integer[] arr = new Integer[10000000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        System.out.println(arr);
    }
}
