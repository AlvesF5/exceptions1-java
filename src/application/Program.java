package application;

import domain.entities.Reservation;
import domain.exceptions.DateReservationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.println("Room number: ");
            int number = sc.nextInt();

            System.out.println("Check in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("CheckOut in date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update reservation:");

            System.out.println("Check in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.println("CheckOut in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn,checkOut);

            System.out.println(reservation);

        }catch (ParseException e){
            System.out.println("Formato de data inválido!");
        }catch (DateReservationException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Erro inesperado!");
        }


        sc.close();




    }

}
