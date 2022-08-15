import java.util.*;
import java.io.*;

class Main {

  public static int CountingMinutesI(String str) {
    int hour1, minute1, hour2, minute2;
    String amPm1, amPm2;
    String[] times, timeParts;

    //System.out.println("str:"+str);

    times = str.split("-");

    //System.out.println("times:"+str.split("-"));

    timeParts = times[0].split(":");
    hour1 = Integer.parseInt(timeParts[0]);
    minute1 = Integer.parseInt(timeParts[1].substring(0,2));
    amPm1 = timeParts[1].substring(2,4);

    timeParts = times[1].split(":");
    hour2 = Integer.parseInt(timeParts[0]);
    minute2 = Integer.parseInt(timeParts[1].substring(0,2));
    amPm2 = timeParts[1].substring(2,4);

    if(amPm1.equals("pm") && hour1 != 12) { hour1 += 12; }
    if(amPm2.equals("pm") && hour2 != 12) { hour2 += 12; }

    if(amPm1.equals("am") && hour1 == 12) { hour1 -= 12; }
    if(amPm2.equals("am") && hour2 == 12) { hour2 -= 12; }


    int diff = 0;

    if(hour1 <= hour2) {
      if(minute1 <= minute2) {
        diff = (hour2 - hour1) * 60 + (minute2 - minute1);  //9:00am-10:00am 
        System.out.println("("+hour2+" - "+hour1+") * 60 + ("+minute2+" - "+minute1+");" );
      }
      else
        diff = (hour2 - 1 - hour1) * 60 + (minute2 + 60 - minute1); //9:50am-10:10am 
    } else {
      if(minute1 <= minute2)
        diff = (hour2 + 24 - hour1) * 60 + (minute2 - minute1); //  1:00pm-11:00am ->  13:00-11:00 = 22 hours
      else
        diff = (hour2 - 1 + 24 - hour1) * 60 + (minute2 + 60 - minute1);  // 13:40-11:10 = 21:30 hours
    }

    return diff;
  }

  public static void main (String[] args) {
    System.out.println(CountingMinutesI("9:00am-10:00am"));
    System.out.println(CountingMinutesI("12:00am-12:00pm"));
  }

}
