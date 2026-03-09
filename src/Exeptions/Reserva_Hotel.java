package Exeptions;

import Exeptions.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reserva_Hotel {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-in date: ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in Reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation: ");
            System.out.println("Check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date: ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDate(checkIn, checkOut);
            if(error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {

            System.out.println("Reservation: " + reservation);
            }


        }
        sc.close();
    }
}
