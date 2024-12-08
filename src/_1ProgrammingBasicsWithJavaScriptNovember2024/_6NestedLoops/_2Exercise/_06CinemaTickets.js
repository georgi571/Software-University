function cinemaTickets(input) {
    let command = input[0];

    let studentsTicket = 0;
    let standardTicket = 0;
    let kidTicket = 0;

    let index = 1;

    while (command !== "Finish") {
        const movieName = command;
        const numberOfSeats = input[index++];

        let soldTicketsForThisMovie = 0;

        while (soldTicketsForThisMovie < numberOfSeats) {
            const ticketsType = input[index++];

            if (ticketsType === "End") {
                break;
            }

            soldTicketsForThisMovie++;

            if (ticketsType === "student") {
                studentsTicket++;
            } else if (ticketsType === "standard") {
                standardTicket++;
            } else if (ticketsType === "kid") {
                kidTicket++;
            }
        }

        const percentSoldTickets = soldTicketsForThisMovie / numberOfSeats * 100;

        console.log(`${movieName} - ${percentSoldTickets.toFixed(2)}% full.`)

        command = input[index++];
    }

    const totalTickets = studentsTicket + standardTicket + kidTicket;
    console.log(`Total tickets: ${totalTickets}`);

    const percentStudentTickets = studentsTicket / totalTickets * 100;
    const percentStandardTickets = standardTicket / totalTickets * 100;
    const percentKidTickets = kidTicket / totalTickets * 100;

    console.log(`${percentStudentTickets.toFixed(2)}% student tickets.`);
    console.log(`${percentStandardTickets.toFixed(2)}% standard tickets.`);
    console.log(`${percentKidTickets.toFixed(2)}% kids tickets.`);
}