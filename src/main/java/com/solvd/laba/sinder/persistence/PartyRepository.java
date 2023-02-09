package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {


    //create @Query, find by date (with dates from preferences), published and if exists status (only invited)
    //Page<Party> findPartiesFor(Long userId, Pageable pageable);

}
