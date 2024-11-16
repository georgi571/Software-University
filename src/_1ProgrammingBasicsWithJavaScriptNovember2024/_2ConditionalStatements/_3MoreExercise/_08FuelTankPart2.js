function fuelTankPart2(fuel, liters, card) {
    const GASOLINE_PRICE_PER_LITER = 2.22;
    const DIESEL_PRICE_PER_LITER = 2.33;
    const GAS_PRICE_PER_LITER = 0.93;

    const DISCOUNT_WITH_CARD_FOR_LITER_GASOLINE = 0.18;
    const DISCOUNT_WITH_CARD_FOR_LITER_DIESEL = 0.12;
    const DISCOUNT_WITH_CARD_FOR_LITER_GAS = 0.08;

    const DISCOUNT_FOR_20_TO_25_LITER = 0.08;
    const DISCOUNT_FOR_MORE_THAN_25_LITER = 0.10;

    let fuelPricePerLiter = 0.00;

    if (fuel === "Diesel") {
        fuelPricePerLiter = DIESEL_PRICE_PER_LITER;
        if (card === "Yes") {
            fuelPricePerLiter -= DISCOUNT_WITH_CARD_FOR_LITER_DIESEL;
        }
    } else if (fuel === "Gasoline") {
        fuelPricePerLiter = GASOLINE_PRICE_PER_LITER;
        if (card === "Yes") {
            fuelPricePerLiter -= DISCOUNT_WITH_CARD_FOR_LITER_GASOLINE;
        }
    } else if (fuel === "Gas") {
        fuelPricePerLiter = GAS_PRICE_PER_LITER;
        if (card === "Yes") {
            fuelPricePerLiter -= DISCOUNT_WITH_CARD_FOR_LITER_GAS;
        }
    }

    let totalPrice = liters * fuelPricePerLiter;

    if (liters > 25) {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_MORE_THAN_25_LITER);
    } else if (liters >= 20) {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_20_TO_25_LITER);
    }

    console.log(`${totalPrice.toFixed(2)} lv.`);
}