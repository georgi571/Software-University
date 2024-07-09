function towns(input) {
    let towns = [];
    for (let inputElement of input) {
        const [townName, latitude, longitude] = inputElement.toString().split(' | ');
        const town = {
            town: townName,
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2),
        }
        towns.push(town);
    }
    for (let town of towns) {
        console.log(town);
    }
}