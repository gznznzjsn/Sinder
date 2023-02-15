package com.solvd.laba.sinder.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    private Boolean phoneNumber;
    private Boolean instagramLink;
    private Boolean facebookLink;

}
