function fishingBoat(budged, season, numberOfFisher) {
    const SPRING_PRICE = 3000.00;
    const SUMMER_AND_AUTUMN_PRICE = 4200.00;
    const WINTER_PRICE = 2600.00;

    const DISCOUNT_FOR_GROUP_FROM_1_TO_6_PEOPLE = 0.10;
    const DISCOUNT_FOR_GROUP_FROM_7_TO_12_PEOPLE = 0.15;
    const DISCOUNT_FOR_GROUP_FOR_MORE_THAN_12_PEOPLE = 0.25;

    const DISCOUNT_FOR_GROUP_OF_PEOPLE_IF_THEY_ARE_EVEN_UNLESS_SEASON_IS_AUTUMN = 0.05;

    let totalPrice = 0.0;
    if (season === "Spring") {
        totalPrice = SPRING_PRICE;
    } else if (season === "Winter") {
        totalPrice = WINTER_PRICE;
    } else if (season === "Summer" || season === "Autumn") {
        totalPrice = SUMMER_AND_AUTUMN_PRICE;
    }

    if (numberOfFisher <= 6) {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_GROUP_FROM_1_TO_6_PEOPLE);
    } else if (numberOfFisher <= 12) {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_GROUP_FROM_7_TO_12_PEOPLE);
    } else if (numberOfFisher > 12) {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_GROUP_FOR_MORE_THAN_12_PEOPLE);
    }

    if (numberOfFisher %2 === 0 && season !== "Autumn") {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_GROUP_OF_PEOPLE_IF_THEY_ARE_EVEN_UNLESS_SEASON_IS_AUTUMN);
    }

    const diff = Math.abs(budged - totalPrice);

    if (budged >= totalPrice) {
        console.log(`Yes! You have ${diff.toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money! You need ${diff.toFixed(2)} leva.`);
    }
}