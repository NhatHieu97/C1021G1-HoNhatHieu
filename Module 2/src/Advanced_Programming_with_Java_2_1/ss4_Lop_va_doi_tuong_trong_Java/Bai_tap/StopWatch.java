package Advanced_Programming_with_Java_2_1.ss4_Lop_va_doi_tuong_trong_Java.Bai_tap;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;

public class StopWatch {
    private long startTime;
    private long endTime;


//    public long getStartTime(){
//        return startTime;
//    }
//
//    public void setStartTime(long startTime){
//        this.startTime = startTime;
//    }
//
//    public long getEndTime(){
//        return endTime;
//    }
    void start() {
        startTime = System.currentTimeMillis();
    }
    void end() {

        endTime = System.currentTimeMillis();
    }

    long getElapsedTime() {

        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] array =new int[1000000];

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.startTime);
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*1000000);
        }
        stopWatch.end();
        System.out.println(stopWatch.endTime);
        System.out.println(stopWatch.getElapsedTime());
    }



}
