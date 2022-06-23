package com.extrawest.limitsmicroservice.service.impl;

import com.extrawest.limitsmicroservice.dto.request.LimitRequestDTO;
import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;
import com.extrawest.limitsmicroservice.mapper.LimitMapper;
import com.extrawest.limitsmicroservice.model.Limit;
import com.extrawest.limitsmicroservice.repository.LimitRepository;
import com.extrawest.limitsmicroservice.service.LimitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LimitServiceImpl implements LimitService {

    private LimitRepository limitRepository;
    private LimitMapper limitMapper;

    @Override
    public LimitResponseDTO createLimit(LimitRequestDTO limitRequestDTO) {
        Limit limit = limitMapper.toLimitModel(limitRequestDTO);
        return limitMapper.toResponseDTO(limitRepository.save(limit));
    }

    @Override
    public void deleteLimit(Long id) {
        limitRepository.delete(limitMapper.toLimitModel(getLimitById(id)));
    }

    @Override
    public LimitResponseDTO updateLimit(Long id, LimitRequestDTO limitRequestDTO) {
        Limit limit = limitMapper.toLimitModel(limitRequestDTO);
        return limitMapper.toResponseDTO(limitRepository.save(limit));
    }

    @Override
    public List<LimitResponseDTO> getAllLimits() {
        List<LimitResponseDTO> limitResponseDTOS = new ArrayList<>();
        List<Limit> limitList = limitRepository.findAll();
        for (Limit limit:limitList) {
            limitResponseDTOS.add(limitMapper.toResponseDTO(limit));
        }
        return limitResponseDTOS;
    }

    @Override
    public LimitResponseDTO getLimitById(Long id) {
        return limitMapper.toResponseDTO(limitRepository.findById(id).orElseThrow());
    }
}
