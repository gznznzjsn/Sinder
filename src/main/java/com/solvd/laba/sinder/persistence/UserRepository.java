package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = """
            with u as( 
            select * 
            from users
            inner join pair_preferences pp on pp.pair_preference_id = users.user_pair_preference_id
            inner join pair_preferences_genders ppg on pp.pair_preference_id = ppg.pair_preferences_genders_pair_preference_id
            ), p as(
            select * 
            from users
            inner join pair_preferences pp on pp.pair_preference_id = users.user_pair_preference_id
            inner join pair_preferences_genders ppg on pp.pair_preference_id = ppg.pair_preferences_genders_pair_preference_id
            )
            select p.* 
            from u 
            inner join p on u.genders = p.user_gender
            and u.user_gender = p.genders
            and u.user_id<>p.user_id
            and u.pair_preference_goal = p.pair_preference_goal
            and u.user_age between p.pair_preference_min_age and p.pair_preference_max_age
            and p.user_age between u.pair_preference_min_age and u.pair_preference_max_age
            and sqrt((p.user_latitude-u.user_latitude)*(p.user_latitude-u.user_latitude)+(p.user_longitude-u.user_longitude)*(p.user_longitude-u.user_longitude))<=least(u.radius,p.radius)
            left join pair_matches pm on pm.pair_match_sender_id = p.user_id and pm.pair_match_receiver_id = u.user_id
            where u.user_id = ?1
            and p.enabled = true
            and pm.pair_match_status is null or pair_match_status = 'REQUESTED';
            """, nativeQuery = true)
    Page<User> findPairsFor(Long userId, Pageable pageable);

    @Query(value = """
            select users.*
            from users
            inner join party_preferences on party_preferences.party_preference_id = users.user_party_preference_id
            inner join party_preferences_party_dates on party_preferences.party_preference_id =
                                                               party_preferences_party_dates.party_preferences_party_dates_party_preference_id
            inner join parties on party_preferences_party_dates.party_dates = parties.party_date
            left join party_matches pm on parties.party_id = pm.party_match_party_id and users.user_id = pm.party_match_guest_id
            where parties.party_id = ?1
            and (party_match_status is null or party_match_status='REQUESTED');
            """, nativeQuery = true)
    Page<User> findGuestsFor(Long partyId, Pageable pageable);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
