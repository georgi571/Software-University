function petsNoExpireTime(days, totalKgOfFood, kgOfFoodDogEatPerDay, kgOfFoodCatEatPerDay, gramsOfFoodTurtleEatPerDay) {
    const foodInGrams = totalKgOfFood * 1000;
    const foodInGramsForDog = kgOfFoodDogEatPerDay * 1000;
    const foodInGramsForCat = kgOfFoodCatEatPerDay * 1000;

    const gramsOfFoodNeededForDog = days * foodInGramsForDog;
    const gramsOfFoodNeededForCat = days * foodInGramsForCat;
    const gramsOfFoodNeededForTurtle = days * gramsOfFoodTurtleEatPerDay;

    const totalFoodNeededInGrams = gramsOfFoodNeededForDog + gramsOfFoodNeededForCat + gramsOfFoodNeededForTurtle;

    const leftFood = Math.floor((foodInGrams - totalFoodNeededInGrams) / 1000);
    const neededFood = Math.ceil((totalFoodNeededInGrams - foodInGrams) / 1000);

    if (foodInGrams >= totalFoodNeededInGrams) {
        console.log(`${leftFood}  kilos of food left.`);
    } else {
        console.log(`${neededFood}  more kilos of food are needed.`);
    }
}