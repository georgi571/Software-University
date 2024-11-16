function flowerShop(numberOfMagnolia, numberOfHyacinth, numberOfRose, numberOfCactus, priceForGift) {
    const PRICE_PER_MAGNOLIA = 3.25;
    const PRICE_PER_HYACINTH = 4.00;
    const PRICE_PER_ROSE = 3.50;
    const PRICE_PER_CACTUS = 8.00;

    const TAXES = 0.05;

    const priceForMagnolia = numberOfMagnolia * PRICE_PER_MAGNOLIA;
    const priceForHyacinth = numberOfHyacinth * PRICE_PER_HYACINTH;
    const priceForRose = numberOfRose * PRICE_PER_ROSE;
    const priceForCactus = numberOfCactus * PRICE_PER_CACTUS;

    const totalPrice = priceForMagnolia + priceForHyacinth + priceForRose + priceForCactus;
    const totalPriceAfterTax = totalPrice - (totalPrice * TAXES);

    const moneyLeft = Math.floor(totalPriceAfterTax - priceForGift);
    const moneyNeeded = Math.ceil(priceForGift - totalPriceAfterTax);

    if (totalPriceAfterTax >= priceForGift) {
        console.log(`She is left with ${moneyLeft} leva.`);
    } else {
        console.log(`She will have to borrow ${moneyNeeded} leva.`);
    }
}