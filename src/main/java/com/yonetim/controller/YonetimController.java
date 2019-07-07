package com.yonetim.controller;

import com.yonetim.dto.BasvuruDTO;
import com.yonetim.dto.BasvuruSahibiDTO;
import com.yonetim.dto.BasvuruViewDTO;
import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.service.IYonetimService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * genel olarak parametreli ve parametresiz ornekler,post,get ve navigation .
 *
 */
@Controller
public class YonetimController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IYonetimService yonetimService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String read(Model model) {
        BasvuruSahibiDTO basvuruSahibiDTO = yonetimService.getId(1);
        model.addAttribute("yonetimDTO", basvuruSahibiDTO);
        return "start";
    }

    //object olarak dönüş,ResponseBody örneği...
    @RequestMapping(value = "/object", method = RequestMethod.GET)
    @ResponseBody
    public BasvuruSahibiDTO send(Model model) {
        BasvuruSahibiDTO basvuruSahibiDTO = yonetimService.getId(1);
        model.addAttribute("yonetimDTO", basvuruSahibiDTO);
        return basvuruSahibiDTO;
    }

    @RequestMapping(value = "/saveYonetim", method = RequestMethod.POST)
    public String saveYonetim(@ModelAttribute BasvuruViewDTO basvuruViewDTO) {
        try {
            yonetimService.existApplicant(basvuruViewDTO.getTc());
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
        }
        BasvuruSahibiDTO basvuruSahibiDTO = new BasvuruSahibiDTO();
        basvuruSahibiDTO.setAd(basvuruViewDTO.getAd());
        basvuruSahibiDTO.setSoyad(basvuruViewDTO.getSoyad());
        basvuruSahibiDTO.setTc(basvuruViewDTO.getTc());
        basvuruSahibiDTO.setCep(basvuruViewDTO.getCep());
        basvuruSahibiDTO.setEposta(basvuruViewDTO.getEposta());

        BasvuruDTO basvuruDTO = new BasvuruDTO();
        basvuruDTO.setAciklama(basvuruViewDTO.getAciklama());
        basvuruDTO.setBasvuruTuru(basvuruViewDTO.getBasvuruTuru());
        basvuruDTO.setCevapTuru(basvuruViewDTO.getCevapTuru());
        basvuruDTO.setUnvan(basvuruViewDTO.getUnvan());
        basvuruDTO.setDate(new Date());
        basvuruSahibiDTO.addBasvuru(basvuruDTO);

        try {
            yonetimService.save(basvuruSahibiDTO);
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
        }
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET, headers = {"content-type=text/json"})
    public String readJSON() {
        return "start";
    }

    @RequestMapping(value = "/addYonetim", method = RequestMethod.GET)
    public String addYonetim() {
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=blue"})
    public String readBlue() {
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=silver"})
    public ModelAndView readSilver() {
        BasvuruSahibiDTO basvuruSahibiDTO = yonetimService.getId(3);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start");
        modelAndView.addObject("yonetimDTO", basvuruSahibiDTO);
        return modelAndView;
    }

    //@RequestMapping(value = "/start", method = RequestMethod.POST) alttaki notasyon yeni hali ikiside aynı aslında
    @PostMapping("/start")
    public String create() {
        return "start";
    }

    //domain end-point olarak ayarlanır
    @RequestMapping("")
    public String index() {
        logger.info("Kullanıcı geldi");
        return "login";
    }

    //domain end-point olarak ayarlanır ...com/start
    @RequestMapping("/start")
    public String start() {
        return "start";
    }

    //getmapping örneği...
    @GetMapping("/ara1")
    public String ara1(@RequestParam(value = "arama", required = true, defaultValue = "") String aranacak) {
        String son = aranacak + "";
        return "start";
    }

    //getmapping örneği,front-end obje olarak geldi...
    @GetMapping("/araManuel")
    public ModelAndView araManuel(@RequestParam Map<String, String> requestParam) {
        int son = requestParam.size();
        String aranacak = requestParam.get("arama");
        ModelAndView modelAndView = new ModelAndView();
        List<SahipDTO> list = new ArrayList<SahipDTO>();
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

    //getmapping örneği,front-end obje olarak geldi...
    @GetMapping("/ara")
    public ModelAndView ara(@RequestParam Map<String, String> requestParam) {
        logger.debug("Arama başladı...");
        int son = requestParam.size();
        String aranacak = requestParam.get("arama");
        ModelAndView modelAndView = new ModelAndView();
        List<PlantDTO> list = new ArrayList<PlantDTO>();
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

    @RequestMapping("/basvuru")
    public String go(Model model) {
        model.addAttribute("basvuru", new BasvuruViewDTO());
        return "basvuru";
    }

    @RequestMapping("/islemler")
    public ModelAndView showYonetim() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Iterable<BasvuruDTO> yonetimDTOS = yonetimService.fetchAllYonetim();
            modelAndView.setViewName("islemler");
            modelAndView.addObject("yonetim", yonetimDTOS);
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
        }
        return modelAndView;
    }
}