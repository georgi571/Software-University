function excursionCalculator(numberOfPeople, season) {
    let pricePerPeople = 0.0;
    let totalPrice = 0.0;
    if (season === "spring") {
        if (numberOfPeople <= 5) {
            pricePerPeople = 50.00;
            totalPrice = numberOfPeople * pricePerPeople;
        } else if (numberOfPeople > 5) {
            pricePerPeople = 48.00;
            totalPrice = numberOfPeople * pricePerPeople;
        }
    } else if (season === "summer") {
        if (numberOfPeople <= 5) {
            pricePerPeople = 48.50;
            totalPrice = numberOfPeople * pricePerPeople;
            totalPrice = totalPrice * 0.85;
        } else if (numberOfPeople > 5) {
            pricePerPeople = 45.00;
            totalPrice = numberOfPeople * pricePerPeople;
            totalPrice = totalPrice * 0.85;
        }
    } else if (season === "autumn") {
        if (numberOfPeople <= 5) {
            pricePerPeople = 60.00;
            totalPrice = numberOfPeople * pricePerPeople;
        } else if (numberOfPeople > 5) {
            pricePerPeople = 49.50;
            totalPrice = numberOfPeople * pricePerPeople;
        }
    } else if (season === "winter") {
        if (numberOfPeople <= 5) {
            pricePerPeople = 86.00;
            totalPrice = numberOfPeople * pricePerPeople;
            totalPrice = totalPrice * 1.08;
        } else if (numberOfPeople > 5) {
            pricePerPeople = 85.00;
            totalPrice = numberOfPeople * pricePerPeople;
            totalPrice = totalPrice * 1.08;
        }
    }
    console.log(`${totalPrice.toFixed(2)} leva.`);
}

excursionCalculator(5,
"spring"
)
excursionCalculator(10,
"summer"
)
excursionCalculator(15,
"autumn"
)
excursionCalculator(20,
"winter"
)