function garage(input) {
    let garage = {};
    for (let inputElement of input) {
        let garageNumber = inputElement.split(' - ')[0];
        if (!garage[garageNumber]) {
            garage[garageNumber] = [];
        }
        let carInfo = inputElement.split(' - ')[1].split(', ');
        let car = [];
        for (let carInfoElement of carInfo) {
            let element = carInfoElement.split(': ');
            let specific = element[0] + ' - ' + element[1];
            car.push(specific);
        }
        garage[garageNumber].push(car);
    }
    for (let garageKey in garage) {
        console.log(`Garage № ${garageKey}`);
        for (let garageElementKey of garage[garageKey]) {
            console.log(`--- ${garageElementKey.join(', ')}`);
        }
    }
}