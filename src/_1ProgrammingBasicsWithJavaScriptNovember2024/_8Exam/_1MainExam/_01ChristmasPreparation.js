function christmasPreparation(rollOfPaper, rollOfFabric, litersOfGlue, percentDiscount) {
    const priceForPaper = rollOfPaper * 5.80;
    const priceForFabric = rollOfFabric * 7.20;
    const priceForGlue = litersOfGlue * 1.20;
    const totalSum = priceForGlue + priceForFabric + priceForPaper;
    const sumAfterDiscount = totalSum * ((100 - percentDiscount) / 100.00);
    console.log(`${sumAfterDiscount.toFixed(3)}`);
}

christmasPreparation(2,
3,
2.5,
25
)

christmasPreparation(4,
2,
5,
13
)

christmasPreparation(7,
8,
0.5,
45,
)