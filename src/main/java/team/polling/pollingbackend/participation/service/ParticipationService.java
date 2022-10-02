package team.polling.pollingbackend.participation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.polling.pollingbackend.participation.repository.ParticipationRepository;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    
}
