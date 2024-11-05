function vegetableMarket(priceForVegetables, priceForFruits, kgForVegetables, kgForFruits) {
    const totalPriceForVegetables = priceForVegetables * kgForVegetables;
    const totalPriceForFruits = priceForFruits * kgForFruits;
    const totalPrice = totalPriceForFruits + totalPriceForVegetables;
    const priceInEuro = totalPrice / 1.94;

    console.log(`${priceInEuro.toFixed(2)}`)
}