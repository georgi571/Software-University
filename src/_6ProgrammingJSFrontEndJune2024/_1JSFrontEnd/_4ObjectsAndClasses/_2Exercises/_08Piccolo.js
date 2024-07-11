function piccolo(input) {
    let parking = [];
    for (let inputElement of input) {
        const infoAboutCar = inputElement.split(', ');
        if (infoAboutCar[0] === 'IN' && !parking.includes(infoAboutCar[1])) {
            parking.push(infoAboutCar[1]);
        } else if (infoAboutCar[0] === 'OUT') {
            parking = parking.filter(car => car !== infoAboutCar[1]);
        }
    }
    if (parking.length !== 0) {
        parking.sort((a, b) => a.localeCompare(b));
        for (let parkingElement of parking) {
            console.log(parkingElement);
        }
    } else {
        console.log('Parking Lot is Empty');
    }
}