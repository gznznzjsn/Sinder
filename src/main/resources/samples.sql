insert into pair_preferences (pair_preference_id, pair_preference_goal, pair_preference_max_age, pair_preference_min_age, radius)
values (1,'NEW_FRIENDS',24,18,5);
insert into party_preferences (party_preference_id)
values (1);
insert into party_preferences_party_dates (party_preferences_party_dates_party_preference_id, party_dates)
VALUES (1,'2023-01-23');
insert into users (user_id, user_age, user_description, user_email, enabled, facebook_link, user_gender, user_latitude, user_longitude, instagram_link, user_name, user_password, phone_number, user_surname, user_pair_preference_id, user_party_preference_id)
values (1, 19,'blah blah','usr@mail.com',true,'fb','MALE',1,1,'inst','usr','pass',375,'srnm',1,1);

select *
from sinder.users
         inner join sinder.party_preferences on party_preferences.party_preference_id = users.user_party_preference_id
         inner join sinder.party_preferences_party_dates on party_preferences.party_preference_id =
                                                            party_preferences_party_dates.party_preferences_party_dates_party_preference_id
         inner join sinder.parties on party_preferences_party_dates.party_dates = parties.party_date
         left join party_matches pm on parties.party_id = pm.party_match_party_id and users.user_id = pm.party_match_guest_id
where parties.party_id = ?1
and (party_match_status IS NULL or party_match_status='REQUESTED');