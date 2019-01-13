package com.yonetim;

import com.yonetim.dto.SahipDTO;
import com.yonetim.service.IYonetimService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class YonetimServiceTest {

    @Autowired
    IYonetimService yonetimService;
    List<SahipDTO> list;

    @Test
    public void kayitlariKontrolEt(){
        given();
        when();
        then();
    }

    private void given() {

    }

    //kayitAl cengiz gönderdi , listeye 1 kayıt eklendi
    private void when() {
        //list = yonetimService.kayitAl("cengiz");

    }

    //gelen listedeki kayıt sayısını kontrol et
    private void then() {
        assertEquals("gelen kayıt sayısı",1,list.size());
    }

}
