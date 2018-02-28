package playground.amazon;

public class DatesDifference {

    public static void main(String[] args) {
        Date d1 = new Date(2017, 8, 23);
        Date d2 = new Date(2018, 8, 23);

        System.out.println(getDateDifference(d1, d2));
    }

    static int getMothDays(int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

    static int getDateDifference(Date d1, Date d2) {
        if (d1.year > d2.year) return -1;

        int ddiff = 0;
        if (d1.year < d2.year) {
            if (d1.month < 12) {
                for (int m = d1.month + 1; m <= 12; m++) {
                    ddiff += getMothDays(m);
                }
            }

            for (int m = 1; m < d2.month; m++) {
                ddiff += getMothDays(m);
            }

            ddiff += getMothDays(d1.month) - d1.day;
            ddiff += d2.day;
        } else {
            if (d1.month > d2.month) return -1;
            else if (d1.month - d2.month == 1){
                ddiff += getMothDays(d1.month) - d1.day;
                ddiff += d2.day;
            } else if (d1.month < d2.month) {
                for (int m = d1.month + 1; m < d2.month; m++) {
                    ddiff += getMothDays(m);
                }
                ddiff += getMothDays(d1.month) - d1.day;
                ddiff += d2.day;
            } else
                ddiff += d2.day - d1.day;
        }

        return ddiff;
    }
}

class Date {
    int day;
    int month;
    int year;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
