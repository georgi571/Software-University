function vacation(numberOfPeople, groupOfPeople, dayOfWeek) {
    let priceForGroup = 0.0;
    if (groupOfPeople === "Students") {
        if (dayOfWeek === "Friday") {
            priceForGroup = numberOfPeople * 8.45;
        } else if (dayOfWeek === "Saturday") {
            priceForGroup = numberOfPeople * 9.80;
        } else if (dayOfWeek === "Sunday") {
            priceForGroup = numberOfPeople * 10.46;
        }
        if (numberOfPeople >= 30) {
            priceForGroup = priceForGroup * 0.85;
        }
    } else if (groupOfPeople === "Business") {
        if (numberOfPeople >= 100) {
            numberOfPeople = numberOfPeople - 10;
        }
        if (dayOfWeek === "Friday") {
            priceForGroup = numberOfPeople * 10.90;
        } else if (dayOfWeek === "Saturday") {
            priceForGroup = numberOfPeople * 15.60;
        } else if (dayOfWeek === "Sunday") {
            priceForGroup = numberOfPeople * 16.00;
        }
    } else if (groupOfPeople === "Regular") {
        if (dayOfWeek === "Friday") {
            priceForGroup = numberOfPeople * 15.00;
        } else if (dayOfWeek === "Saturday") {
            priceForGroup = numberOfPeople * 20.00;
        } else if (dayOfWeek === "Sunday") {
            priceForGroup = numberOfPeople * 22.50;
        }
        if (numberOfPeople >= 10 && numberOfPeople <= 20) {
            priceForGroup = priceForGroup * 0.95;
        }
    }
    console.log(`Total price: ${priceForGroup.toFixed(2)}`);
}