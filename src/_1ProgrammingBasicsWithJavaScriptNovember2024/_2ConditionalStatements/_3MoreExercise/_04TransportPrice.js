function transportPrice(km, dayTime) {
    const TAXI_START_MONEY = 0.70;
    const TAXI_PER_KM_AT_DAY = 0.79;
    const TAXI_PER_KM_AT_NIGHT = 0.90;
    const BUS_PER_KM = 0.09;
    const TRAIN_PER_KM = 0.06;
    const MINIMUM_KM_TO_USE_BUS = 20;
    const MINIMUM_KM_TO_USE_TRAIN = 100;

    let totalPrice = 0.00;

    if (km >= MINIMUM_KM_TO_USE_TRAIN) {
        totalPrice = km *  TRAIN_PER_KM;
    } else if (km >= MINIMUM_KM_TO_USE_BUS) {
        totalPrice = km * BUS_PER_KM;
    } else {
        if (dayTime === "day") {
            totalPrice = km * TAXI_PER_KM_AT_DAY + TAXI_START_MONEY;
        } else if (dayTime === "night") {
            totalPrice = km * TAXI_PER_KM_AT_NIGHT + TAXI_START_MONEY;
        }
    }

    console.log(`${totalPrice.toFixed(2)}`);
}