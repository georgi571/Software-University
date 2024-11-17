function bikeRace(numberOfJuniors, numberOfSeniors, typeOfTrace) {
    const MONEY_FROM_JUNIOR_IN_TRAIL = 5.50;
    const MONEY_FROM_JUNIOR_IN_CROSS_COUNTRY = 8.00;
    const MONEY_FROM_JUNIOR_IN_DOWNHILL = 12.25;
    const MONEY_FROM_JUNIOR_IN_ROAD = 20.00;

    const MONEY_FROM_SENIOR_IN_TRAIL = 7.00;
    const MONEY_FROM_SENIOR_IN_CROSS_COUNTRY = 9.50;
    const MONEY_FROM_SENIOR_IN_DOWNHILL = 13.75;
    const MONEY_FROM_SENIOR_IN_ROAD = 21.50;

    const DISCOUNT_FOR_50_OR_MORE_BIKERS_FOR_CROSS_COUNTRY = 0.25;
    const PERCENT_FOR_EXPENSES = 0.05;

    let totalMoney = 0;
    if (typeOfTrace === "trail") {
        totalMoney = numberOfJuniors * MONEY_FROM_JUNIOR_IN_TRAIL + numberOfSeniors * MONEY_FROM_SENIOR_IN_TRAIL;
    } else if (typeOfTrace === "cross-country") {
        totalMoney = numberOfJuniors * MONEY_FROM_JUNIOR_IN_CROSS_COUNTRY + numberOfSeniors * MONEY_FROM_SENIOR_IN_CROSS_COUNTRY;
        if (numberOfJuniors + numberOfSeniors >= 50) {
            totalMoney = totalMoney - (totalMoney * DISCOUNT_FOR_50_OR_MORE_BIKERS_FOR_CROSS_COUNTRY);
        }
    } else if (typeOfTrace === "downhill") {
        totalMoney = numberOfJuniors * MONEY_FROM_JUNIOR_IN_DOWNHILL + numberOfSeniors * MONEY_FROM_SENIOR_IN_DOWNHILL;
    } else if (typeOfTrace === "road") {
        totalMoney = numberOfJuniors * MONEY_FROM_JUNIOR_IN_ROAD + numberOfSeniors * MONEY_FROM_SENIOR_IN_ROAD;
    }

    const expenses = totalMoney * PERCENT_FOR_EXPENSES;
    const moneyForCharity = totalMoney - expenses;

    console.log(`${moneyForCharity.toFixed(2)}`);
}