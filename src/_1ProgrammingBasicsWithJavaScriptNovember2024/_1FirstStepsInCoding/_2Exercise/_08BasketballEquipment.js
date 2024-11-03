function basketballEquipment(annualFee) {
    const percentPriceForShoes = 0.60;
    const percentPriceForClothes = 0.80;
    const percentPriceForBall = 0.25;
    const percentPriceForAccessories = 0.20;

    const basketballShoes = annualFee * percentPriceForShoes;
    const basketballClothes = basketballShoes * percentPriceForClothes;
    const basketballBall = basketballClothes * percentPriceForBall;
    const basketballAccessories = basketballBall * percentPriceForAccessories;

    const totalSum = annualFee + basketballShoes + basketballClothes + basketballBall + basketballAccessories;
    console.log(totalSum);
}