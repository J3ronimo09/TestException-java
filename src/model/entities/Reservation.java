package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkIN;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIN, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIN = checkIN;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIN() {
        return checkIN;
    }

    public Date getCheckOut() {
        return checkOut;
    }
    public  long duration(){
         long diff = checkOut.getTime() - checkIN.getTime();
         return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public String updateDates(Date checkIN, Date checkOut){

        Date now = new Date();
        if (checkIN.before(now) || checkOut.before(now)){
             return "Error in reservation: dates for update must be future dates";
        }
        if(checkOut.after(checkIN)) {
             return"Error in-reservation: check-out date  must be after check-in date";
        }
        this.checkIN = checkIN;
        this.checkOut = checkOut;
        return null;
    }


    @Override
    public String toString(){
        return "Room "
                + roomNumber
                +", check-in: "
                +sdf.format(checkIN)
                +", checl-out"
                +sdf.format(checkOut)
                +", "
                +duration()
                +" nights";
    }
}
