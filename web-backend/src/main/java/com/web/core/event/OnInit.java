package com.web.core.event;

import com.web.app.persistence.domain.ServiceDomain;
import com.web.app.persistence.domain.amenity.AmenityDomain;
import com.web.app.persistence.domain.amenity.properties.JobDomain;
import com.web.app.persistence.repository.AmenityRepository;
import com.web.app.persistence.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class OnInit {

    private final AmenityRepository amenityRepository;

    private final ServiceRepository serviceRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent() {
        createAmenities();
        createServices();
    }

    private void createServices() {
        if (serviceRepository.count() == 0) {
            serviceRepository.saveAll(buildServices());
        }
    }

    private Set<ServiceDomain> buildServices() {
        return new HashSet<>() {{
            add(buildService("Тротуарная плитки", 550));
            add(buildService("По диагонали", 1500));
            add(buildService("На стене", 500));
            add(buildService("В туалетной комнате", 1300));
            add(buildService("В ванной", 500));
            add(buildService("Облицовка камнем", 500));
            add(buildService("Клинкерная плитки", 850));
            add(buildService("Керамическая плитки на фартук", 1500));
            add(buildService("Плитка мозаикой на фартук без подбора рисунка", 950));
            add(buildService("Укладка клинкерной плитки", 850));
            add(buildService("На полу", 1300));
            add(buildService("На лестнице", 1300));
            add(buildService("В совмещенном санузле", 1300));
            add(buildService("Гипсовая плитки", 550));
            add(buildService("На кухне", 1300));
            add(buildService("Декоративная плитки", 550));
            add(buildService("Керамическая плитки", 1000));
            add(buildService("На душевой поддон", 1300));
            add(buildService("Керамическая мозаика", 1300));
            add(buildService("На фартук", 1300));
            add(buildService("Стеклянная мозаика", 1300));
            add(buildService("Укладка тротуарной плитки", 550));
        }};

    }

    private ServiceDomain buildService(final String name, final int price) {
        final var service = new ServiceDomain();
        service.setName(name);
        service.setPrice(price);
        return service;
    }

    private void createAmenities() {
        if (amenityRepository.count() == 0) {
            amenityRepository.saveAll(buildAmenities());
        }
    }

    private Set<AmenityDomain> buildAmenities() {

        final var straightCutting = new AmenityDomain();
        straightCutting.setName("Прямая резка");
        straightCutting.setJobs(new HashSet<>() {{
            add(buildJob("Керамическая плитка", 100));
            add(buildJob("Керамогранит", 100));
            add(buildJob("Изготовление плинтусов", 150));
            add(buildJob("Гранит", 200));
            add(buildJob("Мрамор", 200));
            add(buildJob("Травертин", 200));
            add(buildJob("Оникс", 200));
            add(buildJob("Кварцит", 200));
        }});

        var waterJetCutting = new AmenityDomain();
        waterJetCutting.setName("Гидроабразивная резка");
        waterJetCutting.setJobs(new HashSet<>() {{
            add(buildJob("Керамическая плитка", 200));
            add(buildJob("Керамогранит", 300));
            add(buildJob("Гранит", 300));
            add(buildJob("Мрамор", 400));
            add(buildJob("Травертин", 300));
            add(buildJob("Оникс", 400));
            add(buildJob("Кварцит", 400));
        }});

        var diagonalCutting = new AmenityDomain();
        diagonalCutting.setName("Резка под 45' и 90'");
        diagonalCutting.setJobs(new HashSet<>() {{
            add(buildJob("Керамическая плитка", 350));
            add(buildJob("Керамогранит", 350));
            add(buildJob("Гранит", 400));
            add(buildJob("Мрамор", 400));
            add(buildJob("Травертин", 400));
            add(buildJob("Оникс", 400));
            add(buildJob("Кварцит", 300));
        }});

        var wideFormatCutting = new AmenityDomain();
        wideFormatCutting.setName("Широкоформатная плитка");
        wideFormatCutting.setJobs(new HashSet<>() {{
            add(buildJob("Прямой рез керамогранита", 300));
            add(buildJob("Резка под 45 градусов", 500));
            add(buildJob("Изготовление столешниц", 700));
        }});

        var holeRemoval = new AmenityDomain();
        holeRemoval.setName("Снятие отверстий");
        holeRemoval.setJobs(new HashSet<>() {{
            add(buildJob("20 диаметр", 200));
            add(buildJob("35 диаметр", 300));
            add(buildJob("50 диаметр", 400));
            add(buildJob("60 диаметр", 500));
            add(buildJob("70 диаметр", 500));
            add(buildJob("100 диаметр", 900));
            add(buildJob("120 диаметр", 1000));
        }});

        var cutting = new AmenityDomain();
        cutting.setName("Резка любой формы");
        cutting.setJobs(new HashSet<>() {{
            add(buildJob("Резка отверстий", 100));
            add(buildJob("Г-образная деталь", 500));
            add(buildJob("П-образная деталь", 1000));
            add(buildJob("Изготовление ступней", 150));
        }});

        return new HashSet<>() {{
            add(straightCutting);
            add(waterJetCutting);
            add(diagonalCutting);
            add(wideFormatCutting);
            add(holeRemoval);
            add(cutting);
        }};
    }

    private JobDomain buildJob(final String name, final int price) {
        var job = new JobDomain();
        job.setName(name);
        job.setPrice(price);
        return job;
    }
}
