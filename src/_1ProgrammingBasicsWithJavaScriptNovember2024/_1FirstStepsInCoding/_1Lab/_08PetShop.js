function petShop(numberOfDogFood, numberOfCatFood) {
    const priceForDogFood = 2.50;
    const priceForCatFood = 4;

    const sumForDogFood = numberOfDogFood* priceForDogFood;
    const sumForCatFood = numberOfCatFood * priceForCatFood;

    const totalSum = sumForDogFood + sumForCatFood;

    console.log(`${totalSum} lv.`);
}