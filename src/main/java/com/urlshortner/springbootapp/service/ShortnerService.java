package com.urlshortner.springbootapp.service;

import com.urlshortner.springbootapp.dto.ShortnerDto;
import com.urlshortner.springbootapp.model.ShortnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.urlshortner.springbootapp.repository.ShortnerRepository;

import java.util.Optional;


@Service
public class ShortnerService {
    private static final String BASE64STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final char[] CHARSET = BASE64STRING.toCharArray();

    public Long decodeShortUrl(String url) {
        Long i = 0L;
        char[] chars = url.toCharArray();
        for(char c : chars){
            i = i * BASE64STRING.length() + BASE64STRING.indexOf(c);
        }
        return i;
    }

    public String url_encode(Long id) {
        StringBuilder shortUrl = new StringBuilder();
        Long i = id;
        while(i > 0){
            Integer rem = Math.toIntExact(i % BASE64STRING.length());
            i /=  BASE64STRING.length();
            shortUrl.append(CHARSET[rem]);
        }
        return shortUrl.reverse().toString();
    }

    @Autowired
    ShortnerRepository shortnerRespository;

    public String convertUrlToShort(ShortnerDto dto) {
        if (dto.getLongUrl().isEmpty()) {
            return "LongUrl is Not Valid";
        }
        
        ShortnerEntity shortnerEntity = new ShortnerEntity(dto.getLongUrl());

        shortnerRespository.save(shortnerEntity);
        Long id = shortnerEntity.getId();
        String shortUrl = url_encode(id);
        shortnerEntity.setShortid(url_encode(id));
        shortnerRespository.save(shortnerEntity);
        return shortUrl;
    }

    public Optional<String> getLongUrl(String id) {
        Long decodedId = decodeShortUrl(id);
        Optional<ShortnerEntity> shortnerEntity = shortnerRespository.findById(decodedId);
        if(shortnerEntity.isPresent()) {
            return Optional.of(shortnerEntity.get().getLongid());
        }
        return  Optional.empty();

    }
}
