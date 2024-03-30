package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.models.*;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.repositories.HelperRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.repositories.PresentRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.repositories.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;
    private int presentsDone;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.presentsDone = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        this.helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = this.presentRepository.findByName(presentName);
        Collection<Helper> helpers = this.helperRepository.getModels().stream().filter(helper -> helper.getEnergy() > 50).collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        Shop shop = new ShopImpl();
        String result = "not done";
        for (Helper helper : helpers) {
            shop.craft(present, helper);
            if (present.isDone()) {
                result = "done";
                break;
            }
        }
        int count = 0;
        for (Helper helper : helpers) {
            for (Instrument instrument : helper.getInstruments()) {
                if (instrument.isBroken()) {
                    count++;
                }
            }
        }
        if (result.equals("done")) {
            this.presentsDone++;
        }
        return String.format(PRESENT_DONE + COUNT_BROKEN_INSTRUMENTS, presentName, result ,count) ;
    }

    @Override
    public String report() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%d presents are done!", this.presentsDone)).append(System.lineSeparator());
        info.append("Helpers info:").append(System.lineSeparator());
        for (Helper model : this.helperRepository.getModels()) {
            info.append(String.format("Name: %s", model.getName())).append(System.lineSeparator());
            info.append(String.format("Energy: %s", model.getEnergy())).append(System.lineSeparator());
            int counter = 0;
            for (Instrument instrument : model.getInstruments()) {
                if (!instrument.isBroken()) {
                    counter++;
                }
            }
            info.append(String.format("Instruments: %d not broken left", counter)).append(System.lineSeparator());
        }
        return info.toString().trim();
    }
}
