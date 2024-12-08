function building(numberOfFloors, numberOfRoomsInFlores) {
    let letter = ' ';
    for (let floor = numberOfFloors; floor > 0; floor--) {
        if (floor === numberOfFloors) {
            letter = 'L';
        } else if (floor % 2 === 0) {
            letter = 'O';
        } else {
            letter = 'A';
        }
        let output = "";
        for (let room = 0; room < numberOfRoomsInFlores; room++) {
           output += letter + floor + room + " ";
        }
        console.log(`${output}`)
    }
}