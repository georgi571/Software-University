package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.common;

public class ExceptionMessages {

    public static final String FACTORY_NAME_NULL_OR_EMPTY = "Factory name cannot be null or empty.";
    public static final String FACTORY_EXISTS = "Factory with this name already exists.";
    public static final String FACTORY_DO_NOT_PRODUCED = "This time %s factory did not produce anything.";
    public static final String INVALID_FACTORY_TYPE = "Invalid factory type.";
    public static final String INVALID_WORKSHOP_TYPE = "Invalid workshop type.";
    public static final String WORKSHOP_EXISTS = "Workshop of this type already exists in this factory.";
    public static final String WORKSHOP_EXISTS_IN_REPOSITORY = "Workshop of this type already exists in the repository.";
    public static final String WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO = "Can not build workshop with zero or less wood quantity.";
    public static final String NON_SUPPORTED_WORKSHOP = "This factory does not support this type of workshop.";
    public static final String INSUFFICIENT_WOOD = "Insufficient wood quantity. This workshop cannot start production.";
    public static final String WORKSHOP_STOPPED_WORKING = "%s stopped working due to running out of wood.";
    public static final String NO_WORKSHOP_FOUND = "There is no workshop of type %s in repository.";
    public static final String NO_WOOD_FOUND = "There is no %s in wood repository.";
    public static final String INVALID_WOOD_TYPE = "Invalid wood type.";
    public static final String THERE_ARE_NO_WORKSHOPS = "There are no added workshops in %s factory to produce furniture.";
}
