package com.api.paycaratula.implementation;

import com.api.paycaratula.domain.Caratula;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CaratulaPDF {

    final String template_jasper = "caratulatemplate.jrxml";
    final String reportPath = "src/main/resources/caratulas/";

    public Mono<String> generar(Caratula caratula) throws IOException, JRException {

        File file = ResourceUtils.getFile("classpath:"+template_jasper);

        InputStream input = new FileInputStream(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(Collections.singleton(""));

        BufferedImage bannerPrincipal = ImageIO.read(new FileInputStream("src/main/resources/img/transporte.png"));
        BufferedImage bannerTomador = ImageIO.read(new FileInputStream("src/main/resources/img/hombre.png"));
        BufferedImage bannerSeguro = ImageIO.read(new FileInputStream("src/main/resources/img/choque.png"));
        BufferedImage bannerCoche = ImageIO.read(new FileInputStream("src/main/resources/img/coche.png"));
        BufferedImage bannerFirma = ImageIO.read(new FileInputStream("src/main/resources/img/firma.png"));

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Jeison Andres Hurtado");
        parameters.put("tomador", caratula.getTomador().getTomador());
        parameters.put("idenTomador", caratula.getTomador().getIdenTomador());
        parameters.put("correoTomador", caratula.getTomador().getCorreoTomador());
        parameters.put("telTomador", caratula.getTomador().getTelTomador());
        parameters.put("dirTomador", caratula.getTomador().getDirTomador());
        parameters.put("plan", caratula.getSeguro().getPoliza());
        parameters.put("poliza", caratula.getSeguro().getPoliza());
        parameters.put("valor", caratula.getSeguro().getValor());
        parameters.put("feinicio", caratula.getSeguro().getFeinicio());
        parameters.put("fefin", caratula.getSeguro().getFefin());
        parameters.put("placa", caratula.getVehiculo().getPlaca());
        parameters.put("modelo", caratula.getVehiculo().getModelo());
        parameters.put("marca", caratula.getVehiculo().getMarca());
        parameters.put("caracteristicas", caratula.getVehiculo().getCaracteristicas());
        parameters.put("clase", caratula.getVehiculo().getClase());
        parameters.put("servicio", caratula.getVehiculo().getServicio());
        parameters.put("motor", caratula.getVehiculo().getMotor());
        parameters.put("chasis", caratula.getVehiculo().getChasis());
        parameters.put("valAccesorios", caratula.getVehiculo().getValAccesorios());
        parameters.put("bannerPrincipal", bannerPrincipal);
        parameters.put("bannerTomador", bannerTomador);
        parameters.put("bannerSeguro", bannerSeguro);
        parameters.put("bannerCoche", bannerCoche);
        parameters.put("bannerFirma", bannerFirma);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);
        JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "Caratula_"+caratula.getTomador().getIdenTomador()+".pdf");
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        System.out.println("PDF File Generated !!");



        return Mono.just(Base64.getEncoder().encodeToString(pdfBytes));
    }
}
