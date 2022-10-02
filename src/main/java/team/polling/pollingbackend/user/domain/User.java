package team.polling.pollingbackend.user.domain;

import lombok.*;
import team.polling.pollingbackend.common.domain.BaseTime;

import javax.persistence.*;

@Entity(name = "user")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User extends BaseTime {

    @Id @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String profileImage;

    // 소셜 아이디에 대한 암호화 방식 적용
    private Long kakaoId;

    // 회원 등록
    public static User createUser(Long kakaoId, String name, String profileImage) {
        return User.builder().kakaoId(kakaoId).name(name).profileImage(profileImage).build();
    }
}
