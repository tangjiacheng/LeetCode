package com.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class MaxQueue {
    LinkedList<Integer> doubleQueue = new LinkedList<>();
    LinkedList<Integer> queue = new LinkedList<>();


    public MaxQueue() {

    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        return doubleQueue.peekFirst();
    }

    public void push_back(int value) {
        while ((!doubleQueue.isEmpty()) && doubleQueue.peekLast() < value) {
            doubleQueue.pollLast();
        }
        doubleQueue.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        if (queue.peekFirst().equals(doubleQueue.peekFirst()))
            doubleQueue.pollFirst();
        return queue.pollFirst();
    }
}
