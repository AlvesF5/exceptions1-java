package application;

import domain.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();

        System.out.println("Check in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.println("CheckOut in date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Data inválida! Check-in maior que check-ou.");
        }else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update reservation:");

            System.out.println("Check in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.println("CheckOut in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Datas inválidas! As datas de check-in e check-out tem que ser maiores que a data atual");
            }else  if(!checkOut.after(checkIn)){
                System.out.println("Data inválida! Check-in maior que check-ou.");
            }else {
                reservation.updateDates(checkIn,checkOut);
                System.out.println(reservation);
            }


        }
    }

}
