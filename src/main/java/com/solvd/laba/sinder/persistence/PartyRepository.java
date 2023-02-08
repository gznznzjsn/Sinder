package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    Page<Party> findAllByCreatorId(Long creatorId, Pageable pageable);

    //change @Query, find by date, published and if exists status (only invited)
    Page<Party> findAllByDateIn(List<LocalDate> dates, Pageable pageable);

}
