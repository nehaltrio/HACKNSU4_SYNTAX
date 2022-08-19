package com.example.hacknsu4_trafficapp.Controllers;

import com.example.hacknsu4_trafficapp.Models.Bus;
import com.example.hacknsu4_trafficapp.Models.BusOwner;
import com.example.hacknsu4_trafficapp.Models.GetRequiredBus;
import com.example.hacknsu4_trafficapp.Models.Route;
import com.example.hacknsu4_trafficapp.Repositories.BusOwnerRepo;
import com.example.hacknsu4_trafficapp.Repositories.BusQrRepo;
import com.example.hacknsu4_trafficapp.Repositories.BusRepo;
import com.example.hacknsu4_trafficapp.Repositories.BusRouteRepo;
import com.example.hacknsu4_trafficapp.SecurityConfigs.BusOwnerDetails;
import com.example.hacknsu4_trafficapp.Utills.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BusOwnerRepo busOwnerRepo;

    @Autowired
    BusQrRepo busQrRepo;

    @Autowired
    BusRepo busRepo;

    @Autowired
    BusRouteRepo busRouteRepo;

    @GetMapping("/")
    public String viewLandingPage() {
        return "index";
    }

    @GetMapping("/bus_owner/login")
    public String viewBusOwnerLoginPage() {
        return "bus_owner/bus_owner_login";
    }


    @GetMapping("/bus_owner_register")
    public String launchBusOwnerRegPage(Model model) {
        model.addAttribute("bus_owner", new BusOwner());
        return "bus_owner/bus_owner_register";
    }

    @RequestMapping("/bus_owner_registration_process")
    public String processBusOwnerRegister(BusOwner busOwner) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(busOwner.getBusOwnerPass());
        busOwner.setBusOwnerPass(encodedPassword);

        busOwnerRepo.save(busOwner);

        return "bus_owner/bus_owner_login";
    }

//    @GetMapping("/bus_owner_home")
//    public String showBusOwnerHome() {
//        return "bus_owner/bus_owner_home";
//    }


    @GetMapping("/bus_info")
    public String launchBusDataInputPage(Model model, @AuthenticationPrincipal BusOwnerDetails busOwnerDetails, Bus bus) {

        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        model.addAttribute("owner", busOwner);
        model.addAttribute("bus", bus);
        return "bus_info/bus_details";
    }


    @RequestMapping("/bus_info_update_process")
    public String processBusInfo(Bus bus, @AuthenticationPrincipal BusOwnerDetails busOwnerDetails) {
        BusOwner busOwner = busOwnerRepo.find_bus_owner(busOwnerDetails.getUsername());
        bus.setOwnerName(busOwner.getBusOwnerName());
        busRepo.save(bus);
        return "redirect:/";
    }


    @PostMapping(value = "/genrateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQRCode(Bus bus, @RequestParam String busName)
            throws Exception {

        bus = busRepo.findBus(busName);
        String codeText = bus.toString();


        return okResponse(QRCodeGenerator.getQRCodeImage(codeText));
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    @GetMapping("/bus")
    public String findBusByLocation() {
        System.out.println("RUN BUS");
        return "bus.html";
    }

    @RequestMapping("/searchBus")
    public String bus(@ModelAttribute GetRequiredBus getRequiredBus, Model model) {
        String loc = getRequiredBus.getLocation();
        String dest = getRequiredBus.getDestination();

        List<Route> busRouteList = busRouteRepo.findBus(loc, dest);

        model.addAttribute("busList", busRouteList);

        return "result.html";
    }

}
