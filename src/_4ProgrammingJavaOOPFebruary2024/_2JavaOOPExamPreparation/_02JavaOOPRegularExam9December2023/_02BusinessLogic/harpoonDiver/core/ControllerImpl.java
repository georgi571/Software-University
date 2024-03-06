package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver.DeepWaterDiver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver.Diver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver.OpenWaterDiver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver.WreckDiver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diving.Diving;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diving.DivingImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.divingSite.DivingSite;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.divingSite.DivingSiteImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.repositories.DiverRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.repositories.DivingSiteRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private final Repository<Diver> diverRepository;
    private final Repository<DivingSite> divingSiteRepository;
    private int divingCount;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.divingCount = 0;
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        if (kind.equals("DeepWaterDiver")) {
            diver = new DeepWaterDiver(diverName);
        } else if (kind.equals("OpenWaterDiver")) {
            diver = new OpenWaterDiver(diverName);
        } else if (kind.equals("WreckDiver")) {
            diver = new WreckDiver(diverName);
        } else {
            throw new IllegalArgumentException(String.format(DIVER_INVALID_KIND));
        }
        diverRepository.add(diver);
        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures) {
            divingSite.getSeaCreatures().add(seaCreature);
        }
        this.divingSiteRepository.add(divingSite);
        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = this.diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }
        this.diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        Collection<Diver> divers = this.diverRepository.getCollection().stream().filter(diver -> diver.getOxygen() > 30).collect(Collectors.toList());
        if (divers.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }
        DivingSite divingSite = this.divingSiteRepository.byName(siteName);
        Diving diving = new DivingImpl();
        diving.searching(divingSite, divers);
        int removeDivers = 0;
        for (Diver diver : divers) {
            if (diver.getOxygen() == 0) {
                removeDivers++;
            }
        }
        this.divingCount++;
        return String.format(SITE_DIVING, siteName, removeDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(FINAL_DIVING_SITES, divingCount)).append(System.lineSeparator());
        statistics.append(String.format(FINAL_DIVERS_STATISTICS)).append(System.lineSeparator());
        for (Diver diver : this.diverRepository.getCollection()) {
            statistics.append(String.format(FINAL_DIVER_NAME, diver.getName())).append(System.lineSeparator());
            statistics.append(String.format(FINAL_DIVER_OXYGEN, diver.getOxygen())).append(System.lineSeparator());
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()) {
                statistics.append(String.format(FINAL_DIVER_CATCH, "None")).append(System.lineSeparator());
            } else {
                statistics.append(String.format(FINAL_DIVER_CATCH, String.join(FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures()))).append(System.lineSeparator());
            }
        }
        return statistics.toString().trim();
    }
}