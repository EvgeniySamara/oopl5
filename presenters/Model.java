package oopl5.presenters;

import oopl5.models.Reservation;
import oopl5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    //int changeReservationTable( int reservId, Date newReservationDate , int tableNo, String name);

}
