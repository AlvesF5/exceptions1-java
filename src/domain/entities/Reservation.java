package domain.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut){

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)){
            return "Datas inválidas! As datas de check-in e check-out tem que ser maiores que a data atual";
        }
        if(!checkOut.after(checkIn)){
            return "Data inválida! Check-in maior que check-ou.";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomNumber= " + roomNumber +
                ", checkIn= " + sdf.format(checkIn) +
                ", checkOut= " + sdf.format(checkOut) +
                ", duration= " + duration() + " nights" +
                '}';
    }
}
