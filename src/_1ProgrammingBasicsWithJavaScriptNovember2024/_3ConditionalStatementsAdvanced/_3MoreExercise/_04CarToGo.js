function carToGo(budget, season) {
    const CABRIO_ECONOMY_PRICE_PERCENT = 0.35;
    const CABRIO_COMPACT_PRICE_PERCENT = 0.45;
    const JEEP_ECONOMY_PRICE_PERCENT = 0.65;
    const JEEP_COMPACT_PRICE_PERCENT = 0.80;
    const JEEP_LUXORY_PRICE_PERCENT = 0.90;

    let carClass;
    let carType;
    let carPrice = 0.00;

    if (season === "Summer") {
        carType = "Cabrio";
        if (budget <= 100) {
            carClass = "Economy class";
            carPrice = budget * CABRIO_ECONOMY_PRICE_PERCENT;
        } else if (budget <= 500) {
            carClass = "Compact class";
            carPrice = budget * CABRIO_COMPACT_PRICE_PERCENT;
        } else if (budget > 500) {
            carClass = "Luxury class";
            carType = "Jeep";
            carPrice = budget * JEEP_LUXORY_PRICE_PERCENT;
        }
    } else if (season === "Winter") {
        carType = "Jeep";
        if (budget <= 100) {
            carClass = "Economy class";
            carPrice = budget * JEEP_ECONOMY_PRICE_PERCENT;
        } else if (budget <= 500) {
            carClass = "Compact class";
            carPrice = budget * JEEP_COMPACT_PRICE_PERCENT;
        } else if (budget > 500) {
            carClass = "Luxury class";
            carPrice = budget * JEEP_LUXORY_PRICE_PERCENT;
        }
    }

    console.log(`${carClass}`);
    console.log(`${carType} - ${carPrice.toFixed(2)}`);
}