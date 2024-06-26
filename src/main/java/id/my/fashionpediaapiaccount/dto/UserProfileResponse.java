package id.my.fashionpediaapiaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private Integer id;

    private String cartId;

    private String email;
    private String userName;
    private String address;
    private String phoneNumber;
    private String about;
}