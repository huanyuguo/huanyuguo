package com.byzoro.thread;/** * @author huanyuguo * @date 2018/5/20 15:55 */public class LiftOff implements Runnable {    protected int countDown = 10;    private static int taskCount = 0;    private final int id = taskCount++;    public LiftOff(){}    public LiftOff(int countDown){        this.countDown=countDown;    }    public String status() {        return "#"+id+"("+                (countDown>0?countDown:"LiftOff!")+").  ";    }    @Override    public void run() {        while (countDown-->0){            System.out.print(status());            //TODO: yield()方法将给线程调度机制一个暗示：            //TODO: 你的工作做的差不多了，可以让别的线程使用CPU了            Thread.yield();        }    }}