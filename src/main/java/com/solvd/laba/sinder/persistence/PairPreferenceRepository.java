package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.PairPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairPreferenceRepository extends JpaRepository<PairPreference, Long> {

}
