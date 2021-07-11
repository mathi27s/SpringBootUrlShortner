package com.urlshortner.springbootapp.service;

import com.urlshortner.springbootapp.dto.ShortnerDto;
import com.urlshortner.springbootapp.model.ShortnerEntity;
import com.urlshortner.springbootapp.repository.ShortnerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ShortnerServiceTest {
    private static String testWebsite = "https://www.hackerrank.com/competitions/celebrate-pride-2021-coding-contest";

    @Mock
    ShortnerRepository mockShortnerRepository;

    @InjectMocks
    ShortnerService shortnerService;


    @InjectMocks
    ShortnerDto mockShortnerDto;

    private ShortnerEntity setShortEntity(){
        ShortnerEntity url = new ShortnerEntity();
        url.setId((long) 6);
        url.setLongid(testWebsite);
        return url;
    }



    @Test
    public void encodeUrlLong() {
        String encoded = shortnerService.url_encode((long) 10);
        Assert.assertEquals("k", encoded);

    }

    @Test
    public void decodeShortUrl(){
        String longUrl_id = shortnerService.decodeShortUrl("l").toString();
        Assert.assertEquals("11", longUrl_id);
    }

    @Test
    public void testCreateShortUrl(){

        //TODO
        //yet to be implemented
//        when(mockShortnerRepository.save(any(ShortnerEntity.class))).thenReturn(setShortEntity());
//        when(mockShortnerDto.getLongUrl()).thenReturn(testWebsite);
//        Assert.assertEquals("qwerty", shortnerService.convertUrlToShort(mockShortnerDto));



    }
}