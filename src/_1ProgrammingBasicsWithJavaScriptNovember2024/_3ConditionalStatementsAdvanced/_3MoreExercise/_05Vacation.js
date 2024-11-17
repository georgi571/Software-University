function vacation(budget, season) {
    const ALASKA_CAMP_PRICE_PERCENT = 0.65;
    const ALASKA_HUT_PRICE_PERCENT = 0.80;
    const ALASKA_HOTEL_PRICE_PERCENT = 0.90;
    const MOROCCO_CAMP_PRICE_PERCENT = 0.45;
    const MOROCCO_HUT_PRICE_PERCENT = 0.60;
    const MOROCCO_HOTEL_PRICE_PERCENT = 0.90;

    let placeToStay;
    let countryToStay;
    let priceToStay = 0.00;

    if (season === "Summer") {
        countryToStay = "Alaska";
        if (budget <= 1000) {
            placeToStay = "Camp";
            priceToStay = budget * ALASKA_CAMP_PRICE_PERCENT;
        } else if (budget <= 3000) {
            placeToStay = "Hut";
            priceToStay = budget * ALASKA_HUT_PRICE_PERCENT;
        } else if (budget > 3000) {
            placeToStay = "Hotel";
            priceToStay = budget * ALASKA_HOTEL_PRICE_PERCENT;
        }
    } else if (season === "Winter") {
        countryToStay = "Morocco";
        if (budget <= 1000) {
            placeToStay = "Camp";
            priceToStay = budget * MOROCCO_CAMP_PRICE_PERCENT;
        } else if (budget <= 3000) {
            placeToStay = "Hut";
            priceToStay = budget * MOROCCO_HUT_PRICE_PERCENT;
        } else if (budget > 3000) {
            placeToStay = "Hotel";
            priceToStay = budget * MOROCCO_HOTEL_PRICE_PERCENT;
        }
    }

    console.log(`${countryToStay} - ${placeToStay} - ${priceToStay.toFixed(2)}`);
}