package oopl5.models;

import oopl5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int reservId, Date newReservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {

                Collection<Reservation> reservations = table.getReservations();
                for (Reservation reservation : reservations) {
                    if (reservation.getId()==reservId)
                    {
                        reservations.remove(reservation);
                    }
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                }
                return null;//reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }




}
