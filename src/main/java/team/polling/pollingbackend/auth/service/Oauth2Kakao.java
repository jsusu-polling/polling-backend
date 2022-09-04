package team.polling.pollingbackend.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import team.polling.pollingbackend.auth.dto.Kakao;
import org.springframework.http.HttpHeaders;

@Service
@RequiredArgsConstructor
public class Oauth2Kakao {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String kakaoOauth2ClientId = "8aac3bd7d302e49db68923a6ebc79048";
    private final String kakaoOauth2ClientSecret = "ZLCIgJ177NEkFYNbsH7UjNVhIRa8kJMA";
    private final String frontendRedirectUrl = "http://localhost:3000/login";
    private final String kakaoUrl = "https://kapi.kakao.com/v2/user/me";
    private final String kakaoTokenUrl = "https://kauth.kakao.com/oauth/token";

    public Kakao callTokenApi(String code) {
        String grantType = "authrization_code";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("client_id", kakaoOauth2ClientId);
        params.add("client_secret", kakaoOauth2ClientSecret);
        params.add("redirect_uri", frontendRedirectUrl);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(kakaoTokenUrl, request, String.class);
            return objectMapper.readValue(response.getBody(), Kakao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 추후 오류 메시지 수정
        return null;
    }

    public String callGetUserByAccessToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(kakaoUrl, request, String.class);
        return response.getBody();
    }

}
