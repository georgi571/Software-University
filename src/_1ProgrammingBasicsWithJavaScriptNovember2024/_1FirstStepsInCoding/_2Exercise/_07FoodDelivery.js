function foodDelivery(numberOfChickenMenu, numberOfFishMenu, numberOfVegetarianMenu) {
    const priceForChickenMenu = 10.35;
    const priceForFishMenu = 12.40;
    const priceForVegetarianMenu = 8.15;
    const percentForDesertPrice = 0.20;
    const priceForDelivery = 2.50;

    const sumForChickenMenu = numberOfChickenMenu * priceForChickenMenu;
    const sumForFishMenu = numberOfFishMenu * priceForFishMenu;
    const sumForVegetarianMenu = numberOfVegetarianMenu * priceForVegetarianMenu;

    const sumForAllMenu = sumForChickenMenu + sumForFishMenu + sumForVegetarianMenu;
    const sumForDeserts = sumForAllMenu * percentForDesertPrice;
    const totalSum = sumForAllMenu + sumForDeserts + priceForDelivery;

    console.log(totalSum);
}