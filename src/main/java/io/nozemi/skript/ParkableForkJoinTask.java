package io.nozemi.skript;

import jdk.jfr.FlightRecorder;


public class ParkableForkJoinTask {
    public static final FlightRecorder RECORDER = null;
    public static final boolean CAPTURE_UNPARK_STACK = false;
    public static final Object EMERGENCY_UNBLOCKER = new Object();
    public static final Object PARK = new Object();
    public static final int RUNNABLE = 0;
    public static final int LEASED = 1;
    public static final int PARKED = -1;
    public static final int PARKING = -2;
}
