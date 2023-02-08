package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findPairsFor(Long userId);
    Page<User> findAllByPartyDates(List<LocalDate> partyDates, Pageable pageable);

    Boolean existsByEmail(String email);

}
