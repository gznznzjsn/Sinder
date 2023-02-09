package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //create this @Query
    //Page<User> findPairsFor(Long userId, Pageable pageable);

    //create @Query, find by date and if exists status (only requested)
    //Page<User> findAllByPartyDates(LocalDate partyDate, Pageable pageable);

    Boolean existsByEmail(String email);

}
