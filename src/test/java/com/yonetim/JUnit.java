package com.yonetim;

import org.junit.*;

import static org.junit.Assert.*;

public class JUnit {

    @BeforeClass
    public static void ayarlar(){
        int i = 1 + 1;
    }


    //her testten önce çalışır
    @Before
    public void ayar(){
        int i = 1 + 1;
    }

    //i değeri 2 eşit mi diye bakılıyor
    @Test
    public void runTest(){
        int i = 1 + 1;
        //eşitlik
        assertEquals(2,i);
        Object o = null;
        //null kontrol
        assertNull(o);
        //true false
        assertTrue(4 + 2 == 6);
    }

    //i değeri 2 eşit mi diye bakılıyor
    @Test
    public void runTest2(){
        int i = 1 - 1;
        assertEquals(2,i);

    }

    //fail alanları ignore eder
    @Ignore
    @Test
    public void failCalis(){
        fail();
    }

    @AfterClass
    public static void ayarlarSonra(){
        int i = 1 + 1;
    }


    //her testten önce çalışır
    @After
    public void ayarSonra(){
        int i = 1 + 1;
    }
}
