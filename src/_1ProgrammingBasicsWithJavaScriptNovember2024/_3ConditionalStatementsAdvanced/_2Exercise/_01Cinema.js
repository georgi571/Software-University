function cinema(type, numberOfRows, numberOfColumns) {
    const PREMIERE_PRICE = 12.00;
    const NORMAL_PRICE = 7.50;
    const DISCOUNT_PRICE = 5.00;

    const numberOfSeats = numberOfRows * numberOfColumns;

    let totalPrice = 0;

    if (type === "Premiere") {
        totalPrice = numberOfSeats * PREMIERE_PRICE;
    } else if (type === "Normal") {
        totalPrice = numberOfSeats * NORMAL_PRICE;
    } else if (type === "Discount") {
        totalPrice = numberOfSeats * DISCOUNT_PRICE;
    }

    console.log(`${totalPrice.toFixed(2)}`);
}