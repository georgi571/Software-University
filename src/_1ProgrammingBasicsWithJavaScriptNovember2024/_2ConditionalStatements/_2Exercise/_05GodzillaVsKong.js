function godzillaVsKong(budged, numberOfActors, priceForClothesForOneActor) {
    const PERCENT_FOR_DECOR_PRICE = 0.10;
    const PERCENT_DISCOUNT_FOR_MORE_THAN_150_ACTORS = 0.10;

    const priceForDecor = budged * PERCENT_FOR_DECOR_PRICE;
    let priceForClothes = priceForClothesForOneActor * numberOfActors;

    if (numberOfActors > 150) {
        priceForClothes -= priceForClothes * PERCENT_DISCOUNT_FOR_MORE_THAN_150_ACTORS;
    }

    const totalPrice = priceForClothes + priceForDecor;
    const diff = Math.abs(budged - totalPrice);

    if (totalPrice <= budged) {
        console.log(`Action!`);
        console.log(`Wingard starts filming with ${diff.toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money!`);
        console.log(`Wingard needs ${diff.toFixed(2)} leva more.`);
    }
}