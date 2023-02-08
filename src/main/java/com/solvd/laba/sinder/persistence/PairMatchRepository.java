package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.pairmatch.PairMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairMatchRepository extends JpaRepository<PairMatch, Long> {

}
