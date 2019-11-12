package org.adrian.test.concurrent.artconcurrent.chapter08;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    /**创建4个屏障，处理完之后执行当前类的run方法*/
    private CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * 假设只有4个sheet，所有只启动4个线程
     * FixedThreadPool：固定线程数的线程池
     */
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    /**保存每个sheet计算出的银行流水结果*/
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    //银行流水计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
        //此处线程池未关闭，则应用一直执行
        bankWaterService.executor.shutdown();
    }
}
