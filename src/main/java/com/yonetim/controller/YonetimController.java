package com.yonetim.controller;

import com.yonetim.dto.BasvuruDto;
import com.yonetim.dto.BasvuruSahibiDto;
import com.yonetim.dto.BasvuruViewDto;
import com.yonetim.dto.PlantDto;
import com.yonetim.dto.SahipDto;
import com.yonetim.payload.LoginRequest;
import com.yonetim.service.IYonetimService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * genel olarak parametreli ve parametresiz ornekler,post,get ve navigation .
 */

@Controller
public class YonetimController {
  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IYonetimService yonetimService;

  /**
   * @param model .
   * @return .
   */
  @RequestMapping(value = "/start", method = RequestMethod.GET)
  public String read(Model model) {
    BasvuruSahibiDto basvuruSahibiDto = yonetimService.getId(1);
    model.addAttribute("yonetimDTO", basvuruSahibiDto);
    return "start";
  }

  /**
   * @param model .
   * @return .
   */
  //object olarak dönüş,ResponseBody örneği...
  @RequestMapping(value = "/object", method = RequestMethod.GET)
  @ResponseBody
  public BasvuruSahibiDto send(Model model) {
    BasvuruSahibiDto basvuruSahibiDto = yonetimService.getId(1);
    model.addAttribute("yonetimDTO", basvuruSahibiDto);
    return basvuruSahibiDto;
  }

  /**
   * @param basvuruViewDto .
   * @return .
   */
  @RequestMapping(value = "/saveYonetim", method = RequestMethod.POST)
  public String saveYonetim(@ModelAttribute BasvuruViewDto basvuruViewDto) {
    try {
      yonetimService.existApplicant(basvuruViewDto.getTc());
    } catch (Exception e) {
      logger.debug(e.getLocalizedMessage());
    }
    BasvuruSahibiDto basvuruSahibiDto = new BasvuruSahibiDto();
    basvuruSahibiDto.setAd(basvuruViewDto.getAd());
    basvuruSahibiDto.setSoyad(basvuruViewDto.getSoyad());
    basvuruSahibiDto.setTc(basvuruViewDto.getTc());
    basvuruSahibiDto.setCep(basvuruViewDto.getCep());
    basvuruSahibiDto.setEposta(basvuruViewDto.getEposta());

    BasvuruDto basvuruDto = new BasvuruDto();
    basvuruDto.setAciklama(basvuruViewDto.getAciklama());
    basvuruDto.setBasvuruTuru(basvuruViewDto.getBasvuruTuru());
    basvuruDto.setCevapTuru(basvuruViewDto.getCevapTuru());
    basvuruDto.setUnvan(basvuruViewDto.getUnvan());
    basvuruDto.setDate(new Date());
    basvuruSahibiDto.addBasvuru(basvuruDto);

    try {
      yonetimService.save(basvuruSahibiDto);
    } catch (Exception e) {
      logger.debug(e.getLocalizedMessage());
    }
    return "start";
  }

  /**
   * @return .
   */
  @RequestMapping(value = "/start", method = RequestMethod.GET,
      headers = {"content-type=text/json"})
  public String readJson() {
    return "start";
  }

  /**
   * @return .
   */
  @RequestMapping(value = "/addYonetim", method = RequestMethod.GET)
  public String addYonetim() {
    return "start";
  }

  /**
   * @return .
   */
  @RequestMapping(value = "/start", method = RequestMethod.GET,
      params = {"loyalty=blue"})
  public String readBlue() {
    return "start";
  }

  /**
   * @return .
   */
  @RequestMapping(value = "/start", method = RequestMethod.GET,
      params = {"loyalty=silver"})
  public ModelAndView readSilver() {
    BasvuruSahibiDto basvuruSahibiDto = yonetimService.getId(3);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("start");
    modelAndView.addObject("yonetimDTO", basvuruSahibiDto);
    return modelAndView;
  }

  /**
   * @return .
   */
  //@RequestMapping(value = "/start", method = RequestMethod.POST)
  // alttaki notasyon yeni hali ikiside aynı aslında
  @PostMapping("/start")
  public String create() {
    return "start";
  }

  /**
   * @return .
   */
  //domain end-point olarak ayarlanır
  @RequestMapping("")
  public ModelAndView index() {
    logger.info("Kullanıcı geldi");
    LoginRequest loginRequest = new LoginRequest();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    modelAndView.addObject("loginRequest", loginRequest);
    return modelAndView;
  }

  /**
   * @return .
   */
  //domain end-point olarak ayarlanır ...com/start
  @RequestMapping("/start")
  public String start() {
    return "start";
  }

  /**
   * @param aranacak .
   * @return .
   */
  //getmapping örneği...
  @GetMapping("/ara1")
  public String ara1(@RequestParam(value = "arama", required = true,
      defaultValue = "") String aranacak) {
    String son = aranacak + "";
    return "start";
  }

  /**
   * @param requestParam .
   * @return .
   */
  //getmapping örneği,front-end obje olarak geldi...
  @GetMapping("/araManuel")
  public ModelAndView araManuel(@RequestParam Map<String, String> requestParam) {
    int son = requestParam.size();
    String aranacak = requestParam.get("arama");
    ModelAndView modelAndView = new ModelAndView();
    List<SahipDto> list = new ArrayList<SahipDto>();
    try {
      list = yonetimService.kayitAlManuel(aranacak);
      modelAndView.setViewName("start");
      //modelAndView.addObject("sahipDTO",list);
    } catch (Exception e) {
      logger.debug(e.getLocalizedMessage());
      modelAndView.setViewName("error");
    }
    modelAndView.addObject("sahipDTO", list);
    return modelAndView;
  }

  /**
   * @param requestParam .
   * @return .
   */
  //getmapping örneği,front-end obje olarak geldi...
  @GetMapping("/ara")
  public ModelAndView ara(@RequestParam Map<String, String> requestParam) {
    logger.debug("Arama başladı...");
    int son = requestParam.size();
    String aranacak = requestParam.get("arama");
    ModelAndView modelAndView = new ModelAndView();
    List<PlantDto> list = new ArrayList<PlantDto>();
    try {
      list = yonetimService.kayitAl(aranacak);
      logger.info("Sonuç = " + list.size());
      logger.warn("Sonuç = " + list.size());
      modelAndView.setViewName("start");
      if (list.size() == 0) {
        logger.warn("Arama sonucu bulunamadı = " + aranacak);
      }
      //modelAndView.addObject("sahipDTO",list);
    } catch (Exception e) {
      logger.error("Arama yaparken hata aldı", e);
      logger.debug(e.getLocalizedMessage());
      modelAndView.setViewName("error");
    }
    modelAndView.addObject("sahipDTO", list);
    logger.info("Arama bitti...");
    return modelAndView;
  }

  /**
   * @param model .
   * @return .
   */
  @RequestMapping("/basvuru")
  public String go(Model model) {
    model.addAttribute("basvuru", new BasvuruViewDto());
    return "basvuru";
  }

  /**
   * @return .
   */
  @RequestMapping("/islemler")
  public ModelAndView showYonetim() {
    ModelAndView modelAndView = new ModelAndView();
    try {
      Iterable<BasvuruDto> yonetimDtos = yonetimService.fetchAllYonetim();
      modelAndView.setViewName("islemler");
      modelAndView.addObject("yonetim", yonetimDtos);
    } catch (Exception e) {
      logger.debug(e.getLocalizedMessage());
    }
    return modelAndView;
  }
}