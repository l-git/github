package com.demo.thread;

/* CrashThread2.java
 * Copyright (c) 2013, HerongYang.com, All Rights Reserved.
 */
import java.util.*;
import java.text.*;
class CrashThread2 extends Thread {
   public static void main(String[] arg) {
      Thread t;
      int m = 32;
      if (arg.length>0) m = Integer.parseInt(arg[0]);
      Date now;
      DateFormat df = DateFormat.getTimeInstance();
      Runtime rt = Runtime.getRuntime();
      System.out.println("Time   Threads   T.Memory   F.Memory");
      for (int n=1; n<=m; n++) {
      	 now = new Date();
         t = new CrashThread2();
         t.start();
         long tm = rt.totalMemory()/1024;
         long fm = rt.freeMemory()/1024;
         System.out.println(df.format(now)+"   "+n+"   "+tm+"   "+fm);
      }
   }
   public void run() {
      while (true);
   }
}
