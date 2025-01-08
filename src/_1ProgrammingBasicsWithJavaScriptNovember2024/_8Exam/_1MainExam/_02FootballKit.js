function footballKit(priceOfTShirt, sumNeededForBall) {
    const priceOfShorts = priceOfTShirt * 0.75;
    const priceOfSocks = priceOfShorts * 0.20;
    const priceOfButtons = 2 * (priceOfTShirt + priceOfShorts);
    const totalSum = priceOfTShirt + priceOfShorts + priceOfSocks + priceOfButtons;
    const sumAfterDiscount = totalSum * 0.85;
    if (sumAfterDiscount >= sumNeededForBall) {
        console.log(`Yes, he will earn the world-cup replica ball!`);
        console.log(`His sum is ${sumAfterDiscount.toFixed(2)} lv.`);
    } else {
        const diff = sumNeededForBall - sumAfterDiscount;
        console.log(`No, he will not earn the world-cup replica ball.`);
        console.log(`He needs ${diff.toFixed(2)} lv. more.`);
    }
}

footballKit(25,
100
)

footballKit(55,
310
)

footballKit(59.99,
500
)