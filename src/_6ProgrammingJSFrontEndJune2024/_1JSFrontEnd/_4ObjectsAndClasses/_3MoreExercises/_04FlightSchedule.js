function flightSchedule(input) {
    let flights = [];
    for (const inputElementKey of input[0]) {
        const flightInformation = inputElementKey.split(' ');
        const flight = {
            flightNumber: flightInformation[0],
            flightDestination: inputElementKey.substring(flightInformation[0].length + 1),
            flightStatus: 'Ready to fly',
        }
        flights.push(flight);
    }
    for (const inputElementKey of input[1]) {
        const flightInformation = inputElementKey.split(' ');
        const flight = flights.find(flight => flight.flightNumber === flightInformation[0]);
        if (flight) {
            flight.flightStatus = flightInformation[1];
        }
    }
    for (let flight of flights) {
        if (flight.flightStatus === input[2][0]) {
            console.log(`{ Destination: '${flight.flightDestination}', Status: '${flight.flightStatus}' }`)
        }
    }
}