package com.csf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducer {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(100);
        new Thread(() -> {
            try {
                new Consumer(blockingQueue).consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new Producer(blockingQueue).produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}

class Consumer {

    private ArrayBlockingQueue<Integer> blockingQueue;

    Consumer(ArrayBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void consume() throws InterruptedException {
        while (true) {
            System.out.println("consumer consume:" + blockingQueue.take() + ":" + blockingQueue.size());
            Thread.sleep(5000);
        }
    }
}

class Producer {
    private ArrayBlockingQueue<Integer> blockingQueue;

    Producer(ArrayBlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        int i = 0;
        while (true) {
            blockingQueue.put(i);
            System.out.println("producer produce:" + i + ":" + blockingQueue.size());
            i++;
        }
    }
}
