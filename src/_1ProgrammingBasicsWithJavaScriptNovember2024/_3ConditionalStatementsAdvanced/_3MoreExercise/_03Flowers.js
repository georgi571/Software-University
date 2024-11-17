function flowers(numberOfChrysanthemums, numberOfRoses, numberOfTulips, season, dayIsHolidayOrNo) {
    const PRICE_FOR_CHRYSANTHEMUMS_AT_SPRING_AND_SUMMER = 2.00;
    const PRICE_FOR_CHRYSANTHEMUMS_AT_AUTUMN_AND_WINTER = 3.75;
    const PRICE_FOR_ROSES_AT_SPRING_AND_SUMMER = 4.10;
    const PRICE_FOR_ROSES_AT_AUTUMN_AND_WINTER = 4.50;
    const PRICE_FOR_TULIPS_AT_SPRING_AND_SUMMER = 2.50;
    const PRICE_FOR_TULIPS_AT_AUTUMN_AND_WINTER = 4.15;

    const PERCENT_INCREASE_FOR_HOLIDAYS = 0.15;

    const PERCENT_DISCOUNT_FOR_BOUQUET_IF_MORE_THAN_7_TULIPS_AT_SPRING = 0.05;
    const PERCENT_DISCOUNT_FOR_BOUQUET_IF_10_OR_MORE_ROSES_AT_WINTER = 0.10;
    const PERCENT_DISCOUNT_FOR_BOUQUET_IF_MORE_THAN_20_FLOWERS_AT_ALL_SEASONS = 0.20;

    const ARRANGE_PRICE = 2.00;

    let totalPrice = 0.0;

    let chrysanthemumPrice = 0.00;
    let rosesPrice = 0.00;
    let tulipsPrice = 0.00;

    if (season === "Spring") {
        chrysanthemumPrice = numberOfChrysanthemums * PRICE_FOR_CHRYSANTHEMUMS_AT_SPRING_AND_SUMMER;
        rosesPrice = numberOfRoses * PRICE_FOR_ROSES_AT_SPRING_AND_SUMMER;
        tulipsPrice = numberOfTulips * PRICE_FOR_TULIPS_AT_SPRING_AND_SUMMER;
        totalPrice = chrysanthemumPrice + rosesPrice + tulipsPrice;
        if (dayIsHolidayOrNo === 'Y') {
            totalPrice = totalPrice + (totalPrice * PERCENT_INCREASE_FOR_HOLIDAYS);
        }
        if (numberOfTulips > 7) {
            totalPrice = totalPrice - (totalPrice * PERCENT_DISCOUNT_FOR_BOUQUET_IF_MORE_THAN_7_TULIPS_AT_SPRING);
        }
    } else if (season === "Summer") {
        chrysanthemumPrice = numberOfChrysanthemums * PRICE_FOR_CHRYSANTHEMUMS_AT_SPRING_AND_SUMMER;
        rosesPrice = numberOfRoses * PRICE_FOR_ROSES_AT_SPRING_AND_SUMMER;
        tulipsPrice = numberOfTulips * PRICE_FOR_TULIPS_AT_SPRING_AND_SUMMER;
        totalPrice = chrysanthemumPrice + rosesPrice + tulipsPrice;
        if (dayIsHolidayOrNo === 'Y') {
            totalPrice = totalPrice + (totalPrice * PERCENT_INCREASE_FOR_HOLIDAYS);
        }
    } else if (season === "Autumn") {
        chrysanthemumPrice = numberOfChrysanthemums * PRICE_FOR_CHRYSANTHEMUMS_AT_AUTUMN_AND_WINTER;
        rosesPrice = numberOfRoses * PRICE_FOR_ROSES_AT_AUTUMN_AND_WINTER;
        tulipsPrice = numberOfTulips * PRICE_FOR_TULIPS_AT_AUTUMN_AND_WINTER;
        totalPrice = chrysanthemumPrice + rosesPrice + tulipsPrice;
        if (dayIsHolidayOrNo === 'Y') {
            totalPrice = totalPrice + (totalPrice * PERCENT_INCREASE_FOR_HOLIDAYS);
        }
    } else if (season === "Winter") {
        chrysanthemumPrice = numberOfChrysanthemums * PRICE_FOR_CHRYSANTHEMUMS_AT_AUTUMN_AND_WINTER;
        rosesPrice = numberOfRoses * PRICE_FOR_ROSES_AT_AUTUMN_AND_WINTER;
        tulipsPrice = numberOfTulips * PRICE_FOR_TULIPS_AT_AUTUMN_AND_WINTER;
        totalPrice = chrysanthemumPrice + rosesPrice + tulipsPrice;
        if (dayIsHolidayOrNo === 'Y') {
            totalPrice = totalPrice + (totalPrice * PERCENT_INCREASE_FOR_HOLIDAYS);
        }
        if (numberOfRoses >= 10) {
            totalPrice = totalPrice - (totalPrice * PERCENT_DISCOUNT_FOR_BOUQUET_IF_10_OR_MORE_ROSES_AT_WINTER);
        }
    }

    const flowersInBouquet = numberOfChrysanthemums + numberOfRoses + numberOfTulips;

    if (flowersInBouquet > 20) {
        totalPrice = totalPrice - (totalPrice * PERCENT_DISCOUNT_FOR_BOUQUET_IF_MORE_THAN_20_FLOWERS_AT_ALL_SEASONS);
    }

    totalPrice += ARRANGE_PRICE;

    console.log(`${totalPrice.toFixed(2)}`)
}