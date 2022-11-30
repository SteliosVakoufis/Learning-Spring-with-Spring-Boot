package com.stelvak.lil.learningspring.data;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    Iterable<Reservation> findByDate(Date date);
}
