package team.polling.pollingbackend.user.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team.polling.pollingbackend.auth.dto.Kakao;
import team.polling.pollingbackend.auth.service.Oauth2Kakao;
import team.polling.pollingbackend.user.domain.User;
import team.polling.pollingbackend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Oauth2Kakao oauth2Kakao;

    public ResponseEntity<User> oauth2Kakao(String code) {
        Kakao kakao = oauth2Kakao.callTokenApi(code);
        String userInfoFromKakao = oauth2Kakao.callGetUserByAccessToken(kakao.getAccess_token());

        JSONParser parser = new JSONParser();
        JSONObject obj = new JSONObject();

        try {
            obj = (JSONObject) parser.parse(userInfoFromKakao);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long kakaoId = (Long) obj.get("id");
        JSONObject properties = (JSONObject) obj.get("properties");
        String nickname = (String) properties.get("nickname");
        String profileImage = (String) properties.get("profile_image");

        User user = User.createUser(kakaoId, nickname, profileImage);
        return validateDuplicateUser(user, kakao.getAccess_token());
    }

    private ResponseEntity<User> validateDuplicateUser(User user, String token) {
        User targetUser = userRepository.findUserByKakaoId(user.getKakaoId());
        User temp = null;

        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        if (targetUser != temp) {
            userRepository.save(targetUser);
            return new ResponseEntity<User>(targetUser, headers, HttpStatus.OK);
        } else {
            userRepository.save(user);
            return new ResponseEntity<User>(user, headers, HttpStatus.OK);
        }
    }

}
