package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories.Factory;

public interface Controller {

    String buildFactory(String factoryType, String factoryName);

    Factory getFactoryByName(String factoryName);
    String buildWorkshop(String workshopType, int woodCapacity);
    String addWorkshopToFactory(String factoryName, String workshopType);
    String buyWoodForFactory(String woodType);
    String addWoodToWorkshop(String factoryName, String workshopType, String woodType);
    String produceFurniture(String factoryName);
    String getReport();
}
