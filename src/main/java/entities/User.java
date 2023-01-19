package entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@JsonSerialize
@NoArgsConstructor
public class User {
	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus;
}