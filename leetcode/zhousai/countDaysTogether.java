package zhousai;

//6184. 统计共同度过的日子数
public class countDaysTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int arr_month1 = Integer.parseInt(arriveAlice.substring(0, 2)), arr_day1 = Integer.parseInt(arriveAlice.substring(3, 5)),
                arr_month2 = Integer.parseInt(arriveBob.substring(0, 2)), arr_day2 = Integer.parseInt(arriveBob.substring(3, 5)),
                leave_month1 = Integer.parseInt(leaveAlice.substring(0, 2)), leave_day1 = Integer.parseInt(leaveAlice.substring(3, 5)),
                leave_month2 = Integer.parseInt(leaveBob.substring(0, 2)), leave_day2 = Integer.parseInt(leaveBob.substring(3, 5));
        for (int i = 1; i < days.length; i++) {
            days[i] += days[i - 1];
        }
        int date1 = days[arr_month1 - 1] + arr_day1, date2 = days[arr_month2 - 1] + arr_day2,
                date3 = days[leave_month1 - 1] + leave_day1, date4 = days[leave_month2 - 1] + leave_day2;
        return Math.max(0, Math.min(date3, date4) - Math.max(date1, date2) + 1);

    }

    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        System.out.println(new countDaysTogether().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}
