package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022._02BusinessLogic.fairyShop.models;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument instrument : helper.getInstruments()) {
            while (!instrument.isBroken() && helper.canWork() && !present.isDone()) {
                helper.work();
                present.getCrafted();
                instrument.use();
            }
        }
    }
}
