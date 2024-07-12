function sequences(input) {
    let arrays = {};
    for (let inputElement of input) {
        let numbers = JSON.parse(inputElement).sort((a,b) => b - a);
        let key = numbers.toString();
        arrays[key] = numbers;
    }
    let sortedArrays = Object.values(arrays).sort((a, b) => a.length - b.length);
    for (let arraysKey in sortedArrays) {
        console.log(`[${sortedArrays[arraysKey].join(', ')}]`);
    }
}