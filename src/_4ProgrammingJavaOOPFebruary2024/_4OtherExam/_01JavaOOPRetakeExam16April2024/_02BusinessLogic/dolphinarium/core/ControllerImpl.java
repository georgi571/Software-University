package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.common.ConstantMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.repositories.FoodRepository;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.BottleNoseDolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.Dolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.SpinnerDolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.SpottedDolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Herring;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Mackerel;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Squid;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.pools.DeepWaterPool;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.pools.Pool;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.pools.ShallowWaterPool;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

//TODO Implement all methods
public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new ArrayList<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool;
        if (poolType.equals("DeepWaterPool")) {
            pool = new DeepWaterPool(poolName);
        } else if (poolType.equals("ShallowWaterPool")) {
            pool = new ShallowWaterPool(poolName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_POOL_TYPE);
        }
        for (Pool poll : this.pools) {
            if (poll.getName().equals(poolName)) {
                throw new NullPointerException(ExceptionMessages.POOL_EXISTS);
            }
        }
        this.pools.add(pool);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Squid")) {
            food = new Squid();
        } else if (foodType.equals("Herring")) {
            food = new Herring();
        } else if (foodType.equals("Mackerel")) {
            food = new Mackerel();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Food food = this.foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }
        for (Pool poll : this.pools) {
            if (poll.getName().equals(poolName)) {
                poll.addFood(food);
                this.foodRepository.remove(food);
                break;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Dolphin dolphin;
        Pool currentPool = null;
        for (Pool pool : this.pools) {
            if (pool.getName().equals(poolName)) {
                currentPool = pool;
            }
        }
        if (dolphinType.equals("BottleNoseDolphin")) {
            dolphin = new BottleNoseDolphin(dolphinName, energy);
        } else if (dolphinType.equals("SpottedDolphin")) {
            dolphin = new SpottedDolphin(dolphinName, energy);
        } else if (dolphinType.equals("SpinnerDolphin")) {
            dolphin = new SpinnerDolphin(dolphinName, energy);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOLPHIN_TYPE);
        }
        for (Dolphin pollDolphin : currentPool.getDolphins()) {
            if (pollDolphin.getName().equals(dolphinName)) {
                throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_EXISTS);
            }
        }
        if (dolphinType.equals("BottleNoseDolphin") && currentPool.getClass().getSimpleName().equals("ShallowWaterPool")) {
            return String.format(ConstantMessages.POOL_NOT_SUITABLE);
        } else if (dolphinType.equals("SpinnerDolphin") && currentPool.getClass().getSimpleName().equals("DeepWaterPool")) {
            return String.format(ConstantMessages.POOL_NOT_SUITABLE);
        }
        currentPool.addDolphin(dolphin);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL,dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Food currentFood = null;
        Pool currentPool = null;
        for (Pool pool : this.pools) {
            if (pool.getName().equals(poolName)) {
                currentPool = pool;
                break;
            }
        }
        for (Food currentPoolFood : currentPool.getFoods()) {
            if (currentPoolFood.getClass().getSimpleName().equals(food)) {
                currentFood = currentPoolFood;
                break;
            }
        }
        if (currentFood == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }
        for (Dolphin dolphin : currentPool.getDolphins()) {
            dolphin.eat(currentFood);
        }
        currentPool.getFoods().remove(currentFood);
        return String.format(ConstantMessages.DOLPHINS_FED, currentPool.getDolphins().size(), poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        Pool currentPool = null;
        for (Pool pool : this.pools) {
            if (pool.getName().equals(poolName)) {
                currentPool = pool;
            }
        }
        if (currentPool.getDolphins().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_DOLPHINS);
        }
        int currentRemove = 0;
        Collection<Dolphin> forRemove = new ArrayList<>();
        for (Dolphin dolphin : currentPool.getDolphins()) {
            dolphin.jump();
            if (dolphin.getEnergy() <= 0) {
                forRemove.add(dolphin);
                currentRemove++;
            }
        }
        for (int i = 0; i < forRemove.size(); i++) {
            currentPool.removeDolphin(forRemove.iterator().next());
        }
        return String.format(ConstantMessages.DOLPHINS_PLAY, poolName, currentRemove);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Pool pool : this.pools) {
            statistics.append(String.format(ConstantMessages.DOLPHINS_FINAL,pool.getName())).append(System.lineSeparator());
            if (pool.getDolphins().isEmpty()) {
                statistics.append(String.format(ConstantMessages.NONE)).append(System.lineSeparator());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (Dolphin dolphin : pool.getDolphins()) {
                    stringBuilder.append(String.format("%s - %s", dolphin.getName(), dolphin.getEnergy()));
                    stringBuilder.append(ConstantMessages.DELIMITER);
                }
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                statistics.append(stringBuilder).append(System.lineSeparator());
            }
        }
        return statistics.toString().trim();
    }
}
