package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //create @Query
//    List<User> findPairsFor(Long userId);

    //change @Query, find by date and if exists status (only requested)
    Page<User> findAllByPartyDates(LocalDate partyDate, Pageable pageable);

    Boolean existsByEmail(String email);

}
