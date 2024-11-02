function yardGreening(squareMeter) {
    const discount = 0.18;
    const pricePerOeSquareMeter = 7.61;
    const totalPrice = squareMeter * pricePerOeSquareMeter;
    const sumOfDiscount = totalPrice * discount;
    const totalPriceAfterDiscount = totalPrice - sumOfDiscount;

    console.log(`The final price is: ${totalPriceAfterDiscount} lv.`);
    console.log(`The discount is: ${sumOfDiscount} lv.`);
}