function matchTickets(budget, category, numberOfPeople) {
    const VIP_TICKET_PRICE = 499.99;
    const NORMAL_TICKET_PRICE = 249.99;

    const PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_1_TO_4 = 0.75;
    const PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_5_TO_9 = 0.60;
    const PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_10_TO_24 = 0.50;
    const PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_25_TO_49 = 0.40;
    const PERCENT_FOR_TRANSPORT_IF_PEOPLE_MORE_THAN_50 = 0.25;

    let moneyLeftForTickets = 0.00;

    if (numberOfPeople <= 4) {
        moneyLeftForTickets = budget - (budget * PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_1_TO_4);
    } else if (numberOfPeople <= 9) {
        moneyLeftForTickets = budget - (budget * PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_5_TO_9);
    } else if (numberOfPeople <= 24) {
        moneyLeftForTickets = budget - (budget * PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_10_TO_24);
    } else if (numberOfPeople <= 49) {
        moneyLeftForTickets = budget - (budget * PERCENT_FOR_TRANSPORT_IF_PEOPLE_FROM_25_TO_49);
    } else if (numberOfPeople > 50) {
        moneyLeftForTickets = budget - (budget * PERCENT_FOR_TRANSPORT_IF_PEOPLE_MORE_THAN_50);
    }

    let totalTicketPrice = 0.00;
    if (category === "VIP") {
        totalTicketPrice = numberOfPeople * VIP_TICKET_PRICE;
    } else if (category === "Normal") {
        totalTicketPrice = numberOfPeople * NORMAL_TICKET_PRICE;
    }

    const diff = Math.abs(moneyLeftForTickets - totalTicketPrice);

    if (moneyLeftForTickets >= totalTicketPrice) {
        console.log(`Yes! You have ${diff.toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money! You need ${diff.toFixed(2)} leva.`);
    }
}