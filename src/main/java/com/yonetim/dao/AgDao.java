package com.yonetim.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

/**
 * tkeskin .
 */
@Component
public class AgDao {
  /**
   * verilen endpointe göre veri döner .
   *
   * @param endpoint .
   * @return .
   * @throws Exception .
   */
  public String istek(String endpoint) throws Exception {
    StringBuilder builder = new StringBuilder();

    URL url = new URL(endpoint);

    //verilen urlden connection aç...
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

    try {
      //byte olarak oku...
      InputStream inputStream = urlConnection.getInputStream();
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

      //char. olarak oku...
      InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      //tek bir satır olarak oku...
      String inputLine = bufferedReader.readLine();
      while (inputLine != null) {
        builder.append(inputLine);
        //yeni satır
        inputLine = bufferedReader.readLine();
      }
    } finally {
      urlConnection.disconnect();
    }
    return builder.toString();
  }
}
