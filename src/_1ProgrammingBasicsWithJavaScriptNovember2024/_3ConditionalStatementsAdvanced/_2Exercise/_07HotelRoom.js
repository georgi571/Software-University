function hotelRoom(month, numberOfNights) {
    const PRICE_PER_NIGHT_FOR_STUDIO_AT_MAY_AND_OCTOBER = 50.00;
    const PRICE_PER_NIGHT_FOR_STUDIO_AT_JUNE_AND_SEPTEMBER = 75.20;
    const PRICE_PER_NIGHT_FOR_STUDIO_AT_JULY_AND_AUGUST = 76.00;

    const PRICE_PER_NIGHT_FOR_APARTMENT_AT_MAY_AND_OCTOBER = 65.00;
    const PRICE_PER_NIGHT_FOR_APARTMENT_AT_JUNE_AND_SEPTEMBER = 68.70;
    const PRICE_PER_NIGHT_FOR_APARTMENT_AT_JULY_AND_AUGUST = 77.00;

    const DISCOUNT_FOR_STUDIO_AT_MAY_AND_OCTOBER_FOR_MORE_THAN_7_NIGHTS = 0.05;
    const DISCOUNT_FOR_STUDIO_AT_MAY_AND_OCTOBER_FOR_MORE_THAN_14_NIGHTS = 0.30;
    const DISCOUNT_FOR_STUDIO_AT_JUNE_AND_SEPTEMBER_FOR_MORE_THAN_14_NIGHTS = 0.20;
    const DISCOUNT_FOR_APARTMENT_AT_ALL_MONTHS_FOR_MORE_THAN_14_NIGHTS = 0.10;

    let priceForStudio = 0.00;
    let priceForApartment = 0.00;

    if (month === "May" || month === "October") {
        priceForStudio = numberOfNights * PRICE_PER_NIGHT_FOR_STUDIO_AT_MAY_AND_OCTOBER;
        priceForApartment = numberOfNights * PRICE_PER_NIGHT_FOR_APARTMENT_AT_MAY_AND_OCTOBER;
        if (numberOfNights > 14) {
            priceForStudio = priceForStudio - (priceForStudio * DISCOUNT_FOR_STUDIO_AT_MAY_AND_OCTOBER_FOR_MORE_THAN_14_NIGHTS);
            priceForApartment = priceForApartment - (priceForApartment * DISCOUNT_FOR_APARTMENT_AT_ALL_MONTHS_FOR_MORE_THAN_14_NIGHTS);
        } else if (numberOfNights > 7) {
            priceForStudio = priceForStudio - (priceForStudio * DISCOUNT_FOR_STUDIO_AT_MAY_AND_OCTOBER_FOR_MORE_THAN_7_NIGHTS);
        }
    } else if (month === "June" || month === "September") {
        priceForStudio = numberOfNights * PRICE_PER_NIGHT_FOR_STUDIO_AT_JUNE_AND_SEPTEMBER;
        priceForApartment = numberOfNights * PRICE_PER_NIGHT_FOR_APARTMENT_AT_JUNE_AND_SEPTEMBER;
        if (numberOfNights > 14) {
            priceForStudio = priceForStudio - (priceForStudio * DISCOUNT_FOR_STUDIO_AT_JUNE_AND_SEPTEMBER_FOR_MORE_THAN_14_NIGHTS);
            priceForApartment = priceForApartment - (priceForApartment * DISCOUNT_FOR_APARTMENT_AT_ALL_MONTHS_FOR_MORE_THAN_14_NIGHTS);
        }
    } else if (month === "July" || month === "August") {
        priceForStudio = numberOfNights * PRICE_PER_NIGHT_FOR_STUDIO_AT_JULY_AND_AUGUST;
        priceForApartment = numberOfNights * PRICE_PER_NIGHT_FOR_APARTMENT_AT_JULY_AND_AUGUST;
        if (numberOfNights > 14) {
            priceForApartment = priceForApartment - (priceForApartment * DISCOUNT_FOR_APARTMENT_AT_ALL_MONTHS_FOR_MORE_THAN_14_NIGHTS);
        }
    }

    console.log(`Apartment: ${priceForApartment.toFixed(2)} lv.`);
    console.log(`Studio: ${priceForStudio.toFixed(2)} lv.`);
}