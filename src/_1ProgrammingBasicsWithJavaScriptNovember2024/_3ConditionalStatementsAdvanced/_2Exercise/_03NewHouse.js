function newHouse(flowers, numberOfFlowers, budget) {
    const ROSES_PRICE = 5.00;
    const DAHLIAS_PRICE = 3.80;
    const TULIPS_PRICE = 2.80;
    const NARCISSUS_PRICE = 3.00;
    const GLADIOLUS_PRICE = 2.50;

    const DISCOUNT_IF_BUY_MORE_THAN_80_ROSES = 0.10;
    const DISCOUNT_IF_BUY_MORE_THAN_90_DAHLIAS = 0.15;
    const DISCOUNT_IF_BUY_MORE_THAN_80_TULIPS = 0.15;
    const INCREASE_IF_BUY_LESS_THAN_120_NARCISSUS = 0.15;
    const INCREASE_IF_BUY_LESS_THAN_80_GLADIOLUS = 0.20;

    let totalSum = 0.0;

    if (flowers === "Roses") {
        totalSum = numberOfFlowers * ROSES_PRICE;
        if (numberOfFlowers > 80) {
            totalSum = totalSum - (totalSum * DISCOUNT_IF_BUY_MORE_THAN_80_ROSES);
        }
    } else if (flowers === "Dahlias") {
        totalSum = numberOfFlowers * DAHLIAS_PRICE;
        if (numberOfFlowers > 90) {
            totalSum = totalSum - (totalSum * DISCOUNT_IF_BUY_MORE_THAN_90_DAHLIAS);
        }
    } else if (flowers === "Tulips") {
        totalSum = numberOfFlowers * TULIPS_PRICE;
        if (numberOfFlowers > 80) {
            totalSum = totalSum - (totalSum * DISCOUNT_IF_BUY_MORE_THAN_80_TULIPS);
        }
    } else if (flowers === "Narcissus") {
        totalSum = numberOfFlowers * NARCISSUS_PRICE;
        if (numberOfFlowers < 120) {
            totalSum = totalSum + (totalSum * INCREASE_IF_BUY_LESS_THAN_120_NARCISSUS);
        }
    } else if (flowers === "Gladiolus") {
        totalSum = numberOfFlowers * GLADIOLUS_PRICE;
        if (numberOfFlowers < 80) {
            totalSum = totalSum + (totalSum * INCREASE_IF_BUY_LESS_THAN_80_GLADIOLUS);
        }
    }

    const diff = Math.abs(budget - totalSum);

    if (budget >= totalSum) {
        console.log(`Hey, you have a great garden with ${numberOfFlowers} ${flowers} and ${diff.toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money, you need ${diff.toFixed(2)} leva more.`);
    }

}