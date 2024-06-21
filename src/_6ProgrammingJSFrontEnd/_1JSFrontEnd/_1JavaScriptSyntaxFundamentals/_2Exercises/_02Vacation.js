function solve(groupOfPeople, typeOfGroup, dayOfWeek) {
    let price = 0;
    if (typeOfGroup === 'Students') {
        if (dayOfWeek === 'Friday') {
            price = groupOfPeople * 8.45;
        } else if (dayOfWeek === 'Saturday') {
            price = groupOfPeople * 9.80;
        } else if (dayOfWeek === 'Sunday') {
            price = groupOfPeople * 10.46;
        }
        if (groupOfPeople >= 30) {
            price *= 0.85;
        }
    } else if (typeOfGroup === 'Business') {
        if (dayOfWeek === 'Friday') {
            price = groupOfPeople * 10.90;
        } else if (dayOfWeek === 'Saturday') {
            price = groupOfPeople * 15.60;
        } else if (dayOfWeek === 'Sunday') {
            price = groupOfPeople * 16.00;
        }
        if (groupOfPeople >= 100) {
            price /= groupOfPeople;
            price *= (groupOfPeople - 10);
        }
    } else if (typeOfGroup === 'Regular') {
        if (dayOfWeek === 'Friday') {
            price = groupOfPeople * 15.00;
        } else if (dayOfWeek === 'Saturday') {
            price = groupOfPeople * 20.00;
        } else if (dayOfWeek === 'Sunday') {
            price = groupOfPeople * 22.50;
        }
        if (groupOfPeople >= 10 && groupOfPeople <= 20) {
            price *= 0.95;
        }
    }
    console.log(`Total price: ${price.toFixed(2)}`)
}