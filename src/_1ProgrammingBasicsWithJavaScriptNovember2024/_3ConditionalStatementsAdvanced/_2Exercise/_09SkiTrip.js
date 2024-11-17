function skyTrip(days, roomsType, feedback) {
    const PRICE_FOR_ROOM_FOR_ONE_PERSON = 18.00;
    const PRICE_FOR_APARTMENT = 25.00;
    const PRICE_FOR_PRESIDENT_APARTMENT = 35.00;

    const DISCOUNT_FOR_APARTMENT_FOR_LESS_THAN_10_DAYS = 0.30;
    const DISCOUNT_FOR_APARTMENT_FOR_10_TO_15_DAYS = 0.35;
    const DISCOUNT_FOR_APARTMENT_FOR_MORE_THAN_15_DAYS = 0.50;

    const DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_LESS_THAN_10_DAYS = 0.10;
    const DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_10_TO_15_DAYS = 0.15;
    const DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_MORE_THAN_15_DAYS = 0.20;

    const INCREASE_FOR_POSITIVE_FEEDBACK = 0.25;
    const DISCOUNT_FOR_NEGATIVE_FEEDBACK = 0.10;

    const nights = days - 1;

    let totalPrice = 0.00;

    if (roomsType === "room for one person") {
        totalPrice = nights * PRICE_FOR_ROOM_FOR_ONE_PERSON;
    } else if (roomsType === "apartment") {
        totalPrice = nights * PRICE_FOR_APARTMENT;
        if (nights < 10) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_APARTMENT_FOR_LESS_THAN_10_DAYS);
        } else if (nights <= 15) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_APARTMENT_FOR_10_TO_15_DAYS);
        } else if (nights > 15) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_APARTMENT_FOR_MORE_THAN_15_DAYS);
        }
    } else if (roomsType === "president apartment") {
        totalPrice = nights * PRICE_FOR_PRESIDENT_APARTMENT;
        if (nights < 10) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_LESS_THAN_10_DAYS);
        } else if (nights <= 15) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_10_TO_15_DAYS);
        } else if (nights > 15) {
            totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_PRESIDENT_APARTMENT_FOR_MORE_THAN_15_DAYS);
        }
    }

    if (feedback === "positive") {
        totalPrice = totalPrice + (totalPrice * INCREASE_FOR_POSITIVE_FEEDBACK);
    } else if (feedback === "negative") {
        totalPrice = totalPrice - (totalPrice * DISCOUNT_FOR_NEGATIVE_FEEDBACK);
    }

    console.log(`${totalPrice.toFixed(2)}`);
}