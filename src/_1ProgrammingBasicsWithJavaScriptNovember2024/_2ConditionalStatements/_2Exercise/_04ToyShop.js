function toyShop(priceForTrip, numberOfPuzzles, numberOfDolls, numberOfBears, numberOfMinions, numberOfTrucks) {
    const PUZZLE_PRICE = 2.60;
    const DOLL_PRICE = 3.00;
    const BEAR_PRICE = 4.10;
    const MINION_PRICE = 8.20;
    const TRUCK_PRICE = 2.00;

    const DISCOUNT_PERCENT_FOR_BUYING_MORE_THAN_50_TOYS = 0.25;
    const PERCENT_FOR_RENT = 0.10;

    const numberOfToys = numberOfPuzzles + numberOfDolls + numberOfBears + numberOfMinions + numberOfTrucks;

    const puzzlePrice = numberOfPuzzles * PUZZLE_PRICE;
    const dollPrice = numberOfDolls * DOLL_PRICE;
    const bearPrice = numberOfBears * BEAR_PRICE;
    const minionPrice = numberOfMinions * MINION_PRICE;
    const truckPrice = numberOfTrucks * TRUCK_PRICE;

    let totalPrice = puzzlePrice + dollPrice + bearPrice + minionPrice + truckPrice;

    if (numberOfToys >= 50) {
        totalPrice -= totalPrice * DISCOUNT_PERCENT_FOR_BUYING_MORE_THAN_50_TOYS;
    }

    totalPrice -= totalPrice * PERCENT_FOR_RENT;

    const diff = Math.abs(totalPrice - priceForTrip);
    if (totalPrice >= priceForTrip) {
        console.log(`Yes! ${diff.toFixed(2)} lv left.`);
    } else {
        console.log(`Not enough money! ${diff.toFixed(2)} lv needed.`);
    }

}