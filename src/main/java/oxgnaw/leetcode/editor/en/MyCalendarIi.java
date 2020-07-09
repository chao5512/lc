//Implement a MyCalendarTwo class to store your events. A new event can be added
// if adding the event will not cause a triple booking. 
//
// Your class will have one method, book(int start, int end). Formally, this rep
//resents a booking on the half open interval [start, end), the range of real numb
//ers x such that start <= x < end. 
//
// A triple booking happens when three events have some non-empty intersection (
//ie., there is some time that is common to all 3 events.) 
//
// For each call to the method MyCalendar.book, return true if the event can be 
//added to the calendar successfully without causing a triple booking. Otherwise, 
//return false and do not add the event to the calendar. 
//Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCale
//ndar.book(start, end)
//
// Example 1: 
//
// 
//MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(50, 60); // returns true
//MyCalendar.book(10, 40); // returns true
//MyCalendar.book(5, 15); // returns false
//MyCalendar.book(5, 10); // returns true
//MyCalendar.book(25, 55); // returns true
//Explanation: 
//The first two events can be booked.  The third event can be double booked.
//The fourth event (5, 15) can't be booked, because it would result in a triple 
//booking.
//The fifth event (5, 10) can be booked, as it does not use time 10 which is alr
//eady double booked.
//The sixth event (25, 55) can be booked, as the time in [25, 40) will be double
// booked with the third event;
//the time [40, 50) will be single booked, and the time [50, 55) will be double 
//booked with the second event.
// 
//
// 
//
// Note: 
//
// 
// The number of calls to MyCalendar.book per test case will be at most 1000. 
// In calls to MyCalendar.book(start, end), start and end are integers in the ra
//nge [0, 10^9]. 
// 
//
// Related Topics Ordered Map 
// 👍 597 👎 81

package oxgnaw.leetcode.editor.en;

public class MyCalendarIi {
    public static void main(String[] args) {
        MyCalendarIi.MyCalendarTwo myCalendarTwo = new MyCalendarIi().new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarTwo {
        private final byte[] calendar;
        private final byte[] calendarSd;
        private final int length = 1000000000 >> 3;

        public MyCalendarTwo() {
            calendar = new byte[length];
            calendarSd = new byte[length];
        }

        public boolean book(int start, int end) {
            if (check(start, end)) {
                push(start, end);
                return true;
            }
            return false;
        }

        private void push(int start, int end) {
            for (int i = start; i < end; i++) {
                if (checkBit(i, calendar)) {
                    setBit(i, calendarSd);
                } else {
                    setBit(i, calendar);
                }
            }
        }

        private boolean check(int start, int end) {

            for (int i = start; i < end; i++) {
                if (checkBit(i, calendar) && checkBit(i, calendarSd)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Bit-value lookup array to prevent doing the same work over and over
         */
        public final byte[] bitvals = {
            (byte) 0x80,
            (byte) 0x40,
            (byte) 0x20,
            (byte) 0x10,
            (byte) 0x08,
            (byte) 0x04,
            (byte) 0x02,
            (byte) 0x01
        };

        /**
         * Check if bit at specified index is 1.
         *
         * @param pos index of bit
         *
         * @return true if bit at specified index is 1, false if 0.
         */
        boolean checkBit(int pos, byte[] bloomBuf) {
            int bytePos = pos >> 3; //pos / 8
            int bitPos = pos & 0x7; //pos % 8
            byte curByte = bloomBuf[bytePos];
            curByte &= bitvals[bitPos];
            return (curByte != 0);
        }

        void setBit(int pos, byte[] calendar) {
            int bytePos = pos >> 3; //pos / 8
            int bitPos = pos & 0x7; //pos % 8
            calendar[bytePos] |= bitvals[bitPos];
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}